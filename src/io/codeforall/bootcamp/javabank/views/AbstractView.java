package io.codeforall.bootcamp.javabank.views;

import io.codeforall.bootcamp.javabank.application.Messages;
import io.codeforall.bootcamp.javabank.application.UserOptions;
import io.codeforall.bootcamp.javabank.application.operations.BalanceOperation;
import io.codeforall.bootcamp.javabank.application.operations.NewAccountOperation;
import io.codeforall.bootcamp.javabank.application.operations.Operation;
import io.codeforall.bootcamp.javabank.application.operations.transaction.DepositOperation;
import io.codeforall.bootcamp.javabank.application.operations.transaction.WithdrawOperation;
import io.codeforall.bootcamp.javabank.domain.Bank;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractView {
    protected Prompt prompt;
    protected MenuInputScanner mainMenu;
    protected Map<Integer, Operation> operationsMap;
    protected Map<Integer, Operation> map;
    protected Bank bank;
    protected int accessingCustomerId;

    /**
     * Creates a new instance of a {@code BankApplication}, initializes it with the given {@link Bank}
     *
     * @param bank the bank instance
     */
    public AbstractView(Bank bank) {
        this.bank = bank;
        this.prompt = new Prompt(System.in, System.out);
    }

    /**
     * Gets the prompt used for the UI
     *
     * @return the prompt
     */
    public Prompt getPrompt() {
        return prompt;
    }

    /**
     * Gets the bank used by this application
     *
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Gets the id of the customer using the Bank Application
     *
     * @return the customer id
     */
    public int getAccessingCustomerId() {
        return accessingCustomerId;
    }

    /**
     * Starts the bank application
     */

    protected Map<Integer, Operation> buildOperationsMap() {
        map = new HashMap<>();
        return map;
    }

}
