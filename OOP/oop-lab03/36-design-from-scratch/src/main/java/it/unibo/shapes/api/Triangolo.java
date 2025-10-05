package it.unibo.shapes.api;


public class Triangolo implements Polygon, Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    // Costruttore
    public Triangolo(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double res = 0;

        res = (this.sideA + this.sideB + this.sideC) / 2;
        return Math.sqrt(res * (res - this.sideA) * (res - this.sideB) * (res - this.sideC));
    
    }

    @Override
    public double perimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @Override
    public int edgecount() {
        return 3;
    }

 
    public String stringify(){
        return ("sideA: " + this.sideA + "\tsideB:" + this.sideB + "\tsideC" + this.sideC +  "\nArea: " + area() + "\nPerimeter: " + perimeter() + "\nEdge Number: " + edgecount());

    }
}