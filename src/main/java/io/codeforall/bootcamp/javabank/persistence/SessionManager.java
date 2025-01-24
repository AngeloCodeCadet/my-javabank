package io.codeforall.bootcamp.javabank.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface SessionManager {

    public void startSession();

    public void stopSession();

    public Connection getCurrentSession();

}
