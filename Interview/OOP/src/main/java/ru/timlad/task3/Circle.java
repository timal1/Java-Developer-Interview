package ru.timlad.task3;

public class Circle extends Figure implements Draw{


    int radius;

    public Circle(Double areaFigure, String color, int radius) {
        super(areaFigure, color);
        this.radius = radius;
    }

    @Override
    public void move() {
        System.out.println("нарисовать круг площадью площадью: " + super.areaFigure + " " + color + " цвета");
    }

    @Override
    public void clear() {
        System.out.println("Стереть круг");
    }
}
