class TestStudent {
    public static void main(String[] args) {
        Student alexBalducci = new Student();
        alexBalducci.build("Alex", "Balducci", 1015,2019);
        alexBalducci.printStudentInfo();

        Student AngelBianchi = new Student();
        AngelBianchi.build("Angel", "Bianchi", 1016,2018);
        AngelBianchi.printStudentInfo();

        Student AndreaBracci = new Student();
        AndreaBracci.build("Andrea", "Bracci", 1017,2017);
        AndreaBracci.printStudentInfo();
    }
}
