package io.codeforall.bootcamp.javabank.views;

import io.codeforall.bootcamp.javabank.application.UserOptions;
import io.codeforall.bootcamp.javabank.domain.Bank;

public class MenuView extends AbstractView{

    public MenuView(Bank bank){
        super(bank);

    }

    public void menuLoop() {

        int userChoice = prompt.getUserInput(mainMenu);

        if (userChoice == UserOptions.QUIT.getOption()) {
            return;
        }

        operationsMap.get(userChoice).execute();
        menuLoop();
    }
}
