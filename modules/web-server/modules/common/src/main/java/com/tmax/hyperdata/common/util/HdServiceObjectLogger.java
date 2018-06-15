package com.tmax.hyperdata.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.util.Set;
import java.util.logging.Level;

import com.tmax.proobject.engine.logger.ServiceLogger;
import com.tmax.proobject.logger.ProObjectLogger;

public class HdServiceObjectLogger {
    
    public HdServiceObjectLogger() {
        super();
        // TODO Auto-generated constructor stub
    }

    private ProObjectLogger logger = ServiceLogger.getLogger();
    
    public void readWebServerLogLevel (){
   
    }
    
    public static String logProductName = "[HyperData] ";  
    
    /* Description: Web client�� ���� ���޹��� input data�� Ȯ���ϴ� log method
     * Parameters
     *  logLevel: HyperData Web Server ��ü �α� ����
     *  keySet: Input dto�� key set
     *  input: ������ ���� input dto instance
     */
    public void printInputDtoLog(Level logLevel, Set<String> keySet, Object input) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method getMethod = input.getClass().getMethod("get", String.class);
        
        logger.log(logLevel, "------------------------------------------");
        logger.log(logLevel, logProductName + "Service Input Information");
        logger.log(logLevel, "++++++++++++++++++++++++++++++++++++++++++");
        
        for (String key : keySet){
            logger.log(logLevel, key + ": " + getMethod.invoke(input, key));
        }
        
        logger.log(logLevel, "++++++++++++++++++++++++++++++++++++++++++");
        logger.log(logLevel, "------------------------------------------");
    }
    
    public void printQueryString(Level logLevel, PreparedStatement pstmt){
        logger.log(logLevel, logProductName + "PROJECT INSERT QUERY: " + pstmt.toString());
    }
    
    public void printSuccess(Level logLevel, String msg){
        logger.log(logLevel, logProductName + msg);
    }
}
