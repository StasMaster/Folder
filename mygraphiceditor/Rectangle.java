package mygraphiceditor;

public class Rectangle extends Shape{
    private double sideA;
    private double sideB;
    public Rectangle(String name, double sideA, double sideB){
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
    }
    @Override
    public void draw() {
        System.out.println(super.getName() +", длина окружности ");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}
