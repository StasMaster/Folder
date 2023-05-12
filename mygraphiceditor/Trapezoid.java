package mygraphiceditor;

public class Trapezoid extends Shape{
    private double sideA;
    private double sideB;
    private double height;
    public Trapezoid(String name, double sideA, double sideB, double height) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
    }
    @Override
    public void draw() {
        System.out.println(super.getName() +" properties: " + " shortside is " + sideA + ", longside is " + sideB + ", height is " + height);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}
