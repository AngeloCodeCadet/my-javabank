package io.codeforall.bootcamp.javabank.views;

import io.codeforall.bootcamp.javabank.application.BankApplication;
import io.codeforall.bootcamp.javabank.application.Messages;
import io.codeforall.bootcamp.javabank.application.UserOptions;
import io.codeforall.bootcamp.javabank.application.operations.BalanceOperation;
import io.codeforall.bootcamp.javabank.application.operations.Operation;
import io.codeforall.bootcamp.javabank.domain.Bank;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.util.HashMap;
import java.util.Map;

public class WelcomeView extends AbstractView {

    MenuView menuView;


    public WelcomeView(Bank bank) {
        super(bank);
    }

    private MenuInputScanner buildWelcomeMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;
    }

    protected int scanCustomerId() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);

        return prompt.getUserInput(scanner);
    }

    public void start() {

        mainMenu = buildWelcomeMenu();

        accessingCustomerId = scanCustomerId();
        operationsMap = buildOperationsMap();
        menuView.menuLoop();
    }
}
