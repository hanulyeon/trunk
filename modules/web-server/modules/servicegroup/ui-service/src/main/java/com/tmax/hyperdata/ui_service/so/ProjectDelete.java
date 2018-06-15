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
import com.tmax.hyperdata.ui_service.dto.Project;
import com.tmax.hyperdata.ui_service.dto.Project;
import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * @author cbo (byeongok_choi@tmax.com) 2018. 06. 06.
 * @version $Id$
 */

/**
 * HyperData Project�� �����ϴ� API.
 */

public class ProjectDelete implements ServiceObject<Project, Project> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public Project input = null;

    public Project output = null;

    private HdServiceObjectLogger hdSoLogger = new HdServiceObjectLogger();;
    
    public ProjectDelete() {
    }

    public Project service(Project arg0) throws Throwable {
        Connection conn = DBConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        input = (Project) arg0;
        output = new Project();

        try {
            /* Input Logging*/
            hdSoLogger.printInputDtoLog(Level.INFO, Project.getFieldPropertyMapByStatic().keySet(), input);
            
            StringBuffer sb = new StringBuffer("");
            sb.append("DELETE FROM ").append(HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".PROJECT ");
            sb.append("WHERE ID = ?");
            
            pstmt = conn.prepareStatement(sb.toString());
            
            pstmt.setString(1, input.getId());
            
            hdSoLogger.printQueryString(Level.INFO, pstmt);
            
            if (pstmt.executeUpdate() < 0){
                logger.severe("[HyperData] PROJECT DELETE FAIL");
            }
            
            output.setId(input.getId());
            hdSoLogger.printSuccess(Level.INFO, "Project Deleted");
            
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
