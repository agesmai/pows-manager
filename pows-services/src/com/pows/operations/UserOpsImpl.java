package com.pows.operations;

import com.pows.database.DbConnectionImpl;
import com.pows.database.DbQueryBuilder;
import com.pows.entity.User;
import com.pows.utils.SchemaLoader;
import com.pows.validations.UserValidation;

import javax.json.JsonObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

        if (newUser.getLogin() != null) {

            SchemaLoader schema = new SchemaLoader();
            Connection conn = new DbConnectionImpl().getConnection();
            ArrayList<String> columns = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();

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
        if (uid >= 10) {
            SchemaLoader schema = new SchemaLoader();
            Connection conn = new DbConnectionImpl().getConnection();
            ArrayList<String> updatePairs = new ArrayList<>();
            User currentUser = this.getUserByUid(uid);

            replaceUser.setUid(uid);

            if (replaceUser.getLogin() == null) {
                replaceUser.setLogin(currentUser.getLogin());
            }

            if (replaceUser.getPassword() == null) {
                replaceUser.setPassword(currentUser.getPassword());
            }

            if (replaceUser.getStatus() == null) {
                replaceUser.setStatus(currentUser.getStatus());
            }

            // updatePairs.add(new DbQueryBuilder().generateUpdatePair("USERID", uid));
            updatePairs.add(new DbQueryBuilder().generateUpdatePair("LOGIN", replaceUser.getLogin()));
            updatePairs.add(new DbQueryBuilder().generateUpdatePair("PASSWORD", replaceUser.getPassword()));
            updatePairs.add(new DbQueryBuilder().generateUpdatePair("STATUS", replaceUser.getStatus()));

            if (conn != null) {
                try {
                    Statement stmt = conn.createStatement();
                    String updateSet = new DbQueryBuilder().generateUpdateSet(updatePairs);
                    String sql = new DbQueryBuilder().UpdateQuery(schema.getUserTable(), updateSet, "USERID = " + String.valueOf(uid));
                    System.out.println("update sql: " + sql);
                    System.out.println("Trying to update user...");
                    try {
                        stmt.executeUpdate(sql);
                        System.out.println("User with id: " + replaceUser.getUid() + " is updated successfully !!!");
                        return replaceUser;
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        System.out.println("User with id: " + replaceUser.getUid() + " failed to update !!!");
                        return null;
                    }

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
                System.out.println("Failed to make connection! User is not updated");
                return null;
            }

        } else {
            System.out.println("UID below 10 is not supported !!!");
            return null;
        }

    }

    @Override
    public int getUserId(String login) {
        SchemaLoader schema = new SchemaLoader();
        Connection conn = new DbConnectionImpl().getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();

                String sql = new DbQueryBuilder().ReadQuery("USERID", schema.getUserTable(), "LOGIN LIKE '" + login + "'");

                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    try {
                        int userId = 9;
                        while (rs.next()) {
                            userId = rs.getInt("USERID");
                        }
                        return userId;
                    } catch (SQLException e) {
                        System.out.println("Result set Failed! Check output console");
                        e.printStackTrace();
                        return 9;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    return 9;
                }

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return 9;
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Connection Close Failed! Check output console");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Failed to make connection! User is not updated");
            return 9;
        }
    }

    @Override
    public User modifyUser(String login, JsonObject attributes) {
        return null;
    }

    @Override
    public Boolean revokeUser(String login) {
        if (login.equals("admin")) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Boolean enableUser(String login) {
        if (login.equals("admin")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean disableUser(String login) {
        if (login.equals("admin")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean deleteUser(int uid) {
        if (uid < 10) {
            System.out.println("Not support delete Uid below 10 !");
            return false;
        } else {
            SchemaLoader schema = new SchemaLoader();
            Connection conn = new DbConnectionImpl().getConnection();
            if (conn != null) {
                try {
                    Statement stmt = conn.createStatement();
                    if (UserValidation.isUserExist(uid)) {
                        // Do delete user here
                        String delete_sql = new DbQueryBuilder().DeleteQuery(schema.getUserTable(), "USERID LIKE '" + uid + "'");
                        System.out.println("create sql: " + delete_sql);
                        System.out.println("Trying to delete user...");
                        try {
                            stmt.executeUpdate(delete_sql);
                            System.out.println("User " + uid + " is deleted successfully !!!");
                            return true;
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                            return false;
                        }
                    } else {
                        // User existed !!!
                        System.out.println("User not existed !!!");
                        return true;
                    }
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return false;
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
                return false;
            }
        }

    }
}
