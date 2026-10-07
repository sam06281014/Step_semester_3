// Problem 1: Garden Plot Area Report
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShapeName();
}

class CirclePlot extends Plot {
    double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShapeName() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShapeName() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShapeName() {
        return "TRIANGLE";
    }
}

public class P1_GardenPlotAreaReport {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String shape = tokens[0];
            String owner = tokens[1];

            Plot plot;
            if (shape.equalsIgnoreCase("CIRCLE")) {
                plot = new CirclePlot(owner, Double.parseDouble(tokens[2]));
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                plot = new RectanglePlot(owner, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            } else {
                plot = new TrianglePlot(owner, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            }
            plots.add(plot);
        }

        double totalArea = 0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.getShapeName(), area);
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
