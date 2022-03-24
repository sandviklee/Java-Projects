package uke12.firkanter.delegates;

public class UseShapes {
    public static void main(String[] args) {
        IShape triangle = new Triangle(10, 10);
        System.out.println("Shape triangle: "+triangle.getArea());
        triangle.increaseWidthByOne();
        System.out.println("Shape triangle: "+triangle.getArea());

        IShape rectangle = new Rectangle(10, 10);
        System.out.println("\nShape rectangle: "+rectangle.getArea());
        rectangle.increaseWidthByOne();
        System.out.println("Shape rectangle: "+rectangle.getArea());

        IShape square = new Square(10);
        System.out.println("\nShape square: "+square.getArea());
        square.increaseWidthByOne();
        System.out.println("Shape square: "+square.getArea());
    }
}
