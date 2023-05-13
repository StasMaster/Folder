package mygraphiceditor;
public class ShapePrinter {
    public void printShapeName(Shape shape) {
        System.out.println("Shape name: " + shape.getName());
    }
    public static void main(String[] args) {
        Shape circle = new Circle("Круг", 6.5);
        Shape square = new Square("Квадрат", 10.0);
        Shape triangle = new Triangle("Треугольник", 8.0, 6.0);
        Shape rectangle = new Rectangle("Прямоугольник", 6.0, 8.0);
        Shape trapezoid = new Trapezoid("Трапеция", 3.0, 5.0, 4.0);
        Shape rhombus = new Rhombus("Ромб", 3.5, 6.8);

        ShapePrinter shapePrinter = new ShapePrinter();

        shapePrinter.printShapeName(circle);
        circle.draw();

        shapePrinter.printShapeName(square);
        square.draw();

        shapePrinter.printShapeName(triangle);
        triangle.draw();

        shapePrinter.printShapeName(rectangle);
        rectangle.draw();

        shapePrinter.printShapeName(trapezoid);
        trapezoid.draw();

        shapePrinter.printShapeName(rhombus);
        rhombus.draw();
    }
}