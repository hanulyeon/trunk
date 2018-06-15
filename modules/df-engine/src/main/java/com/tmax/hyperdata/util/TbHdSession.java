package com.tmax.hyperdata.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TbHdSession {
    private Connection Conn;
    private String instId;
    private String sessionId;
    private String flowId;
    private String procedureName;

    private Statement stmt;
    private ResultSet rs;

    public TbHdSession(String sessionId, Connection Conn) {
        this.Conn = Conn;
        this.sessionId = sessionId;
    }

    public String getFlowId() {
        return flowId;
    }

    public String getInstanceId() {
        return instId;
    }

    public Connection getConnection() {
        return Conn;
    }

    public ResultSet getResultSet() {
        return rs;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Statement getStatement() {
        return stmt;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public void setInstanceId(String instId) {
        this.instId = instId;
    }

    public void setConnection(Connection Conn) {
        this.Conn = Conn;
    }

    public void setResultSet(ResultSet rs) {
        this.rs = rs;
    }

    public String getProcedureName() {
        return flowId + '_' + instId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setStatement(Statement stmt) {
        this.stmt = stmt;
    }
}
