package com.l7.dbdemo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton Pattern
 */

public class ConnectionManager {

    private static ConnectionManager connectionInstance;
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost/test";
    private static final String userName = "root";
    private static final String password = "";

    private ConnectionManager() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public static synchronized ConnectionManager getInstance() {
        if (connectionInstance == null) {
            connectionInstance = new ConnectionManager();
        }
        return connectionInstance;
    }
}
