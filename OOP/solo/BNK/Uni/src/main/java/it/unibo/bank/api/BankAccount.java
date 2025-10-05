package it.unibo.bank.api;


public interface BankAccount {
    void withdraw(int id, double amount);

    void deposit(int id, double amount);

    void depositFromATM(int id, double amount);

    void withdrawFromATM(int id, double amount);

    void chargeManagementFees(int id);

    double getBalance();

    int getTransactionsCount();

}