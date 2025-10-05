class train{
    int nTotSeat;
    int nFirstClassSeat;
    int nSecondClassSeats;
    int nFirstClassReservedSeats;
    int nSecondClassReservedSeats;

    void build(int nt, int nfc, int nsc, int rfc, int rsc){
        this.nTotSeat = nt;
        this.nFirstClassSeat = nfc;
        this.nSecondClassSeats = nsc;
        this.nFirstClassReservedSeats = rfc;
        this.nSecondClassReservedSeats = rsc;
    }

    void reserveFirstClassSeats(int n){
        if(this.nFirstClassReservedSeats + n <= this.nFirstClassSeat){
            this.nFirstClassReservedSeats = this.nFirstClassReservedSeats + n;
        }
    }

    void reserveSecondClassSeats(int n){
        if(this.nSecondClassReservedSeats + n <= this.nSecondClassSeats){
            this.nSecondClassReservedSeats = this.nSecondClassReservedSeats + n;
        }
    }

    double getTotOccupancyRatio(){
        return (((double)this.nFirstClassReservedSeats + (double)this.nSecondClassReservedSeats) / ((double)this.nFirstClassSeat + (double)this.nSecondClassSeats)) * 100;
    }

    double getFirstClassOccupancyRatio(){
        return ((double)this.nFirstClassReservedSeats / (double)this.nFirstClassSeat) * 100;
        
    }

    double getSecondClassOccupancyRatio(){
        return ((double)this.nSecondClassReservedSeats / (double)this.nSecondClassSeats) * 100;
    }

    void deleteAllReservations(){
        this.nFirstClassReservedSeats = 0;
        this.nSecondClassReservedSeats = 0;
    }
    
    void printAll(){
        System.out.println("Total Seats: " + nTotSeat);
        System.out.println("First Class Seats: " + nFirstClassSeat);
        System.out.println("First Class Reserved Seats: " + nFirstClassReservedSeats);
        System.out.println("Second Class Seats: " + nSecondClassSeats);
        System.out.println("Second Class Reserved Seats: " + nSecondClassReservedSeats);
        System.out.println("Total occupation:" + this.getTotOccupancyRatio() + "%");
        System.out.println("Total 1st occupation:" + this.getFirstClassOccupancyRatio() + "%");
        System.out.println("Total 2nd occupation:" + this.getSecondClassOccupancyRatio() + "%\n");

    }
}

class UseTrain {
    public static void main(String[] args) {
        /*
         * Premesse per un corretto testing della classe. Per ragioni di
         * coerenza e semplicità:
         * - I vari metodi siano sempre invocati passando dei parametri di input
         * validi e consistenti (p.e. non invocare i metodi per effettuare delle
         * prenotazioni specificando un numero di posti superiore alla capienza
         * del treno, ai posti disponibili per la classe (prima/seconda)
         * considerata, al numero di posti correntemente liberi
         *
         *
         * Testing: 1) Creare un oggetto della classe Train specificando valori
         * a piacere per i parametri
         *
         * 2) Effettuare delle prenotazioni in prima e seconda classe
         * specificando un numero di posti da prenotare consistente
         *
         * 3) A seguito di ciascuna prenotazione stampare la ratio di
         * occupazione totale e per ciascuna classe.
         *
         * 4) Cancellare tutte le prenotazioni
         *
         * 5) Prenotare nuovamente dei posti e stampare le nuove percentuali di
         * occupazione
         */
        train wagon = new train();

        wagon.build(100, 20, 80, 9, 70);
        wagon.printAll();
        wagon.reserveFirstClassSeats(1);
        wagon.reserveSecondClassSeats(10);
        wagon.printAll();
        wagon.deleteAllReservations();
        wagon.printAll();


    }
}
