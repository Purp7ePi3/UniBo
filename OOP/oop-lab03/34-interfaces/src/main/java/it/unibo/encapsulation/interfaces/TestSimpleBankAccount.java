package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        new AccountHolder("Andrea", "Rossi",1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        new AccountHolder("Alex", "Bianchi",2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        BankAccount accountRossi = new SimpleBankAccount(1, 0);
        BankAccount accountBianchi = new SimpleBankAccount(2, 0);
        // 4) Effettuare una serie di depositi e prelievi
        accountRossi.deposit(1, 50);
        accountBianchi.deposit(2, 100);
        
        accountRossi.withdraw(1, 100);
        accountBianchi.withdraw(2,50);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println("RossiBalance: " + accountRossi.getBalance() + "\nBianchiBalance: " + accountBianchi.getBalance());
        System.out.println("RossiTX: " + accountRossi.getTransactionsCount() + "\nBianchiTX: " + accountBianchi.getTransactionsCount());

        // 6) Provare a prelevare fornendo un id utente sbagliato
        accountRossi.withdraw(2, 100);
        accountBianchi.withdraw(1,50);

        // 7) Controllare nuovamente l'ammontare
        System.out.println("RossiBalance: " + accountRossi.getBalance() + "\nBianchiBalance: " + accountBianchi.getBalance());

    }
}
