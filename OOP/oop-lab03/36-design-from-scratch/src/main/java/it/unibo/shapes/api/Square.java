package it.unibo.shapes.api;

public class Square implements Polygon, Shape{
    double edge;

    public Square(double edge){
        this.edge = edge;
    }

    @Override
    public double area() {
        return this.edge * this.edge;
    }

    @Override
    public double perimeter() {
        return this.edge * 4;
    }

    @Override
    public int edgecount() {
        return 4;
    }
    
    public String stringyfy(){
        return ("Edge: " + this.edge + "\nArea: " + area() + "\nPerimeter: " + perimeter() + "\nEdge Number: " +edgecount());
 
    }
}
