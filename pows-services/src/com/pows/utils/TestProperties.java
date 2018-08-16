/*
 * Identity Service for integration Oracle Identity Governance 12c.
 * License by HPT Corp.
 * Author: pvanh@hpt.vn
 */
package com.pows.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    public static void test(String[] args) {

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

            //load a properties file from class path, inside not static method
            //prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
            String env_prefix = prop.getProperty("env");
            //get the property value and print it out
            System.out.println(prop.getProperty("db.table.propstore"));
            System.out.println(prop.getProperty("env"));
            System.out.println(prop.getProperty("skc.secret"));
            System.out.println("Env Information:");
            System.out.println(prop.getProperty(env_prefix + ".db.host"));
            System.out.println(prop.getProperty(env_prefix + ".db.port"));
            System.out.println(prop.getProperty(env_prefix + ".db.user"));
            System.out.println(prop.getProperty(env_prefix + ".db.password"));
            System.out.println(prop.getProperty(env_prefix + ".db.serviceName"));


        } catch (IOException ex) {
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
}
