package it.unibo.composition;

import java.util.Arrays;

public class Exam {
    int id;
    int MaxStudents;
    int registeredStudents;
    String courseName;
    Professor professor;
    ExamRoom room;
    Student[] students;

    public Exam(
        int id,
        int maxStudents,
        String courseName,
        Professor professor,
        ExamRoom room
    ) {
        this.id = id;
        this.MaxStudents = maxStudents;
        this.registeredStudents = 0; // Inizialmente 0 studenti iscritti
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[maxStudents]; // Inizializzo l'array di studenti
    }

    public void registerStudent(Student student) {
        if (registeredStudents < MaxStudents) {
            students[registeredStudents] = student;
            registeredStudents++;
        }
    }

    public String toString() {
        return "Exam { " +
                "ID: " + id +
                ", Course Name: '" + courseName + '\'' +
                ", Professor: " + professor.getUsername() + // Presumendo che Professor abbia un metodo getName()
                ", Room: " + room.getDescription() + // Presumendo che ExamRoom abbia un metodo getRoomName()
                ", Registered Students: " + registeredStudents +
                ", Max Students: " + this.MaxStudents +
                ", Students: " + Arrays.toString(students) +  // Usa Arrays.toString() per convertire l'array in stringa
                " }";
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ExamRoom getRoom() {
        return room;
    }

    public Student[] getStudents() {
        return students;
    }
}
