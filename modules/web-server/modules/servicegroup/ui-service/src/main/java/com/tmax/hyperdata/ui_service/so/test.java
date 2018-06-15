/**
 * TmaxData, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.ui_service.so;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.ui_service.dto.Empty;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;
// import com.tmax.proobject.core.ServiceObject;
import com.tmax.proobject.model.service.ServiceObject;



/**
 * @author cbo (byeongok_choi@tmax.com) 2017. 12. 12.
 * @version $Id$
 */

/**
 * 
 */

public class test implements ServiceObject<Empty, Empty> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();

    public Empty input = null;

    public Empty output = null;

    public test() {
    }

    public Empty service(Empty arg0) throws Throwable {
        Connection conn = DBConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        input = (Empty) arg0;
        output = new Empty();

        try {
               String inputMsg = input.getMessage();
               int    dbResult = 0;
               
               pstmt = conn.prepareStatement("SELECT * FROM PRS_TEST.T1");
               rs = pstmt.executeQuery();
               
               while(rs.next()){
                   dbResult = rs.getInt(1);
               }
               
               output.setMessage("Received msg: " + inputMsg + "DB Query result = " + Integer.toString(dbResult));
               
            
        } catch (Exception e) {
            throw new Exception(e);

        }
        finally {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
        }
        return output;
    }
}
