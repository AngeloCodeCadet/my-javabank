package io.codeforall.bootcamp.javabank.views;

import io.codeforall.bootcamp.javabank.application.BankApplication;
import io.codeforall.bootcamp.javabank.application.UserOptions;
import io.codeforall.bootcamp.javabank.application.operations.BalanceOperation;
import io.codeforall.bootcamp.javabank.application.operations.Operation;
import io.codeforall.bootcamp.javabank.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class QuitView extends AbstractView{
    public QuitView(Bank bank){
        super(bank);
    }
    public Map<Integer, Operation> buildOperationsMap() {

        //Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.QUIT.getOption(), new BalanceOperation(new BankApplication(getBank())));
        return map;
    }
}
