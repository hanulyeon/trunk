package com.tmax.hyperdata.ui_service.dao;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.OlapProjectInfo;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OlapProjectInfoDAO {
    private static OlapProjectInfoDAO olapProjectInfoDAO = new OlapProjectInfoDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public OlapProjectInfoDAO() {
    }

    public static OlapProjectInfoDAO getInstance() {
        return olapProjectInfoDAO;
    }

    public List<OlapProjectInfo> selectAll() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList olapProjectInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM OLAP_PROJECT_INFO ORDER BY NAME";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                OlapProjectInfo olapProjectInfo = new OlapProjectInfo();
                olapProjectInfo.setId(rs.getInt("id"));
                olapProjectInfo.setName(rs.getString("name"));
                olapProjectInfo.setAuthor(rs.getString("author"));
                olapProjectInfo.setLastEdited(rs.getTimestamp("last_edited"));
                olapProjectInfo.setContents(rs.getString("contents"));
                olapProjectInfo.setDescription(rs.getString("description"));
                olapProjectInfoList.add(olapProjectInfo);
            }
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            olapProjectInfoList = null;
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

        return olapProjectInfoList;
    }

    public void insertOlapProjectInfo(OlapProjectInfo olapProjectInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO OLAP_PROJECT_INFO(ID, NAME, AUTHOR, LAST_EDITED, CONTENTS, DESCRIPTION)" +
                    " VALUES" +
                    " (OLAP_PROJECT_INFO_ID_SEQ.NEXTVAL," +
                    " ?, ?, ?, ? ,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapProjectInfo.getName());
            pstmt.setString(2, olapProjectInfo.getAuthor());
            pstmt.setTimestamp(3, olapProjectInfo.getLastEdited());
            pstmt.setString(4, olapProjectInfo.getContents());
            pstmt.setString(5, olapProjectInfo.getDescription());
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

    public void modifyOlapProjectInfo(OlapProjectInfo olapProjectInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "UPDATE OLAP_PROJECT_INFO " +
                         "SET NAME = ?,"+
                         "SET AUTHOR = ?," +
                         "SET LAST_EDITED = ?," +
                         "SET CONTENTS = ?," +
                         "SET DESCRIPTION = ?" +
                         "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapProjectInfo.getName());
            pstmt.setString(2, olapProjectInfo.getAuthor());
            pstmt.setTimestamp(3, olapProjectInfo.getLastEdited());
            pstmt.setString(4, olapProjectInfo.getContents());
            pstmt.setString(5, olapProjectInfo.getDescription());
            pstmt.setInt(6, olapProjectInfo.getId());
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

    public void deleteOlapProjectInfo(OlapProjectInfo olapProjectInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM " +
                         "OLAP_PROJECT_INFO " +
                         "WHERE NAME = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapProjectInfo.getName());
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