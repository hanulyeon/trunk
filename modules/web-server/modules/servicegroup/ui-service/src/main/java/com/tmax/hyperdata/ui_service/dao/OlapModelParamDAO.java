package com.tmax.hyperdata.ui_service.dao;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.FactTableInfo;
import com.tmax.hyperdata.ui_service.dto.OlapModelParam;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanul on 18. 6. 8.
 */
public class OlapModelParamDAO {
    private static OlapModelParamDAO olapModelParamDAO = new OlapModelParamDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public OlapModelParamDAO() {
    }

    public static OlapModelParamDAO getInstance() { return olapModelParamDAO; }

     // SELECT Model Param by id
    public List<OlapModelParam> selectByName(String modelId) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList olapModelParamList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM OLAP_MODEL_PARAM WHERE MODEL_ID LIKE ? ORDER BY MODEL_ID";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + modelId + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                OlapModelParam olapModelParam = new OlapModelParam();

                olapModelParam.setModelId(rs.getInt("model_id"));
                olapModelParam.setRefFactTableId(rs.getInt("ref_fact_table_id"));
                olapModelParam.setRefFactTableName(rs.getString("ref_fact_table_name"));
                olapModelParam.setRefFactTableColName(rs.getString("ref_fact_table_col_name"));
                olapModelParam.setRefFactTableColType(rs.getString("ref_fact_table_col_type"));
                olapModelParam.setRefDimTableId(rs.getInt("ref_dim_table_id"));
                olapModelParam.setRefDimTableName(rs.getString("ref_dim_table_name"));
                olapModelParam.setRefDimTableColName(rs.getString("ref_dim_table_col_name"));
                olapModelParam.setRefDimTableColType(rs.getString("ref_dim_table_col_type"));
                olapModelParamList.add(olapModelParam);

            }

            conn.commit();
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            olapModelParamList = null;
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

        return olapModelParamList;
    }

    public void insertOlapModelParam(OlapModelParam olapModelParam) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO FACT_TABLE_INFO(FACT_TABLE_ID, FACT_TABLE_NAME, FACT_TABLE_COL_NAME, FACT_TABLE_COL_TYPE)" +
                    " VALUES" +
                    " (FACT_TABLE_INFO_ID_SEQ.NEXTVAL," +
                    " ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, olapModelParam.getFactTableId());
//            pstmt.setString(2, olapModelParam.getFactTableName());
//            pstmt.setString(3, olapModelParam.getFactTableColName());
//            pstmt.setString(4, olapModelParam.getFactTableColType());
//            pstmt.executeUpdate();
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
