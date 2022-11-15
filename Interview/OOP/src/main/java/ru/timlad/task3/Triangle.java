package ru.timlad.task3;

public class Triangle extends Figure implements Draw{

    int sideA;
    int sideB;
    int sideC;

    public Triangle(Double areaFigure, String color, int sideA, int sideB, int sideC) {
        super(areaFigure, color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

    }

    @Override
    public void move() {
        System.out.println("Нарисовать треугольник площадью: " + super.areaFigure + " " + color + " цвета");
    }

    @Override
    public void clear() {
        System.out.println("Стереть треугольник");
    }
}
