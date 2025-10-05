package it.unibo.inheritance.impl;

public class NewStrictBankAccount extends SimpleBankAccount{
    public NewStrictBankAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void deposit(final int id, final double amount) {
        super.deposit(id, amount);
    }
    

    @Override
    public void withdraw(final int id, final double amount){
        if(super.getBalance() > amount){
            super.withdraw(id, amount);
        }
    }
}
