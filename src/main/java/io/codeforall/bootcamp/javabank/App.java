package io.codeforall.bootcamp.javabank;

import io.codeforall.bootcamp.javabank.controller.Controller;
import io.codeforall.bootcamp.javabank.factories.AccountFactory;
import io.codeforall.bootcamp.javabank.persistence.ConnectionManager;
import io.codeforall.bootcamp.javabank.persistence.TransactionManager;
import io.codeforall.bootcamp.javabank.persistence.daos.jdbc.JDBCCustomerDao;
import io.codeforall.bootcamp.javabank.persistence.jdbc.JDBCSessionManager;
import io.codeforall.bootcamp.javabank.persistence.jdbc.JDBCTransationManager;
import io.codeforall.bootcamp.javabank.services.AuthServiceImpl;
import io.codeforall.bootcamp.javabank.services.jdbc.JdbcAccountService;
import io.codeforall.bootcamp.javabank.services.jdbc.JdbcCustomerService;

public class App {

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {

        ConnectionManager connectionManager = new ConnectionManager();
        TransactionManager transactionManager = new JDBCTransationManager();
        JDBCSessionManager jdbcSessionManager = new JDBCSessionManager();


        AccountFactory accountFactory = new AccountFactory();
        JdbcAccountService accountService = new JdbcAccountService(connectionManager, accountFactory);
        JdbcCustomerService customerService = new JdbcCustomerService();
        JDBCCustomerDao customerDao = new JDBCCustomerDao();

        customerDao.setJdbcSessionManager(jdbcSessionManager);




        customerService.setCustomerDao(customerDao);
        customerService.setAccountService(accountService);
        customerService.setTransactionManager(transactionManager);
        customerDao.setJdbcSessionManager(jdbcSessionManager);




        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(accountService);
        bootstrap.setCustomerService(customerService);
        bootstrap.setAccountFactory(accountFactory);
        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

        connectionManager.close();
    }
}
