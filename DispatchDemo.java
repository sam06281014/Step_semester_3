abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    private double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    private double w;
    private double h;

    Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    double area() {
        return w * h;
    }
}

public class DispatchDemo {
    public static void main(String[] args) {
        Shape shape = new Circle(2);
        System.out.println(shape.area());
        shape = new Rectangle(3, 4);
        System.out.println(shape.area());
    }
}
