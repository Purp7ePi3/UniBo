package it.unibo.shapes.api;

public class WorkWithShapes {
    public static void main(String[] args) {

        Circle AbraCadabra = new Circle(5);
        System.out.println(AbraCadabra.stringyfy());
        
        Square Finn = new Square(5);
        System.out.println(Finn.stringyfy());
        
        Rectangle Jake = new Rectangle(5, 2);
        System.out.println(Jake.stringyfy());

        Triangolo IceKing = new Triangolo(5, 6,7);
        System.out.println(IceKing.stringify());
    }
}
