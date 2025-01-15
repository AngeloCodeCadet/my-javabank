package io.codeforall.bootcamp.javabank.views;

import io.codeforall.bootcamp.javabank.application.BankApplication;
import io.codeforall.bootcamp.javabank.application.UserOptions;
import io.codeforall.bootcamp.javabank.application.operations.BalanceOperation;
import io.codeforall.bootcamp.javabank.application.operations.NewAccountOperation;
import io.codeforall.bootcamp.javabank.application.operations.Operation;
import io.codeforall.bootcamp.javabank.application.operations.transaction.DepositOperation;
import io.codeforall.bootcamp.javabank.application.operations.transaction.WithdrawOperation;
import io.codeforall.bootcamp.javabank.domain.Bank;

import javax.sound.midi.SoundbankResource;
import java.util.HashMap;
import java.util.Map;

public class BalanceView extends AbstractView{

    public BalanceView(Bank bank){
        super(bank);
    }
     public Map<Integer, Operation> buildOperationsMap() {

       // Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(new BankApplication(getBank())));
        return map;
    }
}
