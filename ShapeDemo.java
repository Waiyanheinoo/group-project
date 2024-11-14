// 1. Define the base interface
interface Shape {
    double calculateArea();

    double calculatePerimeter();

    String getShapeName();
}

// 2. Simple circle implementation
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}

// 3. Rectangle implementation
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }
}

// 4. Triangle implementation
class Triangle implements Shape {
    private double a, b, c; // sides of triangle

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }
}

// 5. Shape Calculator class to demonstrate polymorphism
class ShapeCalculator {
    public void printShapeInfo(Shape shape) {
        System.out.println("\nShape: " + shape.getShapeName());
        System.out.printf("Area: %.2f\n", shape.calculateArea());
        System.out.printf("Perimeter: %.2f\n", shape.calculatePerimeter());
    }
}

// 6. Demo class with main method
public class ShapeDemo {
    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();

        // Create different shapes
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4, 5);

        // Calculate and display information for each shape
        calculator.printShapeInfo(circle);
        calculator.printShapeInfo(rectangle);
        calculator.printShapeInfo(triangle);
    }
}