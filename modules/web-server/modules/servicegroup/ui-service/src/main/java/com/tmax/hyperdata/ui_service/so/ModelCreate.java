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

public class ModelCreate implements ServiceObject<Model, Model> {

    //Log for development
    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public Model input = null;

    public Model output = null;

    private HdServiceObjectLogger hdSoLogger = new HdServiceObjectLogger();;
    
    public ModelCreate() {
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
            sb.append("INSERT INTO ").append(HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".MODEL ");
            sb.append("(ID, NAME, AUTHOR, STATUS, LAST_EDITED, PROJECT_ID, DESCRIPTION, FLOW_ID)");
            sb.append(" VALUES (HYPERDATA_WEB_SERVER.MODEL_ID_SEQ.NEXTVAL, ?, 'CREATED', ?, sysdate, ?, ?, ?)");
            
            pstmt = conn.prepareStatement(sb.toString());
            
            pstmt.setString(1, input.getName());
            pstmt.setString(2, input.getAuthor());
            pstmt.setString(3, input.getProjectId());
            pstmt.setString(4, input.getDescription());
            pstmt.setString(5, input.getFlowId());
            
            hdSoLogger.printQueryString(Level.INFO, pstmt);
            
            if (pstmt.executeUpdate() < 0){
                logger.severe("[HyperData] MODEL INSERT FAIL");
            }
            
            pstmt.close();
            
            sb = new StringBuffer("");
            sb.append("SELECT * ");
            sb.append("FROM ");
            sb.append("(");
            sb.append("SELECT ID, NAME, AUTHOR, STATUS, LAST_EDITED, PROJECT_ID, DESCRIPTION, FLOW_ID ");
            sb.append("FROM ").append(HyperDataConst.WEB_SERVER_DB_USER_NAME).append(".MODEL ");
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
                output.setAuthor(rs.getString(4));
                output.setLastEdited(rs.getTimestamp(5));
                output.setProjectId(rs.getString(6));
                output.setDescription(rs.getString(7));
                output.setFlowId(rs.getString(8));
                break;
            }
            
            hdSoLogger.printSuccess(Level.INFO, "Model created");
            
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
