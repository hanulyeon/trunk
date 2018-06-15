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
 * HyperData Project를 생성하는 API.
 */

public class ProjectCreate implements ServiceObject<Project, Project> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public Project input = null;

    public Project output = null;

    private HdServiceObjectLogger hdSoLogger = new HdServiceObjectLogger();;
    
    public ProjectCreate() {
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
            sb.append("INSERT INTO ").append(HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".PROJECT ");
            sb.append("(ID, NAME, AUTHOR, LAST_EDITED, CONTENTS, DESCRIPTION)");
            sb.append(" VALUES (HYPERDATA_WEB_SERVER.PROJECT_ID_SEQ.NEXTVAL, ?, ?, sysdate, ?, ?)");
            
            pstmt = conn.prepareStatement(sb.toString());
            
            pstmt.setString(1, input.getName());
            pstmt.setString(2, input.getAuthor());
            pstmt.setString(3, input.getContents());
            pstmt.setString(4, input.getDescription());
            
            hdSoLogger.printQueryString(Level.INFO, pstmt);
            
            if (pstmt.executeUpdate() < 0){
                logger.severe("[HyperData] PROJECT INSERT FAIL");
            }
            
            pstmt.close();
            
            sb = new StringBuffer("");
            sb.append("SELECT * ");
            sb.append("FROM ");
            sb.append("(");
            sb.append("SELECT ID, NAME, AUTHOR, LAST_EDITED, CONTENTS, DESCRIPTION ");
            sb.append("FROM ").append(HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".PROJECT ");
            sb.append("ORDER BY ROWNUM");
            sb.append(") ");
            sb.append("WHERE ROWNUM = 1");
            
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
                break;
            }
            
            hdSoLogger.printSuccess(Level.INFO, "Project created");
            
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
