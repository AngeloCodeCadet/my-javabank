package io.codeforall.bootcamp.javabank.services;

import io.codeforall.bootcamp.javabank.model.Customer;
import io.codeforall.bootcamp.javabank.model.account.Account;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class JdbcCustomerService implements CustomerService {

    private Map<Integer, Customer> customerMap = new HashMap<>();
    private ConnectionManager connectionManager;
    private Customer customer;


    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Customer get(Integer id) {


        Connection dbconnection = connectionManager.getConnection();

        // create a new statement

        try {
            Statement statement = dbconnection.createStatement();

            // create a query
            String query = "SELECT * FROM customer as c LEFT JOIN account as a on c.id = a.customer_id where c.id =" + id;

            // execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // get the results

            if (resultSet.next()) {

                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int phone = resultSet.getInt("phone");
                int version = resultSet.getInt("version");
                Date creation_time = resultSet.getDate("creation_time");
                Date update_time = resultSet.getDate("update_time");

                //Array accountsNumber = resultSet.getArray("account_type");



//                customer.setEmail(email);
//                customer.setFirstName(firstName);
//                customer.setLastName(lastName);
//                customer.setPhone(phone);
//                customer.setVersion(version);
//                customer.setCreationTime(creation_time);
//                customer.setUpdateTime(update_time);

               customer = new Customer(email, firstName,lastName,phone,version,creation_time,update_time);

                //customer= resultSet.get(1);
            }

            return customer;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> list() {
        return new ArrayList<>(customerMap.values());
    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        Set<Integer> accountIds = new HashSet<>();
        List<Account> accountList = customerMap.get(id).getAccounts();

        for (Account account : accountList) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    /**
     * @see CustomerService#getBalance(int)
     */
    @Override
    public double getBalance(int id) {

        List<Account> accounts = customerMap.get(id).getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    /**
     * @see CustomerService#add(Customer)
     */
    @Override
    public void add(Customer customer) {

        if (customer.getId() == null) {
            customer.setId(getNextId());
        }

        customerMap.put(customer.getId(), customer);
    }
    private Integer getNextId() {
        return customerMap.isEmpty() ? 1 : Collections.max(customerMap.keySet()) + 1;
    }
}
