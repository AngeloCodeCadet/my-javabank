package io.codeforall.bootcamp.javabank.service;

import io.codeforall.bootcamp.javabank.model.Customer;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AuthServiceImp implements AuthService{

    private CustomerServiceImp customerServiceImp;
    private Customer loggedInCustomer;

    @Override
    public boolean authenticate(Integer id) {

        loggedInCustomer = customerServiceImp.get(id);
        return loggedInCustomer != null;

        /*
        Optional <Customer> customer = customerServiceImp.list().stream().filter(i -> i.getId()==id).findAny();
        if (customer.isEmpty()){
            return false;
        }else {
            this.loginCustomer = id;
            return true;
        }*/
    }

    @Override
    public Customer getAccessingCustomer() {
    return loggedInCustomer;
    }

    public  void set(CustomerServiceImp customerServiceImp){
        this.customerServiceImp = customerServiceImp;
    }
}
