package com.pows.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SchemaLoader {

    private String userTable = "";
    private String targetsystemTable = "";
    private String propstoreTable = "";
    private String recordLimit = "";

    public SchemaLoader() {
        this.init();
    }

    public void init() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "/config/application.properties";
            input = TestProperties.class.getResourceAsStream(filename);

            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            this.userTable = prop.getProperty("db.table.users");
            this.targetsystemTable = prop.getProperty("db.table.targetsystem");
            this.propstoreTable = prop.getProperty("db.table.propstore");
            this.recordLimit = prop.getProperty("db.record.limit");

        } catch (
                IOException ex) {
            System.out.println("Has error when read file: " + ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println("Has error when read file: " + ex.getMessage());
                }
            }
        }
    }

    public String getUserTable() {
        return userTable;
    }

    public void setUserTable(String userTable) {
        this.userTable = userTable;
    }

    public String getTargetsystemTable() {
        return targetsystemTable;
    }

    public void setTargetsystemTable(String targetsystemTable) {
        this.targetsystemTable = targetsystemTable;
    }

    public String getPropstoreTable() {
        return propstoreTable;
    }

    public void setPropstoreTable(String propstoreTable) {
        this.propstoreTable = propstoreTable;
    }

    public String getRecordLimit() {
        return recordLimit;
    }

    public void setRecordLimit(String recordLimit) {
        this.recordLimit = recordLimit;
    }
}
