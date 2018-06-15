package com.tmax.hyperdata.ui_service.dao;

import com.mchange.v2.log.MLogger;
import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam;
import com.tmax.hyperdata.ui_service.dto.OlapModelParam;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hanul on 18. 6. 8.
 */
public class OlapCubeMeasureParamDAO {
    private static OlapCubeMeasureParamDAO olapCubeMeasureParamDAO = new OlapCubeMeasureParamDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public OlapCubeMeasureParamDAO() {
    }

    public static OlapCubeMeasureParamDAO getInstance() { return olapCubeMeasureParamDAO; }

     // SELECT Olap Cube Measure Param by id
    public List<OlapCubeMeasureParam> selectById(int cubeId) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList olapCubeMeasureParamList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM OLAP_CUBE_MEASURE_PARAM WHERE MODEL_ID LIKE ? ORDER BY CUBE_ID";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + cubeId + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                OlapCubeMeasureParam olapCubeMeasureParam = new OlapCubeMeasureParam();

                olapCubeMeasureParam.setCubeId(rs.getInt("cube_id"));
                olapCubeMeasureParam.setSelFactTableId(rs.getInt("sel_fact_table_id"));
                olapCubeMeasureParam.setSelMeasureColName(rs.getString("sel_measure_col_name"));
                olapCubeMeasureParam.setSelMeasureColValue(rs.getString("sel_measure_col_value"));
                olapCubeMeasureParam.setSelMeasureColType(rs.getString("sel_measure_col_type"));
                olapCubeMeasureParam.setSelMeasureColExpresion(rs.getString("sel_measure_col_expresion"));
                olapCubeMeasureParamList.add(olapCubeMeasureParam);

            }

            conn.commit();
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            olapCubeMeasureParamList = null;
            logger.info("SQLExcetion ={}", new Object[]{var10.getMessage()});
            throw var10;
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (rs != null) {
                rs.close();
            }

        }

        return olapCubeMeasureParamList;
    }

    public void insertOlapCubeMeasureParam(List<OlapCubeMeasureParam> olapCubeMeasureParamList) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO OLAP_CUBE_FACT_PARAM(CUBE_ID," +
                            " SEL_FACT_TABLE_ID" +
                            " SEL_MEASURE_COL_NAME," +
                            " SEL_MEASURE_COL_VALUE" +
                            " SEL_MEASURE_COL_TYPE" +
                            " SEL_MEASURE_COL_EXPRESION)" +
                    " VALUES" +
                    " (?, ?, ?, ?, ?, ?)" ;
            pstmt = conn.prepareStatement(sql);

            for(OlapCubeMeasureParam olapCubeMeasureParam : olapCubeMeasureParamList) {

            pstmt.setInt(1, olapCubeMeasureParam.getCubeId());
            pstmt.setInt(2, olapCubeMeasureParam.getSelFactTableId());
            pstmt.setString(3, olapCubeMeasureParam.getSelMeasureColName());
            pstmt.setString(4, olapCubeMeasureParam.getSelMeasureColValue());
            pstmt.setString(5, olapCubeMeasureParam.getNvlSelMeasureColType());
            pstmt.setString(6, olapCubeMeasureParam.getNvlSelMeasureColExpresion());
            pstmt.addBatch();
                conn.commit();
            }
        } catch (SQLException var8) {
            conn.rollback();
            logger.info("SQLException = {}", new Object[]{var8.getMessage()});
            throw var8;
        } finally {
            pstmt.executeBatch();
            if (pstmt != null) {
                pstmt.close();
            }
        }

    }

    public void modifyOlapModelParam(OlapModelParam olapModelParam) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "UPDATE FACT_TABLE_INFO " +
                    "SET FACT_TABLE_NAME = ?,"+
                    "SET FACT_TABLE_COL_NAME = ?," +
                    "SET FACT_TABLE_COL_TYPE = ?"+
                    "WHERE FACT_TABLE_ID = ?";
            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, olapModelParam.getFactTableName());
//            pstmt.setString(2, olapModelParam.getFactTableColName());
//            pstmt.setString(3, olapModelParam.getFactTableColType());
//            pstmt.setInt(4, olapModelParam.getFactTableId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException var8) {
            conn.rollback();
            logger.info("SQLException = {}", new Object[]{var8.getMessage()});
            throw var8;
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

        }

    }

    public void deleteOlapModelParam(OlapModelParam olapModelParam) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM OLAP_MODEL_PARAM " +
                    "WHERE MODEL_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, olapModelParam.getModelId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException var8) {
            conn.rollback();
            logger.info("SQLException = {}", new Object[]{var8.getMessage()});
            throw var8;
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

        }

    }
}
