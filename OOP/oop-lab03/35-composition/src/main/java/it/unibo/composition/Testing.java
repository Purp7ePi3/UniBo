package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        
        // 1)Creare 3 studenti a piacere
        Student pippo = new Student(1, "Pippo", "Baudo", "123", 2017);
        Student ugo = new Student(2, "Ugo", "Boff", "456", 2018);
        Student Boffetti = new Student(3, "Filippo", "Boffetti", "Gamba", 2020);
        // 2)Creare 2 docenti a piacere
        Professor ghini = new Professor(1, "Vic", "IlGhini", "CanePazzo", new String[] {"SO", "OOP"});
        Professor ilsado = new Professor(2, "Giro", "IlCapraro", "Beee", new String[] {"Prog" , "Virtu"});
        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom room1 = new ExamRoom(100, "Sistemi", false, false);
        ExamRoom room2 = new ExamRoom(80, "OOP", false, false);
        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam SO = new Exam(15, 10, "SistemiOperativiExam", ghini, room1);
        Exam OOP = new Exam(16, 2,"Obj exam",ilsado,room2);
        // 5) Iscrivere tutti e 3 gli studenti agli esami
        SO.registerStudent(pippo);
        SO.registerStudent(ugo);
        SO.registerStudent(Boffetti);

        OOP.registerStudent(pippo);
        OOP.registerStudent(ugo);
        OOP.registerStudent(Boffetti);
        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(SO.toString());
        System.out.println();
        System.out.println(OOP.toString());
        
    }
}
