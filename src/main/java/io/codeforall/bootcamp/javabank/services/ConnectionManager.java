package io.codeforall.bootcamp.javabank.services;

import java.sql.*;

public class ConnectionManager {

    private Connection connection = null;

    public Connection getConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/javabank";
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(dbUrl, "root", "");
            }
        } catch (SQLException ex) {
            System.out.println("Failure to connect to database : " + ex.getMessage());
        }
        return connection;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failure to close database connections: " + ex.getMessage());
        }
    }




}
