package it.unibo.constructors;

class Smartphone {

    static final boolean DEF_HAS_GPS = true;
    static final boolean DEF_HAS_3G = true;
    static final boolean DEF_HAS_NFC = true;
    static final int DEF_SD_SIZE = 8192;
    static final int DEF_RAM_SIZE = 1024;
    static final int DEF_N_CPU = 2;

    int nCPU;
    int ram;
    int sdSize;
    String brand;
    String model;
    boolean hasGPS;
    boolean has3G;
    boolean hasNFC;

    void build(int ncpu, int ram, int space, String brand, String model, boolean gps, boolean ggg, boolean nfc){
        this.nCPU = ncpu;
        this.ram = ram;
        this.sdSize = space;
        this.brand = brand;
        this.model = model;
        this.has3G = ggg;
        this.hasNFC = nfc;
        this.hasGPS = gps;
    }
    void printStringRep() {
        System.out.println("Smartphone info:");
        System.out.println("n CPU(s): " + this.nCPU);
        System.out.println("RAM amount: " + this.ram);
        System.out.println("SD size: " + this.sdSize);
        System.out.println("brand: " + this.brand);
        System.out.println("model: " + this.model);
        System.out.println("hasGPS: " + this.hasGPS);
        System.out.println("has3G: " + this.has3G);
        System.out.println("hasNFC: " + this.hasNFC + "\n");
    }

    public static void main(final String[] args) {
        // 1) Creare lo smarthpone HTC One sdSize:1024
        Smartphone HTCOne = new Smartphone();
        HTCOne.build(DEF_N_CPU, DEF_RAM_SIZE, 64, "HTC", "ONE", false, true, DEF_HAS_NFC);
        HTCOne.printStringRep();
        // 2) Creare lo smarthpone Samsung Galaxy Note 3 ram:2048 cpu:4
        // sdSize:8192 gps:true nfc:true 3g:true
        Smartphone Note3 = new Smartphone();
        Note3.build(4, 2048, 8192, "Samsung", "Note 3", DEF_HAS_GPS, DEF_HAS_3G, DEF_HAS_NFC);
        Note3.printStringRep();
        // 3) Creare lo smarthpone Apple iPhone 5S nfc:false
        Smartphone Iphone5s = new Smartphone();
        Iphone5s.build(DEF_N_CPU, DEF_RAM_SIZE, DEF_N_CPU, "Apple", "Iphone 5s", DEF_HAS_GPS, DEF_HAS_3G, false);
        Iphone5s.printStringRep();
        // 4) Creare lo smarthpone Google Nexus 4 gps:true 3g:true
        Smartphone Nexus4 = new Smartphone();
        Nexus4.build(DEF_N_CPU, DEF_RAM_SIZE, DEF_N_CPU, "Google", "Nexus 4", DEF_HAS_GPS, DEF_HAS_3G, DEF_HAS_NFC);
        Nexus4.printStringRep();
        // 5) Utilizzare il metodo printStringRep per stampare in standard
        // output le informazioni di ciascun telefono

    }
}
