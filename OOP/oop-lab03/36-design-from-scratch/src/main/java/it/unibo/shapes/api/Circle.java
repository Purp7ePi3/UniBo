package it.unibo.shapes.api;
import java.lang.Math;

public class Circle implements Shape{
    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double perimeter() {
        return 2*this.radius*Math.PI;
    }

    public String stringyfy(){
        return ("Radius: " +this.radius + "\nArea: " + area() + "\nPerimeter: " + perimeter());
    }

}
