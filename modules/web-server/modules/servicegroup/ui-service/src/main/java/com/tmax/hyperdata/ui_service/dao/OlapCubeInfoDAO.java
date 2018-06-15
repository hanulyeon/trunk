package com.tmax.hyperdata.ui_service.dao;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.OlapCubeInfo;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OlapCubeInfoDAO {
    private static OlapCubeInfoDAO olapCubeInfoDAO = new OlapCubeInfoDAO();
    private static final ProObjectLogger logger = ServiceLogger.getLogger();

    public OlapCubeInfoDAO() {
    }

    public static OlapCubeInfoDAO getInstance() {
        return olapCubeInfoDAO;
    }

    public List<OlapCubeInfo> selectAll() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList olapCubeInfoList = new ArrayList();

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM OLAP_CUBE_INFO ORDER BY NAME";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                OlapCubeInfo olapCubeInfo = new OlapCubeInfo();
                olapCubeInfo.setId(rs.getInt("id"));
                olapCubeInfo.setName(rs.getString("name"));
                olapCubeInfo.setAuthor(rs.getString("author"));
                olapCubeInfo.setModelId(rs.getInt("model_id"));
                olapCubeInfo.setLastEdited(rs.getTimestamp("last_edited"));
                olapCubeInfo.setContents(rs.getString("contents"));
                olapCubeInfo.setDescription(rs.getString("description"));
                olapCubeInfoList.add(olapCubeInfo);
            }
        } catch (SQLException var10) {
            conn.rollback();
            var10.printStackTrace();
            olapCubeInfoList = null;
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

        return olapCubeInfoList;
    }

    public void insertOlapCubeInfo(OlapCubeInfo olapCubeInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO OLAP_CUBE_INFO(ID, NAME , AUTHOR, LAST_EDITED, MODEL_ID, CONTENTS, DESCRIPTION)" +
                    " VALUES" +
                    " (OLAP_CUBE_INFO_ID_SEQ.NEXTVAL," +
                    " ?, ?, ?, ?, ? ,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapCubeInfo.getName());
            pstmt.setString(2, olapCubeInfo.getAuthor());
            pstmt.setTimestamp(3, olapCubeInfo.getLastEdited());
            pstmt.setInt(4, olapCubeInfo.getModelId());
            pstmt.setString(5, olapCubeInfo.getContents());
            pstmt.setString(6, olapCubeInfo.getDescription());
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

    public void modifyOlapCubeInfo(OlapCubeInfo olapCubeInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "UPDATE OLAP_CUBE_INFO " +
                    "SET NAME = ?,"+
                    "SET AUTHOR = ?," +
                    "SET LAST_EDITED = ?,"+
                    "SET CONTENTS = ?," +
                    "SET DESCRIPTION = ?" +
                    "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapCubeInfo.getName());
            pstmt.setString(2, olapCubeInfo.getAuthor());
            pstmt.setTimestamp(3, olapCubeInfo.getLastEdited());
            pstmt.setString(4, olapCubeInfo.getContents());
            pstmt.setString(5, olapCubeInfo.getDescription());
            pstmt.setInt(6, olapCubeInfo.getId());
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

    public void deleteOlapCubeInfo(OlapCubeInfo olapCubeInfo) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM OLAP_CUBE_INFO " +
                         "WHERE NAME = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, olapCubeInfo.getName());
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