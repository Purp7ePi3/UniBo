package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

abstract public class AbstractBankAccount implements BankAccount{

    private final AccountHolder holder;
    private double balance;
    private int transactions;


    public AbstractBankAccount(final AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }

    public void chargeManagementFees(final int id) {
        if (checkUser(id)) {
            this.balance -= SimpleBankAccount.MANAGEMENT_FEE;
            resetTransactions();
        }
    }

    protected void resetTransactions(){
        this.transactions = 0;
    }

    public void deposit(int id, double amount){
        this.transactionOp(id,amount);
    }

    public void depositFromATM(int id, double amount){
        this.transactionOp(id, amount-SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    public AccountHolder getAccountHolder(){
        return holder;
    }

    protected boolean checkUser(final int id) {
        return this.getAccountHolder().getUserID() == id;
    }

    public double getBalance(){
        return this.balance;
    }

    public int getTransactionsCount(){
        return this.transactions;
    }

    protected void setBalance(final double balance) {
        this.balance = balance;
    }

    public void withdraw(int id, double amount){
        this.transactionOp(id, -amount);
    }

    public void withdrawFromATM(int id, double amount){
        this.withdraw(id, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }
}