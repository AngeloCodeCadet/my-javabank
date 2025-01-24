package io.codeforall.bootcamp.javabank.persistence.daos.jdbc;

import io.codeforall.bootcamp.javabank.model.Customer;
import io.codeforall.bootcamp.javabank.model.account.Account;
import io.codeforall.bootcamp.javabank.persistence.ConnectionManager;
import io.codeforall.bootcamp.javabank.persistence.daos.CustomerDao;
import io.codeforall.bootcamp.javabank.persistence.jdbc.JDBCSessionManager;
import io.codeforall.bootcamp.javabank.services.AccountService;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;

public class JDBCCustomerDao implements CustomerDao {


    private AccountService accountService;
    private JDBCSessionManager jdbcSessionManager;

    public void setJdbcSessionManager(JDBCSessionManager jdbcSessionManager) {
        this.jdbcSessionManager = jdbcSessionManager;
    }

    @Override
    public List<Customer> findAll() {
        Map<Integer, Customer> customers = new HashMap<>();

        try {
            String query = "SELECT customer.id AS cid, first_name, last_name, phone, email, customer.version as cVersion, account.id AS aid " +
                    "FROM customer " +
                    "LEFT JOIN account " +
                    "ON customer.id = account.customer_id";

            PreparedStatement statement = jdbcSessionManager.getCurrentSession().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (!customers.containsKey(resultSet.getInt("cid"))) {
                    Customer customer = buildCustomer(resultSet);
                    customers.put(customer.getId(), customer);
                }

                Account account = accountService.get(resultSet.getInt("aid"));
                if (account != null) {
                    customers.get(resultSet.getInt("cid")).addAccount(account);
                }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>(customers.values());
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = null;

        try {
            String query = "SELECT customer.id AS cid, first_name, last_name, phone, email, customer.version AS cVersion, account.id AS aid " +
                    "FROM customer " +
                    "LEFT JOIN account " +
                    "ON customer.id = account.customer_id " +
                    "WHERE customer.id = ?";

            PreparedStatement statement = jdbcSessionManager.getCurrentSession().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                if (customer == null) {
                    customer = buildCustomer(resultSet);
                }

                int accountId = resultSet.getInt("aid");
                Account account = accountService.get(accountId);

                if (account == null) {
                    break;
                }

                customer.addAccount(account);
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;

    }

    @Override
    public Customer saveOrUpdate(Customer customer) {


        if (customer.getId() != null && get(customer.getId()) != null) {
            return null;
        }

        Connection connection = jdbcSessionManager.getCurrentSession();

        try {
            connection.setAutoCommit(false);

            String query = "INSERT INTO customer(first_name, last_name, email, phone) " +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement statement = jdbcSessionManager.getCurrentSession().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
            }

            statement.close();

            connection.commit();

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
        public void delete (Integer id){

        }

        @Override
        public Customer findByUsername (String username){



            return null;
        }

        @Override
        public Customer findByEmail (String email){
            return null;
        }






        private Customer buildCustomer (ResultSet resultSet) throws SQLException {

            Customer customer = new Customer();

            customer.setId(resultSet.getInt("cid"));
            customer.setFirstName(resultSet.getString("first_name"));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setPhone(resultSet.getString("phone"));
            customer.setEmail(resultSet.getString("email"));
            customer.setVersion(resultSet.getInt("cVersion"));

            return customer;

        }
    }
