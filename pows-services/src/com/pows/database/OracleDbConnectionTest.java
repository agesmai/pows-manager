package com.pows.database;

import java.sql.*;

public class OracleDbConnectionTest {

    public static void test(String[] argv) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (
                ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@odb.oracle.poc:1521:orcl", "IAMPOC", "Hpt123456");

        } catch (
                SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

//        try {
//            String schema = connection.getSchema();
//            System.out.println("Connection information:" + schema);
//            Statement stmt = connection.createStatement();
//            String sql = new DbQueryBuilder().ReadQuery("*", "ISF_TARGET_SYSTEM", "");
//            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println("SystemCode  |   SystemName");
//            while (rs.next()) {
//                String s_code = rs.getString("SYSTEM_CODE");
//                String s_name = rs.getString("SYSTEM_NAME");
//                System.out.println("   " + s_code + "      |   " + s_name);
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//        }

    }

    public static void test2(String[] argv) {
        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        try {
            String schema = conn.getSchema();
            System.out.println("Connection information:" + schema);
            Statement stmt = conn.createStatement();
            String sql = new DbQueryBuilder().ReadQuery("*", "ISF_TARGET_SYSTEM", "");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SystemCode  |   SystemName");
            while (rs.next()) {
                String s_code = rs.getString("SYSTEM_CODE");
                String s_name = rs.getString("SYSTEM_NAME");
                System.out.println("   " + s_code + "      |   " + s_name);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
}
