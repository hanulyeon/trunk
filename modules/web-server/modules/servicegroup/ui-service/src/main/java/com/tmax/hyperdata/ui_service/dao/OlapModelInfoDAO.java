package com.tmax.hyperdata.ui_service.dao;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.OlapModelInfo;
import com.tmax.hyperdata.ui_service.dto.OlapProjectInfo;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OlapModelInfoDAO {
    private static OlapModelInfoDAO olapModelInfoDAO = new OlapModelInfoDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public OlapModelInfoDAO() {
    }

    public static OlapModelInfoDAO getInstance() {
        return olapModelInfoDAO;
    }

    public List<OlapModelInfo> selectAll() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList olapModelInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM OLAP_MODEL_INFO ORDER BY NAME";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                OlapModelInfo olapModelInfo = new OlapModelInfo();
                olapModelInfo.setId(rs.getInt("id"));
                olapModelInfo.setName(rs.getString("name"));
                olapModelInfo.setAuthor(rs.getString("author"));
                olapModelInfo.setProjectId(rs.getString("project_id"));
                olapModelInfo.setLastEdited(rs.getTimestamp("last_edited"));
                olapModelInfo.setContents(rs.getString("contents"));
                olapModelInfo.setDescription(rs.getString("description"));
                olapModelInfoList.add(olapModelInfo);
            }
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            olapModelInfoList = null;
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

        return olapModelInfoList;
    }

    public void insertOlapModelInfo(OlapModelInfo olapModelInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO OLAP_MODEL_INFO(ID, NAME , AUTHOR, LAST_EDITED, PROJECT_ID, CONTENTS, DESCRIPTION)" +
                    " VALUES" +
                    " (OLAP_MODEL_INFO_ID_SEQ.NEXTVAL," +
                    " ?, ?, ?, ?, ? ,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapModelInfo.getName());
            pstmt.setString(2, olapModelInfo.getAuthor());
            pstmt.setTimestamp(3, olapModelInfo.getLastEdited());
            pstmt.setInt(4, olapModelInfo.getProjectId());
            pstmt.setString(5, olapModelInfo.getContents());
            pstmt.setString(6, olapModelInfo.getDescription());
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

    public void modifyOlapModelInfo(OlapModelInfo olapModelInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "UPDATE OLAP_MODEL_INFO " +
                    "SET NAME = ?,"+
                    "SET AUTHOR = ?," +
                    "SET LAST_EDITED = ?,"+
                    "SET CONTENTS = ?," +
                    "SET DESCRIPTION = ?" +
                    "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapModelInfo.getName());
            pstmt.setString(2, olapModelInfo.getAuthor());
            pstmt.setTimestamp(3, olapModelInfo.getLastEdited());
            pstmt.setString(4, olapModelInfo.getContents());
            pstmt.setString(5, olapModelInfo.getDescription());
            pstmt.setInt(6, olapModelInfo.getId());
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

    public void deleteOlapModelInfo(OlapModelInfo olapModelInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM OLAP_MODEL_INFO " +
                         "WHERE NAME = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapModelInfo.getName());
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