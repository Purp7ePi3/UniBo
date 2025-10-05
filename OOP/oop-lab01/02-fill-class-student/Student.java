class Student {

    // È buona pratica mettere i campi in testa alla classe
    String name;
    String surname;
    int id;
    int matriculationYear;

    void build(String name, String surname, int matricola, int immatricolazione) {
        this.name = name;
        this.surname = surname;
        this.id = matricola;
        this.matriculationYear = immatricolazione;
    }

    void printStudentInfo() {
        /*
         * Completare il corpo del metodo
         */
        System.out.println("Nome: "+ this.name + "\nCognome: " + this.surname + "\nId: "+this.id + "\nImm: "+this.matriculationYear + "\n\n");
    }
}
