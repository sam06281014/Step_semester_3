class Vehicle {
    void move() {
        System.out.println("Moving");
    }
}

class Car extends Vehicle {
}

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Truck extends Vehicle {
    private Engine engine = new Engine();

    void run() {
        engine.start();
        move();
    }
}

public class IsADemo {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.move();
        new Truck().run();
    }
}
