package it.unibo.constructors;

class UseConstructors {

    public static void main(final String[] args) {
        // NB: Per verificare la correttezza dei costruttori implementati
        // stampare a video le informazioni relative agli studenti (metodo
        // printStudentInfo) e ai treni (a tal fine implementare un metodo
        // printTrainInfo nella classe Train).

        // 1) Creare lo studente Mario Rossi, matricola 1014, anno
        // immatricolazione 2013
        Student MarioRossi = new Student();
        MarioRossi.build("Mario", "Rossi", 1014, 2013);
        MarioRossi.printStudentInfo();
        // 2) Creare lo studente Luca Bianchi, matricola 1018, anno
        // immatricolazione 2010
        Student LucaBianchi = new Student();
        LucaBianchi.build("Luca", "Bianchi", 1018, 2010);
        LucaBianchi.printStudentInfo();
        // 3) Creare lo studente Peppino Vitiello, matricola 1019, anno
        // immatricolazione 2012
        Student PeppinoVitiello = new Student();
        PeppinoVitiello.build("Peppino", "Vitiello", 1019, 2012);
        PeppinoVitiello.printStudentInfo();
        // 4) Creare lo studente Luca Verdi, matricola 1020, anno
        // immatricolazione 2013
        Student LucaVerdi = new Student();
        LucaVerdi.build("Luca", "Verdi", 1020, 2013);
        LucaVerdi.printStudentInfo();
        // 5) Creare un treno con 300 posti di cui 100 in prima classe 200 in
        // seconda classe
        Train wagon1 = new Train();
        wagon1.build(300, 100, 200);
        wagon1.printTrainInfo();
        // 6) Creare un treno con 1200 posti di cui 50 in prima classe 1050 in
        // seconda classe
        Train wagon2 = new Train();
        wagon2.build(1200, 50, 1050);
        wagon2.printTrainInfo();
        // 7) Creare un treno con 500 posti, tutti di seconda classe
        Train wagon3 = new Train();
        wagon3.build(500, 0, 500);
        wagon3.printTrainInfo();
        // 8) Creare un treno con numero di posti di default

        Train fixeTrain = new Train();
        fixeTrain.fixed();
        fixeTrain.printTrainInfo();
        // 9) Verificare che il numero di posti
        // di default sia consistente (ossia che ci sia un numero positivo di
        // posti totali, e che la somma dei posti in prima e seconda classe dia
        // il totale dei posti sul treno).
    }
}
