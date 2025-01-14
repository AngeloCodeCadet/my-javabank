package io.codeforall.bootcamp.javabank;

import io.codeforall.bootcamp.javabank.domain.Bank;
import io.codeforall.bootcamp.javabank.domain.Customer;
import io.codeforall.bootcamp.javabank.handlers.MenuPrompt;
import io.codeforall.bootcamp.javabank.managers.AccountManager;

public class Main {
    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);

        Customer c1 = new Customer(1);
        Customer c2 = new Customer(2);
        Customer c3 = new Customer(3);

        bank.addCustomer(c1.getId(), c1);
        bank.addCustomer(c2.getId(), c2);
        bank.addCustomer(c3.getId(), c3);

        MenuPrompt menuPrompt = new MenuPrompt(bank);
        menuPrompt.start();

    }

}
