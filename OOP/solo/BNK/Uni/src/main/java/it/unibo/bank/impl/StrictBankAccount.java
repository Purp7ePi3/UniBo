package it.unibo.bank.impl;

import it.unibo.bank.api.BankAccount;

public class StrictBankAccount implements BankAccount{

    private final int id;
    private double balance;
    private int txCount;
    private final double FEES = 0.5;
    private final double MANAGE = 1;

    public StrictBankAccount(final int id, double amount){
        this.id = id;
        this.balance = amount;
        this.txCount = 0;
    }
    
    
    @Override
    public void withdraw(int id, double amount) {
        if(this.id != id){
            System.err.println("id sbagliato: " + id + " Expected:" + this.id);
            return;
        }
        if(amount > this.balance){
            System.err.println("Non hai abbastanza soldi");
            return;
        }
        this.balance -= amount;
    }

    @Override
    public void deposit(int id, double amount) {
        if(this.id == id){
            this.balance += amount;
        }
    }

    @Override
    public void depositFromATM(int id, double amount) {
        if(this.id == id){
            this.balance += amount - MANAGE;
        }
    }

    @Override
    public void withdrawFromATM(int id, double amount) {
        if(this.id == id){
            if(this.balance < amount){
                return;
            }
            this.balance -= amount + MANAGE;
        }
    }

    @Override
    public void chargeManagementFees(int id) {
        if(this.id == id){
            this.balance -= this.txCount * FEES;
            this.txCount = 0;
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public int getTransactionsCount() {
        return this.txCount;    
    }
    
    public String toString(){
        return "balance:" + this.getBalance() + "$ tx:" + this.txCount + "}";
    }
}
