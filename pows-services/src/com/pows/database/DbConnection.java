package com.pows.database;

import java.sql.*;

public interface DbConnection {
    Connection getConnection();
}
