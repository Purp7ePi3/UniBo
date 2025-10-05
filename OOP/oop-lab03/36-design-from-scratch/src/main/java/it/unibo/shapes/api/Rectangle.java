package it.unibo.shapes.api;

public class Rectangle implements Polygon,Shape{
    double longEdge;
    double shotEdge;

    public Rectangle(double longEdge, double shotEdge){
        this.longEdge = longEdge;
        this.shotEdge = shotEdge;
    }

    @Override
    public double area() {
        return this.longEdge * this.shotEdge;
    }

    @Override
    public double perimeter() {
        return this.longEdge * 2 + this.shotEdge * 2; 
    }

    @Override
    public int edgecount() {
        return 4;
    }
    
    public String stringyfy(){
        return ("LongEdge: " + this.longEdge + "\tShortEdge:" + this.shotEdge + "\nArea: " + area() + "\nPerimeter: " + perimeter() + "\nEdge Number: " + edgecount());

    }
}

