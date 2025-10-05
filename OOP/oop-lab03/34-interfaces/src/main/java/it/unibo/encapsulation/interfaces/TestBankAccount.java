package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        new AccountHolder("Andrea", "Rossi", 1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        new AccountHolder("Alex", "Bianchi", 2);

        // 3) Dichiarare due variabili di tipo BankAccount
        BankAccount accountRossi = new SimpleBankAccount(1, 0.0);
        BankAccount accountBianchi = new StrictBankAccount(2, 0.0);

        // 5) Depositare €10000 in entrambi i conti
        accountRossi.deposit(1, 10000);
        accountBianchi.deposit(2, 10000);

        // 6) Prelevare €15000 da entrambi i conti
        accountRossi.withdraw(1, 15000);
        accountBianchi.withdraw(2, 15000);

        // 7) Stampare in stdout l'ammontare corrente
        System.out.println("Ammontare corrente di Rossi: " + accountRossi.getBalance());
        System.out.println("Ammontare corrente di Bianchi: " + accountBianchi.getBalance());

        // 9) Depositare nuovamente €10000 in entrambi i conti
        accountRossi.deposit(1, 10000);
        accountBianchi.deposit(2, 10000);

        // 10) Invocare il metodo computeManagementFees su entrambi i conti
        accountRossi.chargeManagementFees(1);
        accountBianchi.chargeManagementFees(2);

        // 11) Stampare a video l'ammontare corrente
        System.out.println("Ammontare corrente di Rossi dopo le spese: " + accountRossi.getBalance());
        System.out.println("Ammontare corrente di Bianchi dopo le spese: " + accountBianchi.getBalance());
        
        // 12) Qual è il risultato e perché?
        // Il risultato dipende dalle implementazioni dei metodi di gestione delle spese.
    }
}
