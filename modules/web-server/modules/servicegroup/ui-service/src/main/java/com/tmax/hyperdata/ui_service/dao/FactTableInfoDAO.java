package com.tmax.hyperdata.ui_service.dao;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.FactTableInfo;
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
public class FactTableInfoDAO {
    private static FactTableInfoDAO factTableInfoDAO = new FactTableInfoDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public FactTableInfoDAO() {
    }

    public static FactTableInfoDAO getInstance() { return factTableInfoDAO; }

    public List<FactTableInfo> selectAll() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList factTableInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM FACT_TABLE_INFO ORDER BY NAME";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                FactTableInfo factTableInfo = new FactTableInfo();
                factTableInfo.setFactTableId(rs.getInt("fact_table_id"));
                factTableInfo.setFactTableName(rs.getString("fact_table_name"));
                factTableInfo.setFactTableColName(rs.getString("fact_table_col_name"));
                factTableInfo.setFactTableColType(rs.getString("fact_table_col_type"));
                factTableInfoList.add(factTableInfo);
            }
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            factTableInfoList = null;
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

        return factTableInfoList;
    }

    // SELECT fact tables by name
    public List<FactTableInfo> selectByName(String factTableName) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList factTableInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM FACT_TABLE_INFO WHERE FACT_TABLE_NAME LIKE ? ORDER BY FACT_TABLE_NAME";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + factTableName + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                FactTableInfo factTableInfo = new FactTableInfo();

                factTableInfo.setFactTableId(rs.getInt("fact_table_id"));
                factTableInfo.setFactTableName(rs.getString("fact_table_name"));
                factTableInfo.setFactTableColName(rs.getString("fact_table_col_name"));
                factTableInfo.setFactTableColType(rs.getString("fact_table_col_type"));
                factTableInfoList.add(factTableInfo);

            }

            conn.commit();
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            factTableInfoList = null;
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

        return factTableInfoList;
    }

    public void insertFactTableInfo(FactTableInfo factTableInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO FACT_TABLE_INFO(FACT_TABLE_ID, FACT_TABLE_NAME, FACT_TABLE_COL_NAME, FACT_TABLE_COL_TYPE)" +
                    " VALUES" +
                    " (FACT_TABLE_INFO_ID_SEQ.NEXTVAL," +
                    " ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, factTableInfo.getFactTableId());
            pstmt.setString(2, factTableInfo.getFactTableName());
            pstmt.setString(3, factTableInfo.getFactTableColName());
            pstmt.setString(4, factTableInfo.getFactTableColType());
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

    public void modifyFactTableInfo(FactTableInfo factTableInfo) throws Exception {
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
            pstmt.setString(1, factTableInfo.getFactTableName());
            pstmt.setString(2, factTableInfo.getFactTableColName());
            pstmt.setString(3, factTableInfo.getFactTableColType());
            pstmt.setInt(4, factTableInfo.getFactTableId());
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

    public void deleteFactTableInfo(FactTableInfo factTableInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM FACT_TABLE_INFO " +
                    "WHERE FACT_TABLE_NAME = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, factTableInfo.getFactTableName());
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
