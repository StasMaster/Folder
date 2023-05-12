package mygraphiceditor;
public class Rhombus extends Shape{
    private double diagonal1;
    private double diagonal2;
    public Rhombus(String name, double diagonal1, double diagonal2) {
        super(name);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }
    @Override
    public void draw() {
        System.out.println(super.getName() +" properties: diagonal_1 is " + diagonal1 + ", diagonal_2 is " + diagonal2);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}