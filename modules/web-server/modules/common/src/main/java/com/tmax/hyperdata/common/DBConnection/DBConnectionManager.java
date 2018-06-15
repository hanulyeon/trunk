/**
 * TmaxData, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.common.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ChannelEventLogger;

/**
 * @author Byeongok_Choi (byeongok_choi@tmaxdata.com) 2018. 5. 23.
 * @version $Id$
 */

/**
 * Jeus로부터 Datasource를 얻어와 Connection을 제공하는 Manager.
 */

public class DBConnectionManager {

    private static ProObjectLogger logger = ChannelEventLogger.getLogger();
    
    private static DBConnectionManager DBConnectionManager;
    private static Connection connection;
    private DBConnectionManager(){
        
    }

    public static DBConnectionManager getInstance() {
        if (DBConnectionManager != null) {
            return DBConnectionManager;
        }
        DBConnectionManager = new DBConnectionManager();
        return DBConnectionManager;
    }

    public Connection getConnection() throws Exception {
        if (connection != null)
            return connection;

        DataSource dataSource = null;
        
        try {
            Hashtable<String, String> ht = new Hashtable<String, String>();
            InitialContext ctx = new InitialContext(ht);
            dataSource = (DataSource) ctx.lookup("tibero6");
            
        } catch (NamingException e) {
            throw new Exception(e);
        }

        try {
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
    
}
