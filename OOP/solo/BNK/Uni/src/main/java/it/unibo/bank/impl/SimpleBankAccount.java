package it.unibo.bank.impl;

import it.unibo.bank.api.BankAccount;

public class SimpleBankAccount implements BankAccount{

    private final int id;
    private double money;
    private int txCount;
    private final double FEES = 0.5;
    private final double MANGEMENTE = 1;

    public SimpleBankAccount(final int id, final double balance){
        this.id = id;
        this.money = balance;
        this.txCount = 0;
    }

    @Override
    public void deposit(int id, double amount) {
        if(this.id != id){
            return;
        }
        this.money += amount;
        this.txCount++;
    }

    @Override
    public void withdraw(int id, double amount) {
       if(this.id != id){
            return;
       }
       this.money -= amount;
       this.txCount++;
    }

    @Override
    public void depositFromATM(int id, double amount) {
       if(this.id != id ){
        return;
       }
       this.money += amount - FEES;
    }

    @Override
    public void withdrawFromATM(int id, double amount) {
        if(this.id != id ){
            return;
           }
        this.money += amount - FEES;
    }

    @Override
    public void chargeManagementFees(int id) {
        if(this.id != id ){
            return;
           }
        this.money -= MANGEMENTE;
    }

    @Override
    public double getBalance() {
        return this.money;
    }

    @Override
    public int getTransactionsCount() {
       return this.txCount;
    }

    public String toString(){
        return "balance:" + this.getBalance() + "$ tx:" + this.txCount + "}";
    }

    
}