package com.tmax.hyperdata.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.m.msl.logger.MLogger;
import com.tmax.hyperdata.error.TbHdError;
import com.tmax.hyperdata.error.TbHdException;
import com.tmax.hyperdata.util.SQLUtil;
import com.tmax.hyperdata.util.TbHdSession;

/**
 * FIXME class description.
 * 
 * @author hongsu (hongsu@tmaxdata.com) 2015. 11. 3.
 * @version $Id: TbHdSessionManager.java 11 2017-12-07 03:24:29Z taebo $
 */
public class TbHdSessionManager {

    static class TotalSessionMap {
        Map<String, TbHdSession> sessionMap;
        Map<String, TbHdSession> flowInstMap;

        public TotalSessionMap() {
            sessionMap = new HashMap<String, TbHdSession>();
            flowInstMap = new HashMap<String, TbHdSession>();
        }

        public Map<String, TbHdSession> getSessionMap() {
            return sessionMap;
        }

        public Map<String, TbHdSession> getFlowInstnMap() {
            return flowInstMap;
        }
    }
    /* key = sessionId */

    private static TotalSessionMap cacheMap;

    public static void init() {
        cacheMap = new TotalSessionMap();

    }

    public static boolean hasSession(String sessionId) {
        return cacheMap.getSessionMap().containsKey(sessionId);
    }

    public static TbHdSession getSessionForSessionId(String sessionId) {
        return cacheMap.getSessionMap().get(sessionId);
    }

    public static TbHdSession getSessionForFlowInstId(String flowInstId) {
        return cacheMap.getFlowInstnMap().get(flowInstId);
    }

    public static void putSession(String sessionId, TbHdSession session) {
        synchronized (cacheMap) {
            Map<String, TbHdSession> data = cacheMap.getSessionMap();
            if (!hasSession(sessionId)) {
                data.put(sessionId, session);
                if (session.getInstanceId() != null) {
                    data = cacheMap.getFlowInstnMap();
                    data.put(session.getInstanceId(), session);
                }
            }
        }
    }

    public static void putSessionForFlowInstId(String beforeFlowInstId,
                                               TbHdSession session) {
        synchronized (cacheMap) {
            Map<String, TbHdSession> data = cacheMap.getFlowInstnMap();
            data.remove(beforeFlowInstId);
            data.put(session.getInstanceId(), session);
        }
    }

    public static void removeSessionForFlowInstId(String flowInstId)
        throws TbHdException {
        try {
            TbHdSession data = null;
            synchronized (cacheMap) {
                data = cacheMap.getFlowInstnMap().remove(flowInstId);
            }
            ResultSet rs = data.getResultSet();
            Statement stmt = data.getStatement();
            Connection conn = data.getConnection();
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                         e.getMessage());
        }
    }

    public static void removeSession(String sessionId)
        throws TbHdException {
        try {
            if (hasSession(sessionId)) {
                TbHdSession data = null;
                synchronized (cacheMap) {
                    data = cacheMap.getSessionMap().remove(sessionId);
                    cacheMap.getFlowInstnMap().remove(data.getInstanceId());
                }
                ResultSet rs = data.getResultSet();
                Statement stmt = data.getStatement();
                Connection conn = data.getConnection();
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                SQLUtil.execStatement(conn, "DROP PROCEDURE " +
                        data.getProcedureName());

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }
        }
        catch (SQLException e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.INTERNAL_ERROR_SQL,
                                         e.getMessage());
        }
    }

    public static void allClose(){

    }
}
