package io.codeforall.bootcamp.javabank.model;

import io.codeforall.bootcamp.javabank.model.account.Account;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
public class Customer extends AbstractModel {

    private String email;
    private String firstName;
    private String lastName;
    private int phone;
    private int version;
    private Date creationTime;
    private Date updateTime;

    public Customer(String email, String firstName, String lastName, int phone, int version, Date creationTime, Date updateTime) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.version = version;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    private List<Account> accounts = new ArrayList<>();


    /**
     * Gets the name of the customer
     *
     * @return the customer name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the name of the customer
     *
     * @param firstName the name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the customer accounts
     *
     * @return the accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Adds a new account to the customer
     *
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Removes an account from the customer
     *
     * @param account the account to remove
     */
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", version=" + version +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", accounts=" + accounts +
                '}';
    }
}


