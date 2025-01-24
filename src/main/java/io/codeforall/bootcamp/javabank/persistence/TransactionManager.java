package io.codeforall.bootcamp.javabank.persistence;

import io.codeforall.bootcamp.javabank.persistence.jdbc.JDBCSessionManager;

import java.sql.SQLException;

public interface TransactionManager {


    public void beginRead();


    public void beginWrite();


    public void commit();


    public void rollback();

}


