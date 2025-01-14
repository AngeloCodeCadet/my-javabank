package io.codeforall.bootcamp.javabank.handlers;

public enum MenuOptions {
    VIEW_BALANCE("View Balance"),
    MAKE_DEPOSIT("Make Deposit"),
    MAKE_WITHDRAWAL("Make Withdrawal"),
    OPEN_ACCOUNT("Open Account"),
    QUIT("Quit");

    private String title;

    MenuOptions(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
