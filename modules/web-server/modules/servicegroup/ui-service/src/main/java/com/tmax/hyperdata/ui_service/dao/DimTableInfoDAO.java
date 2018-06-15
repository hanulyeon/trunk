package com.tmax.hyperdata.ui_service.dao;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.DimTableInfo;
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
public class DimTableInfoDAO {
    private static DimTableInfoDAO dimTableInfoDAO = new DimTableInfoDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public DimTableInfoDAO() {
    }

    public static DimTableInfoDAO getInstance() { return dimTableInfoDAO; }

    public List<DimTableInfo> selectAll() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList dimTableInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM DIM_TABLE_INFO ORDER BY DIM_TABLE_NAME";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                DimTableInfo dimTableInfo = new DimTableInfo();
                dimTableInfo.setDimTableId(rs.getInt("dim_table_id"));
                dimTableInfo.setDimTableName(rs.getString("dim_table_name"));
                dimTableInfo.setDimTableColName(rs.getString("dim_table_col_name"));
                dimTableInfo.setDimTableColType(rs.getString("dim_table_col_type"));
                dimTableInfoList.add(dimTableInfo);
            }
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            dimTableInfoList = null;
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

        return dimTableInfoList;
    }

    // SELECT dimension tables by name
    public List<DimTableInfo> selectByName(String dimTableName) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList dimTableInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM DIM_TABLE_INFO WHERE DIM_TABLE_NAME LIKE ? ORDER BY DIM_TABLE_NAME";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + dimTableName + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DimTableInfo dimTableInfo = new DimTableInfo();

                dimTableInfo.setDimTableId(rs.getInt("dim_table_id"));
                dimTableInfo.setDimTableName(rs.getString("dim_table_name"));
                dimTableInfo.setDimTableColName(rs.getString("dim_table_col_name"));
                dimTableInfo.setDimTableColType(rs.getString("dim_table_col_type"));
                dimTableInfoList.add(dimTableInfo);

            }

            conn.commit();
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            dimTableInfoList = null;
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

        return dimTableInfoList;
    }

    public void insertDimTableInfo(DimTableInfo dimTableInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO DIM_TABLE_INFO(DIM_TABLE_ID, DIM_TABLE_NAME, DIM_TABLE_COL_NAME, DIM_TABLE_COL_TYPE)" +
                    " VALUES" +
                    " (DIM_TABLE_INFO_ID_SEQ.NEXTVAL," +
                    " ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dimTableInfo.getDimTableId());
            pstmt.setString(2, dimTableInfo.getDimTableName());
            pstmt.setString(3, dimTableInfo.getDimTableColName());
            pstmt.setString(4, dimTableInfo.getDimTableColType());
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

    public void modifyDimTableInfo(DimTableInfo dimTableInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "UPDATE DIM_TABLE_INFO " +
                    "SET DIM_TABLE_NAME = ?,"+
                    "SET DIM_TABLE_COL_NAME = ?," +
                    "SET DIM_TABLE_COL_TYPE = ?"+
                    "WHERE DIM_TABLE_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dimTableInfo.getDimTableName());
            pstmt.setString(2, dimTableInfo.getDimTableColName());
            pstmt.setString(3, dimTableInfo.getDimTableColType());
            pstmt.setInt(4, dimTableInfo.getDimTableId());
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

    public void deleteDimTableInfo(DimTableInfo dimTableInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM DIM_TABLE_INFO " +
                    "WHERE DIM_TABLE_NAME = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dimTableInfo.getDimTableName());
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
