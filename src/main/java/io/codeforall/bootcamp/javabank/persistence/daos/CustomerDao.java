package io.codeforall.bootcamp.javabank.persistence.daos;

import io.codeforall.bootcamp.javabank.model.Customer;

import java.util.List;

public interface CustomerDao {



    // basic crud methods
    List<Customer> findAll();



    public Customer findById(Integer id);




    public Customer saveOrUpdate(Customer customer);



    public void delete(Integer id);

    // additional methods
    public Customer findByUsername(String username);


    public Customer findByEmail(String email);


}
