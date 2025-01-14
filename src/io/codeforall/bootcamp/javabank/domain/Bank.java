package io.codeforall.bootcamp.javabank.domain;

import io.codeforall.bootcamp.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The bank entity
 */
public class Bank {

    private AccountManager accountManager;
    private Customer customer;
    private int customerId;
    private Map<Integer, Customer> customers = new HashMap<>();

    /**
     * Creates a new instance of Bank and initializes it with the given account manager
     *
     * @param accountManager the account manager
     */
    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Customer getCustomer(int id){
        return customers.get(id);
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    /**
     * Adds a new customer to the bank
     *
     * @param customer the new bank customer
     * @see Customer#setAccountManager(AccountManager)
     */
    public void addCustomer(int id, Customer customer) {
        customers.put(id, customer);
        customer.setAccountManager(accountManager);
    }

    /**
     * Gets the total balance of the bank
     *
     * @return the bank total balance
     */
    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public boolean hasId(int id) {
        return customers.containsKey(id);
    }
}
