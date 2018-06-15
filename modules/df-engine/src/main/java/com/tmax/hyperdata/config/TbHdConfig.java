package com.tmax.hyperdata.config;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Level;

//import com.tmax.hyperdata.manager.TbHdSchedulerManager;

/**
 * @author HongsuRyu (hongsu_ryu@tmaxdata.com) 2015. 5. 29.
 * @version $Id: TbHdConfig.java 14 2018-02-13 09:34:56Z hyunjeong_shin $
 */

/**
 * FIXME class description.
 */
public class TbHdConfig {
    /* Debug 용 configure 변수 */
    public enum HyperDataMode {
        CMD,
        WEB
    };

    public static HyperDataMode START_MODE = HyperDataMode.WEB;

    public static final String DIR_EXT_NAME = "FILE_DIR";
    
    public static final String DIR_WRITE_NAME = "FILE_WRITE_DIR";

    // DYNAMIC PARAMETERS
    public static final String CONFIG_NAME_TIMEOUT = "timeout";
    public static final String CONFIG_NAME_TOTAL_LIMIT = "total_limit";
    public static final String CONFIG_NAME_DEPT_LIMIT = "dept_limit";
    public static final String CONFIG_NAME_FILE_INPUT_DIR = "file_input_dir";
    public static final String CONFIG_NAME_FILE_OUTPUT_DIR = "file_output_dir";
    public static final String CONFIG_NAME_LOG_DURATION = "log_duration";
    public static final String CONFIG_NAME_NO_DROP = "no_drop";
    public static final String CONFIG_NAME_DATE_FORMAT = "date_format";
    public static final String CONFIG_NAME_SHOW_TIME_LOG = "show_time_log";
    public static final String CONFIG_NAME_TABLE_MAX_SIZE = "table_max_size";
    public static final String CONFIG_NAME_REMOTE_SQL_LOG = "remote_sql_log";
    public static final String CONFIG_NAME_OP_INST = "op_inst";
    public static final String CONFIG_NAME_SERVER_OUTPUT_FILE_LIMIT = "server_output_file_limit";
    public static final String CONFIG_NAME_FORCE_BYTE_ORDER_MARK = "force_byte_order_mark";
    public static final String CONFIG_NAME_FETCH_ROW_COUNT = "result_fetch_row_count";

    // STATIC PARAMETERS
    private static final String CONFIG_NAME_DRIVER_CLASS = "connection.driver_class";

    private static final String CONFIG_NAME_MDB_URL = "hyperdata.meta.url";
    private static final String CONFIG_NAME_MDB_ID = "hyperdata.meta.username";
    private static final String CONFIG_NAME_MDB_PASS = "hyperdata.meta.password";

    private static final String CONFIG_NAME_EDB_URL = "hyperdata.exec.url";
    private static final String CONFIG_NAME_EDB_ID = "hyperdata.exec.username";
    private static final String CONFIG_NAME_EDB_PASS = "hyperdata.exec.password";

    private static final String CONFIG_NAME_ADMIN_OP = "tbhub.admin_operations";
    private static final String CONFIG_NAME_HOST_ID = "hyperdata.host_id";
    private static final String CONFIG_NAME_RENDEZVOUS = "hyperdata.rendezvous";

    private static final String CONFIG_NAME_LOG_PATH = "log4j.main_path";
    private static final String CONFIG_NAME_LOG_PATTERN = "log4j.pattern";
    private static final String CONFIG_NAME_LOG_LEVEL = "log4j.level";

    private static final String CONFIG_NAME_USE_CONNECTION_POOL = "tbhub.exec.use_connection_pool";

    // DEFAULT VALUES
    private static final int DEFAULT_TIMEOUT = 60;
    private static final int DEFAULT_TOTAL_LIMIT = 30;
    private static final int DEFAULT_LOG_DURATION = 30;
    private static final String DEFAULT_FILE_INPUT_DIR = "/home/hyperdata/input";
    private static final String DEFAULT_FILE_OUTPUT_DIR = "/home/hyperdata/output";

    private static final String DEFAULT_DATE_FORMAT = "YYYY-MM-DD HH24:MI:SS";
    private static final String DEFAULT_LOG_PATTERN = "%5p ({%t} %F[%M]:%L) [%d] - %m%n";
    private static final String DEFAULT_LOG_LEVEL = "INFO";
    private static final boolean DEFAULT_SHOW_TIME_LOG = false;
    private static final int DEFAULT_TABLE_MAX_SIZE = 0;
    private static final boolean DEFAULT_NO_DROP = false;
    private static final boolean DEFAULT_REMOTE_SQL_LOG = false;
    private static final boolean DEFAULT_OP_INST = false;
    private static final boolean DEFAULT_FORCE_BYTE_ORDER_MARK = false;
    private static final int DEFAULT_CONFIG_NAME_FETCH_ROW_COUNT = 100;

    /* HyperData Flow 실행 scheduler의 총 thread 개수 설정하는 옵션. */
    private static int execFlowSchedulerThreadCount = DEFAULT_TOTAL_LIMIT;

    // CONSTANTS
    private static final String TOKENS = ",\n \t\r";

    private static String dbDriver = "com.tmax.tibero.jdbc.TbDriver";
    // default meta DB connection information
    private static String connUrl = "jdbc:tibero:thin:@localhost:31777:DEFAULT";
    private static String connUsername = "sys";
    private static String connPassword = "tibero";

    //log4j setting parameter
    private static String log4jMainPath;
    private static String logPattern;
    private static String logLevel;

    // tbhub parameter
    private static String hostId = "";
    private static String classRendezvous;
    private static boolean useConnectionPool;

    // dynamic parameter
    private static int timeout;
    private static int totalLimit;
    private static String fileInputDir;
    private static String fileOutputDir;
    private static int logDuration;
    private static boolean noDrop;
    private static String dateFormat;
    private static boolean showTimeLog;
    private static int maxTableSize;
    private static boolean remoteSqlLog;
    private static boolean opInst;
    private static boolean foreceByteOrderMark;
    private static int resultFetchRowCnt;

    private static boolean getBooleanValue(String value) {
        return value.equalsIgnoreCase("Y");
    }

    private static boolean getBooleanValue(String value, boolean defaultValue) {
        if (value == null)
            return defaultValue;

        return value.equalsIgnoreCase("Y");
    }

    /**
     * @return the classRendezvous
     */
    public static String getClassRendezvous() {
        return classRendezvous;
    }

    public static String getDateFormat() {
        return dateFormat;
    }

    /**
     * @return the dbDriver
     */
    public static String getDbDriver() {
        return dbDriver;
    }

    /**
     * @return Flow 실행 scheduler thread count
     */
    public static int getExecFlowSchedulerThreadCount() {
        return execFlowSchedulerThreadCount;
    }

    /**
     * @return the fileInputDir
     * @throws Exception
     */
    public static synchronized String getFileInputDir() {
        if (fileInputDir.lastIndexOf(File.separator) != fileInputDir.length() -
                1) {
            return fileInputDir + File.separator;
        }
        return fileInputDir;
    }

    /**
     * @return the fileOutputDir
     * @throws Exception
     */
    public static String getFileOutputDir() {
        if (fileOutputDir
                .lastIndexOf(File.separator) != fileOutputDir.length() - 1) {
            return fileOutputDir + File.separator;
        }
        return fileOutputDir;
    }

    private static float getFloatValue(String value, float defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return Float.parseFloat(value);
    }

    public static String getHostId() {
        return hostId;
    }

    private static int getIntValue(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * @return the log4jMainPath
     */
    public static String getLog4jMainPath() {
        return log4jMainPath;
    }

    public static String getLogDate() {
        return getLog4jMainPath() +
                String.format("%1$tY%1$tm%1$td", Calendar.getInstance()) +
                File.separator;
    }

    public static int getLogDuration() {
        return logDuration;
    }

    /**
     * @return the logLevel
     */
    public static String getLogLevel() {
        return logLevel;
    }

    /**
     * @return the logLevel
     */
    public static Level getLogLevel2() {
        return Level.toLevel(logLevel, Level.INFO);
    }

    /**
     * @return the logPattern
     */
    public static String getLogPattern() {
        return logPattern;
    }

    public static int getMaxTableSize() {
        return maxTableSize;
    }

    /**
     * @return HyperData password of meta connection.
     */
    public static String getConnPassword() {
        return connPassword;
    }

    /**
     * @return HyperData JDBC connection URL for meta.
     */
    public static String getConnUrl() {
        return connUrl;
    }

    /**
     * @return HyperData username of meta connection.
     */
    public static String getConnUsername() {
        return connUsername;
    }

    private static String getParamFromDB(Connection conn, String hostId,
                                         String name) {
        String sql = null;
        PreparedStatement pstmt = null;
        String value = null;
        if (conn != null) {
            sql = "SELECT PARAM_VALUE FROM HYPERDATA_CFG WHERE HOST_ID=? AND PARAM_NAME=?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, hostId);
                pstmt.setString(2, name);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    value = rs.getString(1);
                }
            }
            catch (SQLException e) {

            }
            finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                }
                catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public static int getResultFetchRowCnt() {
        return resultFetchRowCnt;
    }

    private static String getStringValue(String value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        else {
            return value;
        }
    }

    public static int getTableMaxSize() {
        return maxTableSize;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static int getTotalLimit() {
        return totalLimit;
    }

    public static void initConfig(String fileName) throws Exception {
        /* JEUS위에서 수행하는 경우에는 JEUS JVM 설정란에
         * -Ddh.path.home을 설정 후 해당 디렉토리에 config
         * 파일을 두고 사용, 이클립스에서 수행하는 경우에는 src의 config 사용 */
        String hdHome = System.getProperty("hd.path.home");
        if (hdHome != null) {
            fileName = hdHome + "/config.xml";
        }
        else {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                cl = ClassLoader.getSystemClassLoader();
            }
            URL url = cl.getResource(fileName);
            fileName = url.getFile();
        }
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream(fileName));

        dbDriver = properties.getProperty(CONFIG_NAME_DRIVER_CLASS);
        connUrl = properties.getProperty(CONFIG_NAME_MDB_URL);
        connUsername = properties.getProperty(CONFIG_NAME_MDB_ID);
        connPassword = properties.getProperty(CONFIG_NAME_MDB_PASS);

        useConnectionPool = Boolean.parseBoolean(properties
                .getProperty(CONFIG_NAME_USE_CONNECTION_POOL));

        System.out.println(dbDriver);
        System.out.println("MetaDB: " + connUrl);

//        String admin = properties.getProperty(CONFIG_NAME_ADMIN_OP);
//        if (admin != null) {
//            StringTokenizer token = new StringTokenizer(admin, TOKENS);
//            while (token.hasMoreTokens()) {
//                TbHdRequestXmlParser.setAdminFunc(new String(token.nextToken().trim()));
//            }
//        }

        String strHost = properties.getProperty(CONFIG_NAME_HOST_ID);
        if (strHost != null) {
            hostId = strHost;
        }

        setClassRendezvous(properties.getProperty(CONFIG_NAME_RENDEZVOUS));
        log4jMainPath = properties.getProperty(CONFIG_NAME_LOG_PATH);
        if (log4jMainPath == null) {
            log4jMainPath = System.getProperty("catalina.home") +
                    File.separator + "webapps" + File.separator + "tbhub" +
                    File.separator + "WEB-INF";
        }
        log4jMainPath += File.separator;

        logPattern = getStringValue(properties
                .getProperty(CONFIG_NAME_LOG_PATTERN), DEFAULT_LOG_PATTERN);

        logLevel = getStringValue(properties.getProperty(CONFIG_NAME_LOG_LEVEL),
                                  DEFAULT_LOG_LEVEL);

    }

    public static void initDynamicConfig(Connection conn) throws Exception {

        timeout = getIntValue(getParamFromDB(conn, hostId, CONFIG_NAME_TIMEOUT),
                              DEFAULT_TIMEOUT);
        totalLimit = getIntValue(getParamFromDB(conn, hostId,
                                                CONFIG_NAME_TOTAL_LIMIT),
                                 DEFAULT_TOTAL_LIMIT);
        fileInputDir = getStringValue(getParamFromDB(conn, hostId,
                                                     CONFIG_NAME_FILE_INPUT_DIR),
                                      DEFAULT_FILE_INPUT_DIR);
        fileOutputDir = getStringValue(getParamFromDB(conn, hostId,
                                                      CONFIG_NAME_FILE_OUTPUT_DIR),
                                       DEFAULT_FILE_OUTPUT_DIR);
        logDuration = getIntValue(getParamFromDB(conn, hostId,
                                                 CONFIG_NAME_LOG_DURATION),
                                  DEFAULT_LOG_DURATION);
        noDrop = getBooleanValue(getParamFromDB(conn, hostId,
                                                CONFIG_NAME_NO_DROP),
                                 DEFAULT_NO_DROP);
        dateFormat = getStringValue(getParamFromDB(conn, hostId,
                                                   CONFIG_NAME_DATE_FORMAT),
                                    DEFAULT_DATE_FORMAT);
        showTimeLog = getBooleanValue(getParamFromDB(conn, hostId,
                                                     CONFIG_NAME_SHOW_TIME_LOG),
                                      DEFAULT_SHOW_TIME_LOG);
        maxTableSize = getIntValue(getParamFromDB(conn, hostId,
                                                  CONFIG_NAME_TABLE_MAX_SIZE),
                                   DEFAULT_TABLE_MAX_SIZE);
        remoteSqlLog = getBooleanValue(getParamFromDB(conn, hostId,
                                                      CONFIG_NAME_REMOTE_SQL_LOG),
                                       DEFAULT_REMOTE_SQL_LOG);
        opInst = getBooleanValue(getParamFromDB(conn, hostId,
                                                CONFIG_NAME_OP_INST),
                                 DEFAULT_OP_INST);
        foreceByteOrderMark = getBooleanValue(getParamFromDB(conn, hostId,
                                                             CONFIG_NAME_FORCE_BYTE_ORDER_MARK),
                                              DEFAULT_FORCE_BYTE_ORDER_MARK);
        resultFetchRowCnt = getIntValue(getParamFromDB(conn, hostId,
                                                       CONFIG_NAME_FETCH_ROW_COUNT),
                                        DEFAULT_CONFIG_NAME_FETCH_ROW_COUNT);

        try {
            Statement stmt = conn.createStatement();
            stmt.execute("ALTER SYSTEM SET NLS_DATE_FORMAT='" +
                    getDateFormat() + "'");
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean isForeceByteOrderMark() {
        return foreceByteOrderMark;
    }

    public static boolean isNoDrop() {
        return noDrop;
    }

    public static boolean isOpInst() {
        return opInst;
    }

    public static boolean isRemoteSqlLog() {
        return remoteSqlLog;
    }

    public static boolean isShowTimeLog() {
        return showTimeLog;
    }

    /**
     * @return the useConnectionPool
     */
    public static boolean isUseConnectionPool() {
        return useConnectionPool;
    }

    /**
     * @param classRendezvous
     *            the classRendezvous to set
     */
    public static void setClassRendezvous(String classRendezvous) {
        TbHdConfig.classRendezvous = classRendezvous;
    }

    public static void setDateFormat(String dateFormat) {
        TbHdConfig.dateFormat = dateFormat;
    }

    public static boolean setDynamicParam(String name, String value) {
        if (name.equals(CONFIG_NAME_TIMEOUT)) {
            setTimeout(Integer.valueOf(value));
        }
        else if (name.equals(CONFIG_NAME_TOTAL_LIMIT)) {
            setTotalLimit(Integer.valueOf(value));
        }
        else if (name.equals(CONFIG_NAME_LOG_DURATION)) {
            setLogDuration(Integer.valueOf(value));
        }
        else if (name.equals(CONFIG_NAME_FILE_INPUT_DIR)) {
            setFileInputDir(value);
        }
        else if (name.equals(CONFIG_NAME_FILE_OUTPUT_DIR)) {
            setFileOutputDir(value);
        }
        else if (name.equals(CONFIG_NAME_NO_DROP)) {
            setNoDrop(getBooleanValue(value));
        }
        else if (name.equals(CONFIG_NAME_DATE_FORMAT)) {
            setDateFormat(value);
        }
        else if (name.equals(CONFIG_NAME_SHOW_TIME_LOG)) {
            setShowTimeLog(getBooleanValue(value));
        }
        else if (name.equals(CONFIG_NAME_TABLE_MAX_SIZE)) {
            setMaxTableSize(Integer.valueOf(value));
        }
        else if (name.equals(CONFIG_NAME_REMOTE_SQL_LOG)) {
            setRemoteSqlLog(getBooleanValue(value));
        }
        else if (name.equals(CONFIG_NAME_OP_INST)) {
            setOpInst(getBooleanValue(value));
        }
        else if (name.equals(CONFIG_NAME_FETCH_ROW_COUNT)) {
            setResultFetchRowCnt(Integer.valueOf(value));
        }
        else {
            return false;
        }
        return true;
    }

    public static void setFileInputDir(String fileInputDir) {
        TbHdConfig.fileInputDir = fileInputDir;
    }

    public static void setFileOutputDir(String fileOutputDir) {
        TbHdConfig.fileOutputDir = fileOutputDir;
    }

    public static void setForeceByteOrderMark(boolean foreceByteOrderMark) {
        TbHdConfig.foreceByteOrderMark = foreceByteOrderMark;
    }

    public static void setLogDuration(int logDuration) {
        TbHdConfig.logDuration = logDuration;
    }

    public static void setMaxTableSize(int maxTableSize) {
        TbHdConfig.maxTableSize = maxTableSize;
    }

    public static void setNoDrop(boolean noDrop) {
        TbHdConfig.noDrop = noDrop;
    }

    public static void setOpInst(boolean opInst) {
        TbHdConfig.opInst = opInst;
    }

    public static void setRemoteSqlLog(boolean remoteSqlLog) {
        TbHdConfig.remoteSqlLog = remoteSqlLog;
    }

    public static void setResultFetchRowCnt(int resultFetchRowCnt) {
        TbHdConfig.resultFetchRowCnt = resultFetchRowCnt;
    }

    public static void setShowTimeLog(boolean showTimeLog) {
        TbHdConfig.showTimeLog = showTimeLog;
    }

    public static void setTimeout(int timeout) {
        TbHdConfig.timeout = timeout;
    }

    public static void setTotalLimit(int totalLimit) {
        TbHdConfig.totalLimit = totalLimit;
//        TbHdSchedulerManager.setMaximumPoolSize(totalLimit);

    }
}
