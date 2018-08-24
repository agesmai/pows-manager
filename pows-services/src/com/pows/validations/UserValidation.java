package com.pows.validations;

import com.pows.database.DbConnectionImpl;
import com.pows.database.DbQueryBuilder;
import com.pows.utils.SchemaLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserValidation {
    public static boolean isUserExist(String login) {

        SchemaLoader schema = new SchemaLoader();
        Connection conn = new DbConnectionImpl().getConnection();

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                String sql = new DbQueryBuilder().ReadQuery("LOGIN", "(" + schema.getUserTable() + ") t", "t.LOGIN LIKE " + "'" + login + "'");
                System.out.println("sql string: " + sql);
                ResultSet rs = stmt.executeQuery(sql);
                try {
                    while (rs.next()) {
                        String s_login = rs.getString("LOGIN");
                        if (s_login.equals(login)) {
                            return true;
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Result set Failed! Check output console");
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Connection Close Failed! Check output console");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to make connection!");
        }
        return false;
    }

    public static boolean isUserExist(Integer uid) {

        SchemaLoader schema = new SchemaLoader();
        Connection conn = new DbConnectionImpl().getConnection();

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                String sql = new DbQueryBuilder().ReadQuery("USERID", "(" + schema.getUserTable() + ") t", "t.USERID LIKE " + "'" + uid + "'");
                System.out.println("sql string: " + sql);
                ResultSet rs = stmt.executeQuery(sql);
                try {
                    while (rs.next()) {
                        String s_uid = rs.getString("USERID");
                        if (s_uid.equals(Integer.toString(uid))) {
                            return true;
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Result set Failed! Check output console");
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Connection Close Failed! Check output console");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to make connection!");
        }
        return false;
    }

    public static boolean isPasswordValid(String password) {
        return true;
    }

    public static boolean isStatusValid(String status) {
        return true;
    }
}
