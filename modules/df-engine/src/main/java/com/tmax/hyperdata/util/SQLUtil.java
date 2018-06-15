package com.tmax.hyperdata.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import com.m.msl.logger.MLogger;
import com.tmax.hyperdata.config.TbHdConfig;
import com.tmax.hyperdata.error.TbHdError;
import com.tmax.hyperdata.error.TbHdException;
import com.tmax.tbhub.data.BaseModel;
import com.tmax.tbhub.data.ModelExternalParametersDocument.ModelExternalParameters;
import com.tmax.tbhub.header.TExternalParameter;
import com.tmax.tbhub.request.TVariableAssignments;

/**
 * @author HongsuRyu (hongsu_ryu@tmaxdata.com) 2015. 6. 26.
 * @version $Id: SQLUtil.java 11 2017-12-07 03:24:29Z taebo $
 */

/**
 * FIXME class description.
 */
public class SQLUtil {

    private static final char NULL = '\0';

    private static final int STATE_START = 0; /* start state */
    private static final int STATE_1 = 1; /* 1 state -> '/' */
    private static final int STATE_2 = 2; /* 2 state -> '/' */
    private static final int STATE_3 = 3; /* 3 state -> '/ XXX' */
    private static final int STATE_4 = 4; /* 4 state -> '-' */
    private static final int STATE_5 = 5; /* 5 state -> '--' */
    private static final int STATE_6 = 6; /* 6 state -> '\'' */
    private static final int STATE_DONE = 10; /* done state */

    public static final int STMT_UNKNOWN = 0;
    public static final int STMT_QUERY = 0x10;
    public static final int STMT_DML = 0x20;
    public static final int STMT_DML_DELETE = 0x21;
    public static final int STMT_DML_UPDATE = 0x22;
    public static final int STMT_DML_INSERT = 0x24;
    public static final int STMT_DML_MERGE = 0x28;
    public static final int STMT_DDL = 0x30;
    public static final int STMT_DDL_CREATE = 0x31;
    public static final int STMT_DDL_ALTER = 0x32;
    public static final int STMT_DDL_DROP = 0x33;
    public static final int STMT_DDL_TRUNCATE = 0x34;
    public static final int STMT_PSM = 0x40;
    public static final int STMT_PSM_BEGIN = 0x41;
    public static final int STMT_PSM_CALL = 0x42;
    public static final int STMT_PSM_DECLARE = 0x44;

    public static final int DEFAULT_RESV_ID = 0;
    public static final int INSTANCE_RESV_ID = -1;

    public final static String NVL_NULL_VALUE = "N#U#L#L#V#A#L#U#E";
    public static final String VAR_RID = "XML_$VAR_$TABLE_";

    public static final String VALIDATE_SQL = "SELECT 1 FROM DUAL";
    public static final String VALIDATA_SQL_SYBASE_IQ = "SELECT 1 FROM SYS.DUMMY";
    public static final String VALIDATA_SQL_SYBASE_ASE = "SELECT \"uid\" FROM \"sysusers\"";
    
    public enum ResourceType {
        DATASOURCE("DATASOURCE"),
        VIRTUALTABLE("VIRTUALTABLE"),
        DATAMODEL("DATAMODEL"),
        VIRTUALVIEW("VIRTUALVIEW"),
        FLOW("FLOW");

        private String value;

        private ResourceType(String v) {
            value = v;

        }

        public String getValue() {
            return value;
        }
    }

    /*
     * Resource(DATASOURCE, VIRTUALTABLE, DATAMODEL, VIRTUALVIEW, FLOW)
     * version check
     */
    public static boolean checkDataResourceViersion(Connection metaConn,
                                                    String type, String id,
                                                    int version)
                                                        throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", type=" + type + ", id=" + id +
                ", version=" + version);

        PreparedStatement pstmt = null;
        String sql = null;

        sql = "SELECT VERSION FROM " + type + " WHERE " + type + "_ID=?";

        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == version - 1) {
                    return true;

                }
                else {
                    return false;
                }
            }
            else {
                MLogger.ERROR(TbHdError
                        .getFullMsg(TbHdError.NOT_FOUND_RESOURCE_FOR_UPDATE) +
                        '(' + type + ':' + id + ')');
                throw new TbHdException(TbHdError.NOT_FOUND_RESOURCE_FOR_UPDATE);
            }
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

    }

    public static void checkDuplicationResource(Connection metaConn,
                                                String[] id)
                                                    throws TbHdException {

        PreparedStatement pstmt = null;
        String sql = null;
        StringBuilder sb = new StringBuilder();
        List<String> duplicate = new ArrayList<String>();
        sql = "SELECT RESOURCE_ID " + "FROM HYPERDATA_RESOURCE " +
                "WHERE RESOURCE_ID IN (?)";
        for (int i = 0; i < id.length; i++) {
            sb.append("?,");
        }
        sb.setLength(sb.length() - 1);
        sql.replace("?", sb.toString());

        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < id.length; i++) {
                pstmt.setString(i + 1, id[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                duplicate.add(rs.getString(1));
            }

            if (!duplicate.isEmpty()) {
                MLogger.ERROR(TbHdError.getFullMsg(TbHdError.EXSIST_RESOURCE) +
                        '(' + duplicate.toString() + ')');
                throw new TbHdException(TbHdError.EXSIST_RESOURCE);
            }

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

    }

    public static String[] compareIdArray(String[] id, String[] containId) {
        List<String> result = new ArrayList<String>();
        if (containId == null) {
            return null;
        }
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < containId.length; j++) {
                if (id[i].equals(containId[j])) {
                    result.add(id[i]);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static String convertType(int type, String title, int precision,
                                     int scale, int length) {
        switch (type) {
        case Types.CHAR:
            return "CHAR(" + length + ")";
        case Types.VARCHAR:
            return "VARCHAR2(" + length + ")";
        case Types.LONGVARCHAR:
            return "LONG";
        case Types.NUMERIC:
        case Types.DECIMAL:
        case Types.BIT:
        case Types.TINYINT:
        case Types.SMALLINT:
        case Types.INTEGER:
        case Types.BIGINT:
        case Types.REAL:
        case Types.FLOAT:
        case Types.DOUBLE:
            return (precision == 0 ? (scale == 0 ? "NUMBER"
                                                 : "NUMBER(*," + scale + ")")
                                   : (scale == 0 ? "NUMBER(" + precision + ")"
                                                 : "NUMBER(" + precision + "," +
                                                         scale + ")"));
        case Types.BINARY:
        case Types.VARBINARY:
            return "RAW";
        case Types.LONGVARBINARY:
            return "LONGRAW";
        case Types.DATE:
            return "DATE";
        case Types.TIME:
            return "TIME";
        case Types.TIMESTAMP:
            return "TIMESTAMP";
        case Types.BLOB:
            return "BLOB " + scale + " " + precision + " " + length;
        case Types.CLOB:
            return "CLOB";

        default:
            return title;
        }

    }

    public static void deleteHyperdataResource(Connection metaConn, String[] id)
        throws TbHdException {

        MLogger.TRACE("metaConn=" + metaConn + ", id=" + id);

        PreparedStatement pstmt = null;
        String sql = null;

        sql = "DELETE HYPERDATA_RESOURCE WHERE RESOURCE_ID=?";

        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < id.length; i++) {
                pstmt.setString(1, id[i]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    public static void deleteGrantee(Connection metaConn, String[] granteeId)
        throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", granteeId=" + granteeId);

        String sql = null;
        PreparedStatement pstmt = null;

        sql = "DELETE FROM GRANTEE WHERE GRANTEE_ID=?";
        MLogger.DEBUG(sql);

        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < granteeId.length; i++) {
                pstmt.setString(1, granteeId[i]);
                pstmt.addBatch();
            }
            int[] result = pstmt.executeBatch();
            MLogger.INFO("Deleted row count(s) = " + Arrays.toString(result));

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    public static int execStatement(Connection conn, String sql)
        throws TbHdException {
        Statement stmt = null;
        int result = 0;
        MLogger.DEBUG(sql);
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);

            /* 티베로에서 발생한 Warning catch
             * throw 되지 않아서 아래와 같이 사용 */
            SQLWarning warn = conn.getWarnings();
            if (warn != null) {
                MLogger.WARN(warn.getLocalizedMessage());
                if (warn.getErrorCode() == -90500) {
                    throw new TbHdException(TbHdError.JDBC_SVR_WARNING, warn
                            .getLocalizedMessage());
                }
            }
            MLogger.INFO("Excute query resultCode : " + result);
        }
        catch (SQLException e) {
            /* Delete resource */
            if (e.getErrorCode() == -7070 || e.getErrorCode() == -7071) {
                MLogger.WARN("Specified resource was not found.");
            }
            /* Delete User */
            else if (e.getErrorCode() == -7069) {
                MLogger.WARN("Specified user was not found.");
            }
            else {
                MLogger.ERROR(e);
                throw new TbHdException(TbHdError.INCORRECT_QUERY,
                                        e.getMessage());
            }

        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

        return result;
    }

    public static String getGuid(Connection conn) throws TbHdException {
        String sql = null;
        PreparedStatement pstmt = null;
        String id = null;
        sql = "SELECT SYS_GUID() FROM DUAL";
        MLogger.DEBUG(sql);
        try {
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getString(1);
            }
        }
        catch (SQLException e) {
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (null != pstmt)
                    pstmt.close();
            }
            catch (SQLException e) {
                MLogger.ERROR(e);
            }
        }
        return id;
    }

    /**
     * @param metaConn
     * @param srcId
     * @return
     * @throws TbHdException
     */
    public static String getUsernameFromDblink(Connection execConn,
                                               String srcId)
                                                   throws TbHdException {
        MLogger.TRACE("execConn=" + execConn + ", srcId=" + srcId);

        PreparedStatement pstmt = null;
        String sql = null;
        String username = null;

        sql = "SELECT USERNAME FROM USER_DB_LINKS WHERE DB_LINK=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = execConn.prepareStatement(sql);
            pstmt.setString(1, srcId.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                username = rs.getString(1);
            }
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

        return username;
    }

    /**
     * @param metaConn
     * @param srcId
     * @return
     * @throws TbHdException
     */
    public static String getVendorFromDataSourceProp(Connection metaConn,
                                                     String srcId)
                                                         throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", srcId=" + srcId);

        PreparedStatement pstmt = null;
        String sql = null;
        String vendor = null;

        sql = "SELECT D.TYPE, P.SUB_TYPE " +
                "FROM DATASOURCE D, DATASOURCE_PROP P " +
                "WHERE D.DATASOURCE_ID=P.DATASOURCE_ID AND D.DATASOURCE_ID=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            pstmt.setString(1, srcId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String type = rs.getString(1);
                if (type.equals("DB") || type.equals("ANYMINER")) {
                    vendor = rs.getString(2);
                }
                else {
                    MLogger.ERROR(TbHdError.getFullMsg(TbHdError.NOT_DATABASE) +
                                  "(" + srcId + ")");
                    throw new TbHdException(TbHdError.NOT_DATABASE);
                }
            }
            else {
                MLogger.ERROR(TbHdError
                        .getFullMsg(TbHdError.DATA_SOURCE_NOT_SPECIFIED) + "(" +
                        srcId + ")");
                throw new TbHdException(TbHdError.DATA_SOURCE_NOT_SPECIFIED);
            }
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

        return vendor;
    }

    public static void insertHyperdataResource(Connection metaConn, String[] id,
                                             String type) throws TbHdException {

        MLogger.TRACE("metaConn=" + metaConn + ", id=" + id + ", type=" + type);

        PreparedStatement pstmt = null;
        String sql = null;

        sql = "INSERT INTO HYPERDATA_RESOURCE VALUES(?, ?)";

        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < id.length; i++) {
                pstmt.setString(1, id[i]);
                pstmt.setString(2, type);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    public static void insertHyperdataResource(Connection metaConn, String[] id,
                                             String[] type)
                                                 throws TbHdException {

        MLogger.TRACE("metaConn=" + metaConn + ", id=" + id + ", type=" + type);

        PreparedStatement pstmt = null;
        String sql = null;

        sql = "INSERT INTO HYPERDATA_RESOURCE VALUES(?, ?)";

        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < id.length; i++) {
                pstmt.setString(1, id[i]);
                pstmt.setString(2, type[i]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    
    public static void insertExtParamTable(Connection metaConn,
                                           BaseModel[] model)
                                               throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", model=" + model);

        PreparedStatement pstmt = null;
        String sql = null;

        TExternalParameter[] param = null;

        sql = "INSERT INTO HYPERDATA_RESOURCE_EXT_PARAM VALUES(?, ?, ?)";
        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < model.length; i++) {
                if (model[i].isSetModelExternalParameters()) {
                    param = model[i].getModelExternalParameters()
                            .getModelExternalParameterArray();
                    for (int j = 0; j < param.length; j++) {
                        pstmt.setString(1, model[i].getId());
                        pstmt.setString(2, param[j].getName());
                        pstmt.setString(3,
                                        XMLUtil.getMixedContentValue(param[j]));
                    }
                }
            }
            int[] rowCntArr = pstmt.executeBatch();
            MLogger.DEBUG("Added row count(s) = " + Arrays.toString(rowCntArr));

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());

        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    public static void deleteAndInsertExtParamTable(Connection metaConn,
                                                    BaseModel[] model)
                                                        throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", model=" + model);

        PreparedStatement pstmt = null;
        String sql = null;
        sql = "DELETE FROM HYPERDATA_RESOURCE_EXT_PARAM WHERE RESOURCE_ID=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < model.length; i++) {
                pstmt.setString(1, model[i].getId());
                pstmt.addBatch();
            }
            int[] result = pstmt.executeBatch();
            MLogger.DEBUG("Deleted row count(s) = " + Arrays.toString(result));

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());

        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

        TExternalParameter[] param = null;

        sql = "INSERT INTO HYPERDATA_RESOURCE_EXT_PARAM VALUES(?, ?, ?)";
        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < model.length; i++) {
                if (model[i].isSetModelExternalParameters()) {
                    param = model[i].getModelExternalParameters()
                            .getModelExternalParameterArray();
                    for (int j = 0; j < param.length; j++) {
                        pstmt.setString(1, model[i].getId());
                        pstmt.setString(2, param[j].getName());
                        pstmt.setString(3,
                                        XMLUtil.getMixedContentValue(param[j]));
                        pstmt.addBatch();
                    }
                }
            }
            int[] result = pstmt.executeBatch();
            MLogger.DEBUG("Added row count(s) = " + Arrays.toString(result));

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());

        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    public static void selectExtParamTable(Connection metaConn,
                                           BaseModel[] model)
                                               throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", model=" + model);

        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet rs;

        ModelExternalParameters params = null;
        TExternalParameter param = null;
        sql = "SELECT NAME, VALUE FROM HYPERDATA_RESOURCE_EXT_PARAM WHERE RESOURCE_ID=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            for (int i = 0; i < model.length; i++) {
                pstmt.setString(1, model[i].getId());
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    params = model[i].addNewModelExternalParameters();
                    do {
                        param = params.addNewModelExternalParameter();
                        param.setName(rs.getString(1));
                        XMLUtil.setMixedContentValue(param, rs.getString(2));
                    }
                    while (rs.next());
                }
                rs.close();
            }

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());

        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }
    }

    /* get Bind parameter count */
    public static int getParamCount(String sql) {
        int index = 0;
        int paramCount = 0;
        char sqlChars[] = new char[sql.length() + 1];

        sql.getChars(0, sql.length(), sqlChars, 0);

        while (true) {
            if (sqlChars[index] == '-' && sqlChars[index + 1] == '-') {
                index += 2;
                while (sqlChars[index] != '\n') {
                    if (sqlChars[index] == '\0')
                        return paramCount;

                    index++;
                }
                index++;
                continue;
            }

            if (sqlChars[index] == '"') {
                index++;
                while (sqlChars[index] != '"') {
                    if (sqlChars[index] == '\0')
                        return paramCount;

                    index++;
                }
                index++;
                continue;
            }

            if (sqlChars[index] == '\'') {
                index++;
                while (sqlChars[index] != '\'') {
                    if (sqlChars[index] == '\0')
                        return paramCount;

                    index++;
                }
                index++;
                continue;
            }

            if (sqlChars[index] == '/' && sqlChars[index + 1] == '*') {
                index += 2;
                while (sqlChars[index] != '*' || sqlChars[index + 1] != '/') {
                    if (sqlChars[index] == '\0')
                        return paramCount;

                    index++;
                }
                index += 2;
                continue;
            }

            if (sqlChars[index] == '\0')
                return paramCount;

            if (sqlChars[index] == '?' ||
                    (sqlChars[index] == ':' && sqlChars[index + 1] != '='))
                paramCount++;

            index++;
        }
    }

    /* get Bind Name */
    public static String[] getParamNames(String sql) {
        int index = 0;
        char sqlChars[] = new char[sql.length() + 1];

        List<String> paramNames = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sql.getChars(0, sql.length(), sqlChars, 0);

        while (true) {
            if (sqlChars[index] == '-' && sqlChars[index + 1] == '-') {
                index += 2;
                while (sqlChars[index] != '\n') {
                    if (sqlChars[index] == '\0')
                        return paramNames
                                .toArray(new String[paramNames.size()]);
                    index++;
                }
                index++;
                continue;
            }

            if (sqlChars[index] == '"') {
                index++;
                while (sqlChars[index] != '"') {
                    if (sqlChars[index] == '\0')
                        return paramNames
                                .toArray(new String[paramNames.size()]);
                    index++;
                }
                index++;
                continue;
            }

            if (sqlChars[index] == '\'') {
                index++;
                while (sqlChars[index] != '\'') {
                    if (sqlChars[index] == '\0')
                        return paramNames
                                .toArray(new String[paramNames.size()]);
                    index++;
                }
                index++;
                continue;
            }

            if (sqlChars[index] == '/' && sqlChars[index + 1] == '*') {
                index += 2;
                while (sqlChars[index] != '*' || sqlChars[index + 1] != '/') {
                    if (sqlChars[index] == '\0')
                        return paramNames
                                .toArray(new String[paramNames.size()]);

                    index++;
                }
                index += 2;
                continue;
            }

            if (sqlChars[index] == '\0')
                return paramNames.toArray(new String[paramNames.size()]);

            if (sqlChars[index] == ':') {
                index++;
                sb.delete(0, sb.length());
                while (true) {
                    if (sqlChars[index] == '\0') {
                        paramNames.add(sb.toString());
                        return (String[]) paramNames
                                .toArray(new String[paramNames.size()]);
                    }
                    if (Character.isLetterOrDigit(sqlChars[index]) ||
                            sqlChars[index] == '_') {
                        sb.append(sqlChars[index]);
                    }
                    else {
                        if (sb.length() > 0)
                            paramNames.add(sb.toString());
                        break;
                    }
                    index++;

                }
            }
            index++;
        }
    }

    public static String removeBindChar(String sql) {
        int index = 0;
        char sqlChars[] = new char[sql.length() + 1];

        StringBuilder newSql = new StringBuilder();
        sql.getChars(0, sql.length(), sqlChars, 0);

        while (true) {
            if (sqlChars[index] == '-' && sqlChars[index + 1] == '-') {
                newSql.append(sqlChars[index]).append(sqlChars[index + 1]);
                index += 2;
                while (sqlChars[index] != '\n') {
                    if (sqlChars[index] == '\0')
                        return newSql.toString();
                    newSql.append(sqlChars[index]);
                    index++;
                }
                newSql.append(sqlChars[index]);
                index++;
                continue;
            }

            if (sqlChars[index] == '"') {
                newSql.append(sqlChars[index]);
                index++;
                while (sqlChars[index] != '"') {
                    if (sqlChars[index] == '\0')
                        return newSql.toString();
                    newSql.append(sqlChars[index]);
                    index++;
                }
                newSql.append(sqlChars[index]);
                index++;
                continue;
            }

            if (sqlChars[index] == '\'') {
                newSql.append(sqlChars[index]);
                index++;
                while (sqlChars[index] != '\'') {
                    if (sqlChars[index] == '\0')
                        return newSql.toString();
                    newSql.append(sqlChars[index]);
                    index++;
                }
                newSql.append(sqlChars[index]);
                index++;
                continue;
            }

            if (sqlChars[index] == '/' && sqlChars[index + 1] == '*') {
                newSql.append(sqlChars[index]).append(sqlChars[index + 1]);
                index += 2;
                while (sqlChars[index] != '*' || sqlChars[index + 1] != '/') {
                    newSql.append(sqlChars[index]);
                    if (sqlChars[index] == '\0')
                        return newSql.toString();
                    index++;
                }
                newSql.append(sqlChars[index]).append(sqlChars[index + 1]);
                index += 2;
                continue;
            }

            if (sqlChars[index] == '\0')
                return newSql.toString();

            if (sqlChars[index] == ':') {
                index++;
                while (true) {
                    newSql.append(sqlChars[index]);
                    if (sqlChars[index] == '\0') {
                        return newSql.toString();
                    }
                    if (!(Character.isLetterOrDigit(sqlChars[index]) ||
                            sqlChars[index] == '_'))
                        break;
                    index++;
                }
            }
            newSql.append(sqlChars[index]);
            index++;
        }
    }

    private static char getNextChar(TokenProp prop) {
        if (prop.index < prop.textLen)
            return prop.text.charAt(prop.index++);
        else
            return NULL;
    }

    private static String getToken(TokenProp prop) {
        boolean save;
        char chr;

        int state = STATE_START;
        StringBuilder token = new StringBuilder(32);

        while (state != STATE_DONE) {
            chr = getNextChar(prop);
            save = true;

            switch (state) {
            case STATE_START:
                switch (chr) {
                case '/':
                    state = STATE_1;
                    break;
                case '-':
                    state = STATE_4;
                    break;
                case '\'':
                    state = STATE_6;
                    break;
                case '(':
                case ')':
                    if (token.length() > 0) {
                        state = STATE_DONE;
                        save = false;
                        prop.index--;
                    }
                    else {
                        state = STATE_DONE;
                        save = true;
                    }
                    break;
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    if (token.length() > 0) {
                        state = STATE_DONE;
                    }

                    save = false;
                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;

                default:
                }
                break;

            case STATE_1:
                switch (chr) {
                case '*':
                    state = STATE_2;
                    save = false;
                    /** delete char '/' **/
                    token.delete(token.length() - 1, token.length());
                    break;
                case '(':
                case ')':
                    state = STATE_DONE;
                    save = false;
                    prop.index--;
                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;
                default:
                    state = STATE_START;
                }
                break;

            case STATE_2:
                switch (chr) {
                case '*':
                    state = STATE_3;
                    save = false;
                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;
                default:
                    save = false;
                }
                break;

            case STATE_3:
                switch (chr) {
                case '*':
                    save = false;
                    break;
                case '/':
                    state = STATE_START;

                    save = false;

                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;
                default:
                    state = STATE_2;
                    save = false;
                }
                break;

            case STATE_4:
                switch (chr) {
                case '-':
                    state = STATE_5;
                    save = false;
                    /** delete char '-' **/
                    token.delete(token.length() - 1, token.length());
                    break;
                case '(':
                case ')':
                    state = STATE_DONE;
                    save = false;
                    prop.index--;
                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;
                default:
                    state = STATE_START;
                }
                break;

            case STATE_5:
                switch (chr) {
                case '\r':
                case '\n':
                    state = STATE_START;

                    prop.index--;

                    save = false;

                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;
                default:
                    save = false;
                }
                break;

            case STATE_6:
                switch (chr) {
                case '\'':
                    state = STATE_START;
                    break;
                case NULL:
                    state = STATE_DONE;
                    save = false;
                    break;
                default:
                }
                break;
            }

            if (save) {
                token.append(chr);
            }
        }

        return token.substring(0, token.length()).toUpperCase();
    }

    static class TokenProp {
        int index;
        int textLen;
        String text;

        TokenProp(int idx, int len, String text) {
            index = idx;
            textLen = len;
            this.text = text;
        };
    }

    public static int getSQLType(String sql) {
        TokenProp prop = new TokenProp(0, sql.length(), sql);

        String token = getToken(prop);

        if (token.equals("("))
            token = getToken(prop);

        if (token.equals("SELECT") || token.equals("WITH"))
            return STMT_QUERY;
        else if (token.equals("DELETE"))
            return STMT_DML_DELETE;
        else if (token.equals("INSERT"))
            return STMT_DML_INSERT;
        else if (token.equals("UPDATE"))
            return STMT_DML_UPDATE;
        else if (token.equals("MERGE"))
            return STMT_DML_MERGE;
        else if (token.equals("CREATE"))
            return STMT_DDL_CREATE;
        else if (token.equals("ALTER"))
            return STMT_DDL_ALTER;
        else if (token.equals("DROP"))
            return STMT_DDL_DROP;
        else if (token.equals("TRUNCATE"))
            return STMT_DDL_TRUNCATE;
        else
            return STMT_UNKNOWN;
    }

    public static void setFlowVariableInstance(Connection execConn,
                                               String refId, int resvId,
                                               String instId)
                                                   throws TbHdException {
        String sql = null;
        PreparedStatement pstmt = null;

        sql = "INSERT INTO FLOW_VAR (FLOW_ID, REFERRED_FLOW, FLOW_RESV_ID, FLOW_INST_ID) " +
                "SELECT FLOW_ID, REFERRED_FLOW, FLOW_RESV_ID, ? " +
                "FROM FLOW_VAR_DATA " +
                "WHERE REFERRED_FLOW = ? AND FLOW_RESV_ID=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = execConn.prepareStatement(sql);
            pstmt.setString(1, instId);
            pstmt.setString(2, refId);
            pstmt.setInt(3, resvId);
            int result = pstmt.executeUpdate();
            MLogger.INFO("insert(flow_var) row:" + result);

            execConn.commit();

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (null != pstmt)
                    pstmt.close();
            }
            catch (SQLException se) {
                MLogger.ERROR(se);
            }
        }
    }

    public static boolean addFlowVariableAssignments(Connection execConn,
                                                     String flowId,
                                                     String instId, int resvId,
                                                     TVariableAssignments[] varAssigns)
                                                         throws TbHdException {
        MLogger.TRACE("metaConn=" + execConn + ", flowId=" + flowId +
                ", varAssigns=" + varAssigns);

        String sql = null;
        PreparedStatement pstmt = null;
        boolean hasVar = false;
        String varFlowId;
        SQLXML var_data = null;
        XmlOptions xmlOps = new XmlOptions();
        xmlOps.setSavePrettyPrint();
        xmlOps.setSaveNamespacesFirst();
        xmlOps.setSaveOuter();

        sql = "INSERT INTO FLOW_VAR_DATA (FLOW_ID, REFERRED_FLOW, FLOW_RESV_ID, FLOW_INST_ID, VAR_DATA) " +
                "VALUES (?, ?, ?, ?, ?)";
        MLogger.DEBUG(sql);
        try {
            pstmt = execConn.prepareStatement(sql);
            for (int i = 0; i < varAssigns.length; i++) {
                var_data = execConn.createSQLXML();
                var_data.setString(XMLUtil.removeNamespace(varAssigns[i]
                        .xmlText((new XmlOptions()).setSaveOuter())));
                varFlowId = varAssigns[i].getFlowId();
                pstmt.setString(1, varFlowId);
                pstmt.setString(2, flowId);
                pstmt.setInt(3, resvId);

                if (instId != null) {
                    pstmt.setString(4, instId);
                }
                else {
                    pstmt.setNull(4, Types.VARCHAR);
                }

                pstmt.setSQLXML(5, var_data);
                pstmt.addBatch();
                if (flowId.equals(varFlowId)) {
                    hasVar = true;
                }
            }
            int[] result = pstmt.executeBatch();
            MLogger.INFO("Added row count(s) = " + Arrays.toString(result));

            execConn.commit();

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (null != pstmt)
                    pstmt.close();
            }
            catch (SQLException se) {
                MLogger.ERROR(se);
            }
        }

        return hasVar;

    }

    public static void updateFlowVariableAssignment(Connection metaConn,
                                                    String flowId,
                                                    Integer resvId,
                                                    TVariableAssignments varAssigns)
                                                        throws TbHdException {
        MLogger.TRACE("metaConn=" + metaConn + ", flowId=" + flowId +
                ", varAssigns=" + varAssigns);

        String sql = null;
        PreparedStatement pstmt = null;
        SQLXML var_data = null;
        XmlOptions xmlOps = new XmlOptions();
        xmlOps.setSavePrettyPrint();
        xmlOps.setSaveNamespacesFirst();
        xmlOps.setSaveOuter();
        sql = "UPDATE FLOW_VAR SET VAR_DATA=? WHERE FLOW_ID=? AND FLOW_RESV_ID=?";

        MLogger.DEBUG(sql);
        try {
            pstmt = metaConn.prepareStatement(sql);
            var_data = metaConn.createSQLXML();
            var_data.setString(varAssigns
                    .xmlText((new XmlOptions()).setSaveOuter()));
            pstmt.setSQLXML(1, var_data);
            pstmt.setString(2, flowId);
            pstmt.setInt(3, resvId);
            int result = pstmt.executeUpdate();
            MLogger.INFO("update(flow_var) row:" + result);

        }
        catch (

        SQLException e)

        {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally

        {
            try {
                if (null != pstmt)
                    pstmt.close();
            }
            catch (SQLException se) {
                MLogger.ERROR(se);
            }
        }

    }

    public static void deleteFlowVariableAssignmenstInstance(Connection execConn,
                                                             String flowId,
                                                             String instId)
                                                                 throws TbHdException {
        MLogger.TRACE("metaConn=" + execConn + ", flowId=" + flowId +
                ", instId=" + instId);

        String sql = null;
        PreparedStatement pstmt = null;

        sql = "DELETE FROM FLOW_VAR_DATA WHERE REFERRED_FLOW=? AND FLOW_RESV_ID=? AND FLOW_INST_ID=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = execConn.prepareStatement(sql);
            pstmt.setString(1, flowId);
            pstmt.setInt(2, SQLUtil.INSTANCE_RESV_ID);
            pstmt.setString(3, instId);
            int result = pstmt.executeUpdate();
            MLogger.INFO("delete(flow_var_data) row:" + result);

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

        sql = "DELETE FROM FLOW_VAR WHERE FLOW_INST_ID=?";
        MLogger.DEBUG(sql);
        try {
            pstmt = execConn.prepareStatement(sql);
            pstmt.setString(1, instId);
            int result = pstmt.executeUpdate();
            MLogger.INFO("delete(flow_var) row:" + result);

            execConn.commit();

        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            }
            catch (SQLException e1) {
                MLogger.ERROR(e1);
            }
        }

    }

    public static int calResultCount(int[] count) {
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i];
        }
        return total;
    }

    public static void setAppicationInfo(Connection conn, String userId)
        throws TbHdException {
        CallableStatement cstmt = null;
        String sql = "call dbms_application_info.set_client_info('" + userId +
                "')";
        try {
            cstmt = conn.prepareCall(sql);
            cstmt.executeUpdate();
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            }
            catch (SQLException e) {
                MLogger.ERROR(e);
            }
        }

        sql = "call dbms_application_info.set_action('" + TbHdConfig.getHostId() + "')";
        try {
            cstmt = conn.prepareCall(sql);
            cstmt.executeUpdate();
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                    e.getMessage());
        }
        finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            }
            catch (SQLException e) {
                MLogger.ERROR(e);
            }
        }
    }
    
    public static void createDbDirectory(Connection conn, String inputDir, String dirName)
            throws TbHdException {

            Statement stmt = null;
            String sql = "CREATE OR REPLACE DIRECTORY " + dirName +
                    " AS '" + inputDir + "'";
            MLogger.DEBUG(sql);

            try {
                stmt = conn.createStatement();
                stmt.execute(sql);
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                MLogger.ERROR(e);
                throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                             e.getMessage());
            }
            finally {
                try {
                    if (null != stmt)
                        stmt.close();
                }
                catch (Exception e) {
                    MLogger.ERROR(e);
                }
            }
        }

}
