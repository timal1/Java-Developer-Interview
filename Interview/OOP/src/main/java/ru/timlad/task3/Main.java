package ru.timlad.task3;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(50.00, "Черного", 4);
        Square square = new Square(60.00, "Белого", 10);
        Triangle triangle = new Triangle(70.00, "Красного", 5, 7, 10);

        circle.move();
        square.move();
        triangle.move();

        circle.clear();
        square.clear();
        triangle.clear();

    }
}
