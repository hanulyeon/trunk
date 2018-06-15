/**
 * Tibero, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.processor.impl;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.tmax.hyperdata.util.TbHdSession;
import org.apache.xmlbeans.XmlObject;

import com.m.msl.logger.MLogger;
//import com.tmax.hyperdata.auth.TbHdAuthorizeController;
import com.tmax.hyperdata.config.TbHdConfig;
import com.tmax.hyperdata.error.TbHdError;
import com.tmax.hyperdata.error.TbHdException;
import com.tmax.hyperdata.manager.TbHdSessionManager;
//import com.tmax.hyperdata.opt.TbHdFlowProcedureGen;
import com.tmax.hyperdata.processor.ETbHyperDataRequest;
import com.tmax.hyperdata.processor.ITbHyperDataRequestProcessor;
import com.tmax.hyperdata.util.SQLUtil;
import com.tmax.tbhub.data.ColInfoDocument.ColInfo;
import com.tmax.tbhub.data.ColInfoDocument.ColInfo.Col;
import com.tmax.tbhub.data.ResultDataDocument.ResultData;
import com.tmax.tbhub.data.RowDocument.Row;
import com.tmax.tbhub.data.TResultSet;
import com.tmax.tbhub.data.TResultSets;
import com.tmax.tbhub.request.ExecuteFlowDirectDocument.ExecuteFlowDirect;
import com.tmax.tbhub.request.TIgnoreVarSet;
import com.tmax.tbhub.request.TVariableAssignments;
import com.tmax.tbhub.request.UserInfoDocument.UserInfo;
import com.tmax.tbhub.response.ResponseDocument;
import com.tmax.tbhub.response.ResponseDocument.Response;
import com.tmax.tbhub.response.SuccessDocument.Success;
import com.tmax.tbhub.response.TResult;
import com.tmax.tbhub.response.TResultData;
import com.tmax.tbhub.task.FlowHeaderDocument.FlowHeader;
import com.tmax.tbhub.task.TFlow;
import com.tmax.tbhub.task.TUser;
import com.tmax.tbhub.task.TasksDocument.Tasks;
import com.tmax.tibero.TbTypes;
import com.tmax.tibero.jdbc.TbStatement;
import com.tmax.tibero.jdbc.data.DataType;
import com.tmax.tibero.pivot.TbPivotMeta;
import com.tmax.tibero.pivot.TbPivotValReader;

/**
 * @author YunWooPark (yunwoo_park@tibero.com) 2014. 5. 12.
 * @version $Id: ExecTaskFlowDirectProcessor.java 2159M 2014-06-22 23:33:17Z
 *          (local) $
 */

public class ExecuteFlowDirectProcessor implements ITbHyperDataRequestProcessor {

    /* (non-Javadoc)
     * @see com.tmax.tbhub.request.processor.ITbHubRequestProcessor#process(java.sql.Connection, com.tmax.tbhub.request.UserInfoDocument.UserInfo, com.tmax.tbhub.request.processor.ETbHubRequest, org.apache.xmlbeans.XmlObject)
     */
    public ResponseDocument process(TbHdSession hyperdataSession, UserInfo userInfo, ETbHyperDataRequest requestEnum, XmlObject requestXmlObj) throws TbHdException {
        MLogger.TRACE();

        return processInternal(hyperdataSession, userInfo, requestEnum,
                requestXmlObj);
    }

    private ResponseDocument processInternal(TbHdSession hyperdataSession,
                                             UserInfo userInfo,
                                             ETbHyperDataRequest requestEnum,
                                             XmlObject requestXmlObj)
            throws TbHdException {

        ExecuteFlowDirect execTaskFlowDirect = (ExecuteFlowDirect) requestXmlObj;

        String instanceId = null;

        String sql = null;
        Connection conn = hyperdataSession.getConnection();

        TFlow flow = execTaskFlowDirect.getFlow();
        String flowId = flow.getId();

        TVariableAssignments[] varAssigns = null;
        TIgnoreVarSet[] ignoredTaskVarSetArray = null;
        boolean hasVariable = false;
        boolean hasDmlTask = false;
        boolean hasHadoopFileWriteTask = false;
        /* Task variable array */
        varAssigns = flow.getVariableAssignmentsArray();

        /* Ignored Task variable array */
        if (execTaskFlowDirect.isSetIgnoreVarSets()) {
            ignoredTaskVarSetArray = execTaskFlowDirect.getIgnoreVarSets()
                    .getIgnoreVarSetArray();
        }
        else {
            ignoredTaskVarSetArray = new TIgnoreVarSet[0];
        }

        if (null == flowId) {
            MLogger.WARN("Flow ID is null.");
            flowId = TbHdConfig.getHostId() + "_" + System.currentTimeMillis();
            flow.setId(flowId);
        }
        MLogger.INFO("Flow ID = " + flowId);

        if (null == flow.getName()) {
            MLogger.WARN("Flow name is null.");
            flow.setName(flowId);
        }

        FlowHeader flowHeader = flow.getFlowHeader();
        if (null == flowHeader) {
            flowHeader = flow.addNewFlowHeader();
        }

        TUser flowOwner = flowHeader.getOwner();
        if (null == flowOwner) {
            flowOwner = flowHeader.addNewOwner();
            flowOwner.setUserId(userInfo.getUserId());
            flowOwner.setName(userInfo.getUserName());
        }
        else {
            if (null == flowOwner.getUserId()) {
                flowOwner.setUserId(userInfo.getUserId());
            }
            if (null == flowOwner.getName()) {
                flowOwner.setName(userInfo.getUserName());
            }
        }

        Tasks tasks = flow.getTasks();
        if (null == tasks || (0 == tasks.sizeOfAdhocArray() &&
                0 == tasks.sizeOfMapArray() && 0 == tasks.sizeOfFilterArray() &&
                0 == tasks.sizeOfJoinArray() && 0 == tasks.sizeOfMergeArray() &&
                0 == tasks.sizeOfFileWriteArray() &&
                0 == tasks.sizeOfPivotArray() && 0 == tasks.sizeOfDataArray() &&
                0 == tasks.sizeOfSortArray() &&
                0 == tasks.sizeOfGroupByArray() &&
                0 == tasks.sizeOfUserArray() &&
                0 == tasks.sizeOfFlowTaskArray())) {
            MLogger.ERROR("Flow doesn't have any Task: flow id=" + flowId);
            throw new TbHdException(TbHdError.DONT_HAVE_REQUIRED,
                    "Flow doesn't have any Task: flow id=" +
                            flowId);
        }

        if(tasks.sizeOfDmlTaskArray() > 0) {
            hasDmlTask = true;
        }

        if (tasks.sizeOfFileWriteArray() > 0 &&
                tasks.getFileWriteArray()[0].getFileType().equals("HADOOP")) {
            hasHadoopFileWriteTask = true;
        }

        if (execTaskFlowDirect.isSetInstanceId()) {
            instanceId = execTaskFlowDirect.getInstanceId();
        }
        else {
            instanceId = SQLUtil.getGuid(conn);
        }

        /*
        procedure 만들지 말고 sql List 만들어서 for 루프에서 수
        TbHdFlowProcedureGen createPsm = new TbHdFlowProcedureGen(userInfo,
                flowId,
                instanceId,
                hasVariable,
                hasDmlTask,
                hasHadoopFileWriteTask);
        sql = createPsm.createProcedure(hyperdataSession, flow);

        SQLUtil.execStatement(conn, sql);
        */



        ResponseDocument doc;

        doc = processWithoutSave(hyperdataSession, userInfo, requestEnum, flow
                .getId(), instanceId);

        return doc;
    }

    public ResponseDocument processWithoutSave(TbHdSession hyperdataSession,
                                               UserInfo userInfo,
                                               ETbHyperDataRequest requestEnum,
                                               String flowId, String instanceId)
            throws TbHdException {
        MLogger.TRACE("userInfo=" +
                userInfo + ", requestEnum=" + requestEnum + ", flowId=" +
                flowId + ", instanceId=" + instanceId);

        String sql = null;

        ResponseDocument responseDoc = ResponseDocument.Factory.newInstance();
        Response response = responseDoc.addNewResponse();
        response.setResult(TResult.SUCCESS);

        CallableStatement cstmt;
        Connection conn = hyperdataSession.getConnection();

        SQLUtil.setAppicationInfo(conn, userInfo.getUserId());

        StringBuilder sb = new StringBuilder();
        sb.append("CALL ").append(flowId).append('_').append(instanceId)
                .append("(?,?)");
        sql = sb.toString();

        MLogger.INFO("INSTANCE ID : " + instanceId);
        TResultSets results = null;
        TResultSet result = null;
        ResultSet rs = null;
        MLogger.DEBUG(sql);
        try {
            cstmt = conn.prepareCall(sql);
            cstmt.setString(1, instanceId);
            cstmt.registerOutParameter(2, TbTypes.CURSOR);

            hyperdataSession.setStatement(cstmt);
            hyperdataSession.setFlowId(flowId.toUpperCase());
            hyperdataSession.setInstanceId(instanceId);

            cstmt.executeUpdate();

            rs = (ResultSet)cstmt.getObject(2);
            hyperdataSession.setResultSet(rs);

            createResponse(response, hyperdataSession);
        }
        catch (SQLException e) {
            if (e.getErrorCode() != -90644) {
                MLogger.ERROR(e);
                throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                        e.getMessage());
            }
        }
        catch (Exception e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.FAILED_EXEC_FLOW, e.getMessage());
        }
        finally {
            SQLUtil.deleteFlowVariableAssignmenstInstance(conn, flowId, instanceId);
            /*try {
                if (requestEnum == ETbHyperDataRequest.EXECUTE_FLOW_DIRECT &&
                        rs != null && !rs.isClosed()) {
                    hyperdataSession.setFlowId(flowId);
                    TbHdSessionManager.putSession(hyperdataSession.getSessionId(),
                            hyperdataSession);
                }
                else {
                    if (TbHdSessionManager
                            .hasSession(hyperdataSession.getSessionId())) {
                        TbHdSessionManager
                                .removeSession(hyperdataSession.getSessionId());
                    }
                    else {
                        SQLUtil.execStatement(conn, "DROP PROCEDURE " +
                                flowId + "_" + instanceId);
                    }
                }
            }
            catch (SQLException e) {
                MLogger.ERROR(e);
            }*/

        }

        return responseDoc;
    }

    public void createResponse(Response response,
                               TbHdSession hyperdataSession)
            throws Exception {
        MLogger.TRACE();
        TResultData resultData = response.addNewResultData();
        Success success = resultData.addNewSuccess();
        TResultSets results = success.addNewResultSets();
        TResultSet result;
        ResultSet rs = hyperdataSession.getResultSet();
        ResultSetMetaData rsmeta = rs.getMetaData();
        int colListSize;
        int addPivotCnt;

        try {
            colListSize = rsmeta.getColumnCount();
        } catch (SQLException e) {
            return ;
        }

        result = results.addNewResultSet();

        int rowCnt = 0;
        ColInfo cols = null;
        Col col = null;
        ResultData resultOut = null;
        Row row = null;

        List<ColumnInfo> colList = new ArrayList<ColumnInfo>();
        ColumnInfo colInfo;
        TbPivotMeta pivotMeta = null;

        //        ColumnInfo[] colInfos = new ColumnInfo[cnt];
        /*
         * Column   pivot column   pivot meta
         */
        boolean existsPivot = false;

        addPivotCnt = colListSize;
        for (int i = 0; i < colListSize; i++) {
            colInfo = new ColumnInfo(rsmeta, i);
            colList.add(colInfo);
            existsPivot |= colInfo.isPivotCol;
            if (existsPivot && pivotMeta == null) {
                // FIXME : 시작
                String sqlSelectProcBody = "SELECT TEXT FROM USER_SOURCE WHERE NAME = ?";
                PreparedStatement pstmt = hyperdataSession.getConnection().prepareStatement(sqlSelectProcBody);

                pstmt.setString(1, hyperdataSession.getProcedureName());
                ResultSet ProcBodys = pstmt.executeQuery();

                //start parse sql

                StringBuilder sqlOrigin = new StringBuilder();
                while(ProcBodys.next()){
                    String ProcBody = ProcBodys.getString("TEXT");
                    if(ProcBody.contains("OPEN p_csr FOR")){
                        sqlOrigin.append(ProcBody);
                        ProcBodys.close();
                        break;
                    }
                }

                sqlOrigin.delete(0, "OPEN p_csr FOR ".length());
                pstmt.close();

                //end parse sql
                //get PIVOT META

                pstmt = hyperdataSession.getConnection().prepareStatement(sqlOrigin.toString());
                pstmt.executeQuery();

                // FIXME : 끝

//                TbStatement stmt = (TbStatement)rs.getStatement();
                //                stmt.getPivotInfo();
//                pivotMeta = new TbPivotMeta((TbStatement) stmt);
                pivotMeta = new TbPivotMeta((TbStatement) pstmt);

                pstmt.close();

            }
            if (colInfo.isPivotCol) {
                colInfo.setPivot(pivotMeta);
            }
        }

        String hubDateFormat = TbHdConfig.getDateFormat();

        result.setColCount(addPivotCnt);

        cols = result.addNewColInfo();
        for (int i = 0; i < colListSize; i++) {
            if (colList.get(i).isPivotCol) {
                for (int j = 0; j < colList.get(i).pvColName.size(); j++) {
                    col = cols.addNewCol();
                    col.setName(colList.get(i).pvColName.get(j));

                    //                    if (showColType) {
                    //                        col.setType(colList.get(i).colTypeName);
                    //                    }
                }

            }
            else {
                col = cols.addNewCol();
                col.setName(colList.get(i).colAlias != null ? colList.get(i).colAlias
                        : colList.get(i).colName);

                //                if (showColType) {
                //                    col.setType(colList.get(i).colTypeName);
                //                }
            }

        }

        if (rs.next()) {
            resultOut = result.addNewResultData();
            do {
                row = resultOut.addNewRow();
                for (int idx = 0; idx < colListSize; idx++) {
                    Object tmpObj;
                    switch (rsmeta.getColumnType(idx + 1)) {
                        case TbTypes.PIVOT:
                            tmpObj = null;
                            if (colList.get(idx).isPivotCol) {
                                Blob blob = rs.getBlob(idx + 1);
                                String[] data =
                                        getPivotData(blob, idx + 1, colList.get(idx),
                                                pivotMeta, hubDateFormat);
                                if (data == null) {
                                    row.addValue("");
                                }
                                else {
                                    for (int i = 0; i < data.length; i++) {
                                        row.addValue(data[i]);
                                    }
                                }

                            }
                            break;
                        case Types.DATE:
                            tmpObj =
                                    getTbhFmtStr(rs.getDate(idx + 1), hubDateFormat);
                            row.addValue(tmpObj == null ? "" : tmpObj.toString());

                            break;
                        case Types.TIME:
                            tmpObj = rs.getTime(idx + 1);
                            row.addValue(tmpObj == null ? "" : tmpObj.toString());
                            break;
                        case Types.TIMESTAMP:
                            tmpObj = rs.getTimestamp(idx + 1);
                            row.addValue(tmpObj == null ? "" : tmpObj.toString());

                            break;
                        default:
                            tmpObj = rs.getString(idx + 1);
                            row.addValue(tmpObj == null ? "" : tmpObj.toString());
                            break;
                    }

                }
                rowCnt++;
            } while (rowCnt != TbHdConfig.getResultFetchRowCnt() && rs.next());
            if (rowCnt < TbHdConfig.getResultFetchRowCnt()) {
                rs.close();
                MLogger.DEBUG("Direct's ResultSet closed");
            }
            MLogger.TRACE(rowCnt + " record(s) are written.");

            /*
             * FIXME: compress file
             */

        }
    }

    private String[] getPivotData(Blob blob, int colIdx,
                                  ColumnInfo colInfo,
                                  TbPivotMeta pivotMeta,
                                  String hubDateFormat)
            throws Exception {
        if (blob == null) {
            return null;
        }

        String[] data = new String[colInfo.pvColCnt];
        for (int i = 0; i < colInfo.pvColCnt; i++) {
            data[i] = "";
        }

        TbPivotValReader pvReader = new TbPivotValReader(blob, colIdx,
                pivotMeta);

        int dataCnt = pvReader.getCnt();
        int colNameIdx = 0;
        int i = 0;
        int prevIdx = -1;
        try {
            for (; i < dataCnt; i++) {
                colNameIdx = pvReader.getColNameIdx(i);

                printNullValue(prevIdx, colNameIdx, data);

                switch (pivotMeta.getValType(colIdx, colNameIdx)) {
                    case DataType.NUMBER:
                        data[colNameIdx] = toString(pvReader.getNextBigDecimal());
                        break;
                    case DataType.VARCHAR:
                    case DataType.CHAR:
                        data[colNameIdx] = toString(pvReader.getNextString());
                        break;
                    case DataType.DATE:
                        data[colNameIdx] = getTbhFmtStr(pvReader.getNextDate(),
                                hubDateFormat);
                        break;
                    case DataType.TIME:
                        data[colNameIdx] = getTbhFmtStr(pvReader.getNextTime(),
                                hubDateFormat);
                        break;
                    case DataType.TIMESTAMP:
                        data[colNameIdx] = getTbhFmtStr(pvReader.getNextTimestamp(),
                                hubDateFormat);
                        break;
                    default:
                        // XXX: ignore??

                        data[colNameIdx] = toString(pvReader.getNextString());
                }
                prevIdx = colNameIdx;
            }
        }
        catch (Exception e) {
            StringBuilder err = new StringBuilder(128);
            // @formatter:off
            err.append("\n\n-------------- Pivot data read Error -----------------")
                    .append("\nColumn count = ")
                    .append(colInfo.pvColCnt)
                    .append("\nItem Count = ")
                    .append(dataCnt)
                    .append("\nItem index = ")
                    .append(i)
                    .append("\nName index = ")
                    .append(colNameIdx)
                    .append("\n\n-------------- Pivot Error desc end -----------------\n");
            // @formatter:on
            MLogger.DEBUG(err.toString());
            throw e;
        }

        return data;
    }

    private void printNullValue(int prevIdx, int idx, String[] data){
        if (prevIdx != idx - 1) {
            for (int i = prevIdx + 1; i < idx; i++) {
                data[i] = "";
            }
        }
    }

    private static String unwrapSingleQuot(String value) {
        String trimmed;
        int trimmedLen;
        if (null != value &&
                (trimmedLen = (trimmed = value.trim()).length()) > 1 &&
                trimmed.charAt(0) == '\'' &&
                trimmed.charAt(trimmedLen - 1) == '\'') {
            return trimmed.substring(1, trimmedLen - 1);
        }
        return value;
    }

    private static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    private static String getTbhFmtStr(Date date, String dateFormat) {
        if (date == null)
            return "";

        String tmpDateFormat = dateFormat;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String strDate = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", c);
        if (strDate.length() < 14) {
            return "";
        }
        tmpDateFormat = tmpDateFormat.replace("YYYY", strDate.substring(0, 4));
        tmpDateFormat = tmpDateFormat.replace("MM", strDate.substring(4, 6));
        tmpDateFormat = tmpDateFormat.replace("DD", strDate.substring(6, 8));
        tmpDateFormat = tmpDateFormat.replace("HH24", strDate.substring(8, 10));
        tmpDateFormat = tmpDateFormat.replace("MI", strDate.substring(10, 12));
        tmpDateFormat = tmpDateFormat.replace("SS", strDate.substring(12, 14));

        return tmpDateFormat;
    }

    private static class ColumnInfo {
        int colType;
        int colLen;
        int colPrec;
        int colScale;
        String colTypeName;

        int colIndex;
        String colName;
        String colAlias;
        boolean isPivotCol;
        int pvColCnt;
        List<String> pvColName;

        private ColumnInfo(ResultSetMetaData rsmd,
                           int idx) throws SQLException {
            colIndex = idx + 1;
            colName = rsmd.getColumnName(colIndex);
            colType = rsmd.getColumnType(colIndex);
            colLen = rsmd.getColumnDisplaySize(colIndex);
            colPrec = rsmd.getPrecision(colIndex);
            colTypeName = rsmd.getColumnTypeName(colIndex);
            this.isPivotCol = rsmd.getColumnType(colIndex) == TbTypes.PIVOT;
        }


        private ColumnInfo(String name, String alias, boolean pivot) {
            colName = name;
            colAlias = alias;
            isPivotCol = pivot;
        }

        private void setPivot(TbPivotMeta pivotMeta) throws Exception{
            String str;
            pvColName = new ArrayList<String>();
            while (true) {
                str = pivotMeta.getNextColName(colIndex);
                if (str == null)
                    break;
                pvColCnt++;
                pvColName.add(str);
            }
        }
    }
}

