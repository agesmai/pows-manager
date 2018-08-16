package com.pows.database;


public class ConnectionPool {

    // JDBC Driver Name & Database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String JDBC_DB_URL = "jdbc:oracle:thin:@odb.oracle.poc:1521:orcl";

    // JDBC Database Credentials
    static final String JDBC_USER = "IAMPOC";
    static final String JDBC_PASS = "Hpt123456";

//    private static GenericObjectPool gPool = null;
//
//    @SuppressWarnings("unused")
//    public DataSource setUpPool() throws Exception {
//        Class.forName(JDBC_DRIVER);
//
//        // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
//        gPool = new GenericObjectPool();
//        gPool.setMaxActive(5);
//
//        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
//        HttpUrlConnector.ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
//
//        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
//        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
//        return new PoolingDataSource(gPool);
//    }
//
//    public GenericObjectPool getConnectionPool() {
//        return gPool;
//    }
//
//    // This Method Is Used To Print The Connection Pool Status
//    private void printDbStatus() {
//        System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
//    }
//
//    public static void main(String[] args) {
//        ResultSet rsObj = null;
//        Connection connObj = null;
//        PreparedStatement pstmtObj = null;
//        ConnectionPool jdbcObj = new ConnectionPool();
//        try {
//            DataSource dataSource = jdbcObj.setUpPool();
//            jdbcObj.printDbStatus();
//
//            // Performing Database Operation!
//            System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
//            connObj = dataSource.getConnection();
//            jdbcObj.printDbStatus();
//
//            pstmtObj = connObj.prepareStatement("SELECT * FROM technical_editors");
//            rsObj = pstmtObj.executeQuery();
//            while (rsObj.next()) {
//                System.out.println("Username: " + rsObj.getString("tech_username"));
//            }
//            System.out.println("\n=====Releasing Connection Object To Pool=====\n");
//        } catch (Exception sqlException) {
//            sqlException.printStackTrace();
//        } finally {
//            try {
//                // Closing ResultSet Object
//                if (rsObj != null) {
//                    rsObj.close();
//                }
//                // Closing PreparedStatement Object
//                if (pstmtObj != null) {
//                    pstmtObj.close();
//                }
//                // Closing Connection Object
//                if (connObj != null) {
//                    connObj.close();
//                }
//            } catch (Exception sqlException) {
//                sqlException.printStackTrace();
//            }
//        }
//        jdbcObj.printDbStatus();
//    }
}