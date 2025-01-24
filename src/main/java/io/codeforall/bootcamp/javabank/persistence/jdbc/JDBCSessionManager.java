package io.codeforall.bootcamp.javabank.persistence.jdbc;

import io.codeforall.bootcamp.javabank.persistence.SessionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSessionManager implements SessionManager {

    private String dbUrl ="jdbc:mysql://localhost:3306/javabank";
    private String user="root";
    private String pass= "";
    private Connection connection;

    public void startSession() {

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(dbUrl, user, pass);
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
    }

    public void stopSession() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }

    public Connection getCurrentSession() {
        startSession();
        return connection;
    }
}

