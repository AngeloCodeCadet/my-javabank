package io.codeforall.bootcamp.javabank;

import io.codeforall.bootcamp.javabank.application.BankApplication;
import io.codeforall.bootcamp.javabank.controllers.WelcomeController;
import io.codeforall.bootcamp.javabank.domain.Bank;
import io.codeforall.bootcamp.javabank.domain.Customer;
import io.codeforall.bootcamp.javabank.managers.AccountManager;
import io.codeforall.bootcamp.javabank.views.WelcomeView;

public class App {

    public static void main(String[] args) {


        Bank bank = new Bank();
        WelcomeController welcomeController = new WelcomeController(?);
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        BankApplication bankApplication = new BankApplication(bank);
        welcomeController.start();
    }
}
