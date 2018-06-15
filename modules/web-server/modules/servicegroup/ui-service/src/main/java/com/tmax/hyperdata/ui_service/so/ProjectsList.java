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
import com.tmax.hyperdata.ui_service.dto.Project;
import com.tmax.hyperdata.ui_service.dto.ProjectList;
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

public class ProjectsList implements ServiceObject<Empty, ProjectList> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public Empty input = null;
    
    public Project output = null;

    public ProjectList outputs = null;

    private HdServiceObjectLogger hdSoLogger = new HdServiceObjectLogger();;
    
    public ProjectsList() {
    }

    public ProjectList service(Empty arg0) throws Throwable {
        Connection conn = DBConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        input = (Empty) arg0;
        output = new Project();
        outputs = new ProjectList();

        try {
            /* TO-DO: user management (authority, project author, etc.) */
            
            StringBuffer sb = new StringBuffer("");
            sb.append("SELECT ID, NAME, AUTHOR, LAST_EDITED, CONTENTS, DESCRIPTION ");
            sb.append("FROM " + HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".PROJECT ");
            
            pstmt = conn.prepareStatement(sb.toString());
            
            hdSoLogger.printQueryString(Level.INFO, pstmt);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()){
                output.setId(rs.getString(1));
                output.setName(rs.getString(2));
                output.setAuthor(rs.getString(3));
                output.setLastEdited(rs.getTimestamp(4));
                output.setContents(rs.getString(5));
                output.setDescription(rs.getString(6));
                
                outputs.addProject(output);
                output = new Project();
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
