package io.codeforall.bootcamp.javabank.service;

import io.codeforall.bootcamp.javabank.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CustomerServiceImp implements CustomerService{

    private HashMap<Integer, Customer> customers;

    public void CustomerServiceImp(){
        this.customers = new HashMap<>();
    }



    @Override
    public Customer get(Integer id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> list() {
        return customers.values().stream().toList();
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return customers.get(id).getAccountIds();
    }

    @Override
    public double getBalance(int customerId) {
        double balance = 0;

       return customers.get(customerId).getBalance();


    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getId(), customer);

    }
}
