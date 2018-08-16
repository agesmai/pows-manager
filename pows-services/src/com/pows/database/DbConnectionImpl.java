package com.pows.database;

import com.pows.utils.TestProperties;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbConnectionImpl implements DbConnection {
    public static String DB_HOST = "";
    public static String DB_PORT = "";
    public static String DB_SERVICE = "";
    public static String DB_USER = "";
    public static String DB_PASS = "";
    public static String DB_URL = "";
    public static String DB_VENDOR = "";

    @Override
    public Connection getConnection() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "/config/application.properties";
            input = TestProperties.class.getResourceAsStream(filename);

            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }

            prop.load(input);

            String env_prefix = prop.getProperty("env");
//            get the property value and print it out
//            System.out.println("DB connection Information:");
//            System.out.println(prop.getProperty(env_prefix + ".db.host"));
//            System.out.println(prop.getProperty(env_prefix + ".db.port"));
//            System.out.println(prop.getProperty(env_prefix + ".db.user"));
//            System.out.println(prop.getProperty(env_prefix + ".db.password"));
//            System.out.println(prop.getProperty(env_prefix + ".db.serviceId"));
//            System.out.println(prop.getProperty("database.vendor"));

            this.DB_HOST = prop.getProperty(env_prefix + ".db.host");
            this.DB_PORT = prop.getProperty(env_prefix + ".db.port");
            this.DB_SERVICE = prop.getProperty(env_prefix + ".db.serviceId");
            this.DB_USER = prop.getProperty(env_prefix + ".db.user");
            this.DB_PASS = prop.getProperty(env_prefix + ".db.password");
            this.DB_URL = DB_HOST + ":" + DB_PORT + ":" + DB_SERVICE;
            System.out.println(DB_URL);
            this.DB_VENDOR = prop.getProperty("database.vendor");


        } catch (IOException ex) {
            System.out.println("Has error when read config file: " + ex.getMessage());
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println("Has error when close config file: " + ex.getMessage());
                }
            }
        }

        if (DB_VENDOR.equals("oracle")) {
            try {
                System.out.println("Try to load Oracle JDBC Driver!");
                Class.forName("oracle.jdbc.driver.OracleDriver");

            } catch (
                    ClassNotFoundException e) {

                System.out.println("Not found Oracle JDBC Driver!");
                e.printStackTrace();
                return null;

            }
//            System.out.println("Oracle JDBC Driver Registered!");

            Connection conn = null;
            try {

                conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@" + DB_URL, DB_USER, DB_PASS);
                if (conn != null) {
                    return conn;
                }

            } catch (
                    SQLException e) {

                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;

            }
        }
        return null;
    }
}
