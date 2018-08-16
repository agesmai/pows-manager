package com.pows.operations;

import com.pows.database.DbConnectionImpl;
import com.pows.database.DbQueryBuilder;
import com.pows.objects.User;
import com.pows.utils.SchemaLoader;
import com.pows.validations.UserValidation;

import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserOpsImpl implements UserOps {

    private static User getUserObject(ResultSet rs) {
        User usr = new User("dumb_user", "", "inactive");
        usr.setUid(9);
        try {
            while (rs.next()) {
                int userId = rs.getInt("USERID");
                String s_login = rs.getString("LOGIN");
                String s_pass = rs.getString("PASSWORD");
                String s_status = rs.getString("STATUS");
                usr.setUid(userId);
                usr.setLogin(s_login);
                usr.setPassword(s_pass);
                usr.setStatus(s_status);
            }
            return usr;
        } catch (SQLException e) {
            System.out.println("Result set Failed! Check output console");
            e.printStackTrace();
            return null;
        }

    }

    private static ArrayList<User> getListUserObject(ResultSet rs) {
        ArrayList<User> list_usr = new ArrayList<>();
        try {
            while (rs.next()) {
                User usr = new User();
                int userId = rs.getInt("USERID");
                String s_login = rs.getString("LOGIN");
                String s_pass = rs.getString("PASSWORD");
                String s_status = rs.getString("STATUS");
                usr.setUid(userId);
                usr.setLogin(s_login);
                usr.setPassword(s_pass);
                usr.setStatus(s_status);
                //Add to user list
                list_usr.add(usr);
            }
            return list_usr;
        } catch (SQLException e) {
            System.out.println("Result set Failed! Check output console");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public User getUserByUid(int uid) {
        SchemaLoader schema = new SchemaLoader();
//        schema.init();
        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                String sql = new DbQueryBuilder().ReadQuery("*", schema.getUserTable(), "USERID LIKE " + "'" + uid + "'");
                ResultSet rs = stmt.executeQuery(sql);

                return getUserObject(rs);

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
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

        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        SchemaLoader schema = new SchemaLoader();
//        schema.init();
        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                String sql = new DbQueryBuilder().ReadQuery("*", schema.getUserTable(), "LOGIN LIKE " + "'" + login + "'");
                System.out.println("sql string: " + sql);
                ResultSet rs = stmt.executeQuery(sql);
                return getUserObject(rs);


            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
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

        return null;
    }


    @Override
    public List<User> getAllUsers() {
        SchemaLoader schema = new SchemaLoader();
//        schema.init();
        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                String sql = new DbQueryBuilder().ReadQuery("*", schema.getUserTable(), "ROWNUM <= " + schema.getRecordLimit() + " ORDER BY USERID ASC");
                System.out.println("sql string: " + sql);
                ResultSet rs = stmt.executeQuery(sql);
                return getListUserObject(rs);


            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
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
        return null;
    }

    @Override
    public List<User> getUserListWithLimit(int fromUid, int limitRecord) {

        SchemaLoader schema = new SchemaLoader();
//        schema.init();
        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                String sql_from = new DbQueryBuilder().ReadQuery("*", schema.getUserTable(), "") + " ORDER BY USERID ASC";
                String sql = new DbQueryBuilder().ReadQuery("*", "(" + sql_from + ") t", "t.USERID >= " + Integer.toString(fromUid) + " AND ROWNUM <= " + Integer.toString(limitRecord) + " ORDER BY USERID ASC");
                System.out.println("sql string: " + sql);
                ResultSet rs = stmt.executeQuery(sql);
                return getListUserObject(rs);


            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
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
        return null;
    }

    @Override
    public List<User> getUserListByUid(int fromUid, int toUid) {
        SchemaLoader schema = new SchemaLoader();
//        schema.init();

        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            System.out.println("You made it, take control your database now!");
            try {
                Statement stmt = conn.createStatement();
                int start;
                int end;
                if (fromUid <= toUid) {
                    start = fromUid;
                    end = toUid;
                } else {
                    start = toUid;
                    end = fromUid;
                }

                String sql_from = new DbQueryBuilder().ReadQuery("*", schema.getUserTable(), "") + " ORDER BY USERID ASC";
                String sql = new DbQueryBuilder().ReadQuery("*", "(" + sql_from + ") t", "t.USERID >= " + Integer.toString(start) + " AND t.USERID <= " + Integer.toString(end) + " ORDER BY USERID ASC");
                System.out.println("sql string: " + sql);
                ResultSet rs = stmt.executeQuery(sql);
                return getListUserObject(rs);


            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
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
        return null;
    }

    @Override
    public User createUser(User newUser) {
        SchemaLoader schema = new SchemaLoader();
        Connection conn = new DbConnectionImpl().getConnection();
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (newUser.getLogin() != null) {

            columns.add("LOGIN");
            values.add(newUser.getLogin());

            if (newUser.getPassword() != null) {
                columns.add("PASSWORD");
                values.add(newUser.getPassword());
            } else {
                newUser.setPassword("Hpt123456");
                columns.add("PASSWORD");
                values.add(newUser.getPassword());
            }

            if (newUser.getStatus() != null) {
                columns.add("STATUS");
                values.add(newUser.getStatus());
            } else {
                newUser.setStatus("enable");
                columns.add("STATUS");
                values.add(newUser.getStatus());
            }

            if (conn != null) {
                try {
                    Statement stmt = conn.createStatement();
                    if (!UserValidation.isUserExist(newUser.getLogin())) {
                        // Do create new user here
                        DbQueryBuilder qb = new DbQueryBuilder();
                        String columnSet = qb.generateColumnSet(columns);
                        String valueSet = qb.generateValueSet(values);
                        String create_sql = new DbQueryBuilder().InsertQuery(schema.getUserTable(), columnSet, valueSet);
                        System.out.println("create sql: " + create_sql);
                        System.out.println("Trying to create new user...");
                        try {
                            stmt.executeUpdate(create_sql);
                            System.out.println("User " + newUser.getLogin() + " is created successfully !!!");
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        // User existed !!!
                        System.out.println("User existed !!!");
                        return null;
                    }

                    String sql = new DbQueryBuilder().ReadQuery("*", "(" + schema.getUserTable() + ") t", "t.LOGIN LIKE " + "'" + newUser.getLogin() + "'");
                    System.out.println("sql string: " + sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    return getUserObject(rs);

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return null;
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
        }
        return null;
    }

    @Override
    public User updateUser(int uid, User replaceUser) {
        if ((0 <= uid) && (uid < 10)) {

        }
        return null;
    }

    @Override
    public int getUserId(String login) {
        return 0;
    }

    @Override
    public User modifyUser(String login, JsonObject attributes) {
        return null;
    }

    @Override
    public Boolean revokeUser(String login) {
        return null;
    }

    @Override
    public Boolean deleteUser(int uid) {
        return null;
    }
}
