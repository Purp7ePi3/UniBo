package it.unibo.constructors;

class Student {

    String name;
    String surname;
    int id;
    int matriculationYear;

    void build(String Name, String surName, int id, int MatriculationYear){
        this.name = Name;
        this.surname = surName;
        this.id = id;
        this.matriculationYear = MatriculationYear;
    }
    
    void printStudentInfo() {
        System.out.println("Student id: " + this.id);
        System.out.println("Student name: " + this.name);
        System.out.println("Student surname: " + this.surname);
        System.out.println("Student matriculationYear: " + this.matriculationYear + "\n");
    }
}
