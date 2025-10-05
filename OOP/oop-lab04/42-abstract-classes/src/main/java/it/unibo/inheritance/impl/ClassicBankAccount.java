package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount{

    public ClassicBankAccount(AccountHolder accountHolder, double balance) {
        super(accountHolder, balance);
    }
    
    public void chargeManagementFees(final int id){
        super.chargeManagementFees(id);
    }

    public void deposit(int id, double amount){
        super.deposit(id, amount);
    }

    public void depositFromATM(int id, double amount){
        super.depositFromATM(id, amount);
    }

    public AccountHolder getAccountHolder(){
        return super.getAccountHolder();
    }

    public double getBalance(){
        return super.getBalance();
    }

    public void withdraw(int id, double amount){
        super.withdraw(id, amount);
    }    

    public void withdrawFromATM(int id, double amount){
        super.withdrawFromATM(id, amount);
    }

    public int getTransactionsCount(){
        return super.getTransactionsCount();
    }

}
