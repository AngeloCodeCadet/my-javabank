package io.codeforall.bootcamp.javabank.controller;

import io.codeforall.bootcamp.javabank.model.account.Account;
import io.codeforall.bootcamp.javabank.model.account.AccountType;
import io.codeforall.bootcamp.javabank.view.NewAccountView;

/**
 * The {@link NewAccountView} controller
 */
public class NewAccountController extends AbstractController {

    private Bank bank;
    private Integer newAccountId;

    /**
     * Sets the bank
     *
     * @param bank the bank to set
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * Gets the new account id
     *
     * @return the new account id
     */
    public Integer getNewAccountId() {
        return newAccountId;
    }

    /**
     * Creates a new {@link Account}
     *
     * @see Controller#init()
     * @see AccountManager#openAccount(AccountType)
     */
    @Override
    public void init() {

        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {

        Account newAccount = bank.getAccountManager().openAccount(AccountType.CHECKING);
        bank.getLoginCustomer().addAccount(newAccount);

        return newAccount.getId();
    }
}
