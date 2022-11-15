package ru.timlad.task3;

public class Square extends Figure implements Draw{

    int side;

    public Square(Double areaFigure, String color, int side) {
        super(areaFigure, color);
        this.side = side;
    }

    @Override
    public void move() {
        System.out.println("нарисовать квадрат площадью: " + super.areaFigure + " " + color + " цвета");
    }

    @Override
    public void clear() {
        System.out.println("Стереть квадрат");
    }
}
