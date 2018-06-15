/**
 * TmaxData, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.ui_service.so;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.util.logging.Level;

import com.tmax.hyperdata.common.Const.HyperDataConst;
import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.common.util.HdServiceObjectLogger;
import com.tmax.hyperdata.ui_service.dto.Model;
import com.tmax.hyperdata.ui_service.dto.Model;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * @author cbo (byeongok_choi@tmax.com) 2018. 06. 06.
 * @version $Id$
 */

/**
 * HyperData Project를 생성하는 API.
 */

public class ModelDelete implements ServiceObject<Model, Model> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public Model input = null;

    public Model output = null;

    private HdServiceObjectLogger hdSoLogger = new HdServiceObjectLogger();;
    
    public ModelDelete() {
    }

    public Model service(Model arg0) throws Throwable {
        Connection conn = DBConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        input = (Model) arg0;
        output = new Model();

        try {
            /* Input Logging*/
            hdSoLogger.printInputDtoLog(Level.INFO, Model.getFieldPropertyMapByStatic().keySet(), input);
            
            StringBuffer sb = new StringBuffer("");
            sb.append("DELETE FROM ").append(HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".MODEL ");
            sb.append("WHERE ID = ?");
            
            pstmt = conn.prepareStatement(sb.toString());
            
            pstmt.setString(1, input.getId());
            
            hdSoLogger.printQueryString(Level.INFO, pstmt);
            
            if (pstmt.executeUpdate() < 0){
                logger.severe("[HyperData] MODEL DELETE FAIL");
            }
            
            output.setId(input.getId());
            hdSoLogger.printSuccess(Level.INFO, "Model Deleted");
            
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
