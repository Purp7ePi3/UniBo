package it.unibo.bank;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;
import it.unibo.bank.impl.SimpleBankAccount;
import it.unibo.bank.impl.StrictBankAccount;

public class Test{
    public static void main(String[] args){
       
      
    
        AccountHolder ubello = new AccountHolder("Ugo", "Bello", 0);
        AccountHolder abrutto = new AccountHolder("Andrea", "Brutto", 1);

        BankAccount uBelloBank = new SimpleBankAccount(0, 0);
        BankAccount abruttoBank = new StrictBankAccount(1, 0);



        uBelloBank.deposit(ubello.getUserID(), 100);
        abruttoBank.deposit(abrutto.getUserID(), 100);

        abruttoBank.withdraw(ubello.getUserID(), 0);
        abruttoBank.withdraw(abrutto.getUserID(), 500);

        System.out.println(ubello.toString() + uBelloBank.toString());
        System.out.println(abrutto.toString() + abruttoBank.toString());

       // System.out.println(abrutto.txCount);

    }

}