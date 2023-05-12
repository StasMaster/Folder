package mygraphiceditor;
public class Square extends Shape{
    private double side;
    public Square(String name, double side) {
        super(name);
        this.side = side;
    }
    @Override
    public void draw() {
        System.out.println(super.getName() +" properties: side is " + side);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}