/**
 * TmaxData, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.ui_service.so;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import com.tmax.hyperdata.common.Const.HyperDataConst;
import com.tmax.hyperdata.common.DBConnection.DBConnectionManager;
import com.tmax.hyperdata.common.util.HdServiceObjectLogger;
import com.tmax.hyperdata.ui_service.dto.Empty;
import com.tmax.hyperdata.ui_service.dto.Model;
import com.tmax.hyperdata.ui_service.dto.ModelList;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * @author cbo (byeongok_choi@tmax.com) 2018. 06. 06.
 * @version $Id$
 */

/**
 * HyperData Project를 생성하는 API.
 */

public class ModelsList implements ServiceObject<Empty, ModelList> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public Empty input = null;
    
    public Model output = null;

    public ModelList outputs = null;

    private HdServiceObjectLogger hdSoLogger = new HdServiceObjectLogger();;
    
    public ModelsList() {
    }

    public ModelList service(Empty arg0) throws Throwable {
        Connection conn = DBConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        input = (Empty) arg0;
        output = new Model();
        outputs = new ModelList();

        try {
            /* TO-DO: user management (authority, project author, etc.) */
            
            StringBuffer sb = new StringBuffer("");
            sb.append("SELECT ID, NAME, AUTHOR, STATUS, LAST_EDITED, PROJECT_ID, DESCRIPTION, FLOW_ID ");
            sb.append("FROM " + HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".MODEL ");
            sb.append("WHERE PROJECT_ID = ?");
            
            pstmt = conn.prepareStatement(sb.toString());
            
            /* ASSUME ONLY ONE PROJECT COULD BE CHOSEN 
             * (selectedProjects.length == 1)
             * */
            
            String[] selectedProjects = ServiceManager.getCurrentRequestContext().getRequest().getQueryString("projectId");
            
            for (String selectedProjectId : selectedProjects){
                if (selectedProjectId == null){
                    throw new Exception (HdServiceObjectLogger.logProductName + "NULL PROJECT ID");
                }
                pstmt.setString(1, selectedProjectId);
            }
            
            hdSoLogger.printQueryString(Level.INFO, pstmt);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()){
                output.setId(rs.getString(1));
                output.setName(rs.getString(2));
                output.setAuthor(rs.getString(3));
                output.setAuthor(rs.getString(4));
                output.setLastEdited(rs.getTimestamp(5));
                output.setProjectId(rs.getString(6));
                output.setDescription(rs.getString(7));
                output.setFlowId(rs.getString(8));
                
                outputs.addModel(output);
                output = new Model();
            }
            
            hdSoLogger.printSuccess(Level.INFO, "Project list GET SUCCESS");
            
        } catch (Exception e) {
            throw new Exception(e);

        }
        finally {
            if (pstmt != null)
                pstmt.close();
            if (rs != null)
                rs.close();
        }
        return outputs;
    }
}
