abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    double sideA;
    double sideB;
    double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}

class Rectangle extends Shape {

    double sideX;
    double sideY;

    public Rectangle(double sideX, double sideY) {
        this.sideX = sideX;
        this.sideY = sideY;
    }

    @Override
    double getPerimeter() {
        return sideX * 2 + sideY * 2;
    }

    @Override
    double getArea() {
        return sideX * sideY;
    }
}

class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}