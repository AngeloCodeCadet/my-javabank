package io.codeforall.bootcamp.javabank.handlers;

import io.codeforall.bootcamp.javabank.domain.Bank;
import io.codeforall.bootcamp.javabank.domain.Customer;
import io.codeforall.bootcamp.javabank.domain.account.Account;
import io.codeforall.bootcamp.javabank.domain.account.AccountType;
import io.codeforall.bootcamp.javabank.managers.AccountManager;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.sql.SQLOutput;

public class MenuPrompt {
    private Customer customer;
    private Bank bank;

    public MenuPrompt(Bank bank) {

        this.bank = bank;
    }

    public void start() {
        MenuOptions[] options = MenuOptions.values();
        String[] mainMenuOptions = new String[options.length];

        for (int i = 0; i < mainMenuOptions.length; i++) {
            mainMenuOptions[i] = options[i].getTitle();
        }

        System.out.println("===== Welcome to Java Bank =====\n");

        Prompt prompt = new Prompt(System.in, System.out);

        IntegerInputScanner question = new IntegerInputScanner();
        question.setMessage("Please insert your customer number: \n");
        int customerId = prompt.getUserInput(question);
        int answer1 = 0;

        customer = bank.getCustomer(customerId);


        while (true) {
            if (customer != null) {
                MenuInputScanner mainMenu = new MenuInputScanner(mainMenuOptions);
                mainMenu.setMessage("Please, choose an option:");
                answer1 = prompt.getUserInput(mainMenu);

                switch (answer1) {
                    case 1:
                        customer.getBalance();
                        break;
                    case 2:

                        if (customer.getAccounts().isEmpty()) {
                            System.out.println(" Please open an account first ");
                            break;
                        }
                        IntegerInputScanner accountNumer = new IntegerInputScanner();
                        question.setMessage("Please insert your account number: \n");
                        int answerAccount = prompt.getUserInput(question);
                        IntegerInputScanner amount = new IntegerInputScanner();
                        question.setMessage("Please insert the amount: \n");
                        int answerAmount = prompt.getUserInput(question);
                        AccountManager accountManager = bank.getAccountManager();
                        accountManager.deposit(answerAccount, answerAmount);
                        break;
                    case 4:
                        customer.openAccount(AccountType.CHECKING);
                        System.out.println("Your account is open!");
                        break;
                    case 5:
                        System.exit(0);

                        

                }


            }
        }
    }
}


