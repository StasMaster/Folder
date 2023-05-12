package mygraphiceditor;
public class Triangle extends Shape{
    private double base;
    private double height;
    public Triangle(String name, double base, double height){
        super(name);
        this.base = base;
        this.height = height;

    }
    @Override
    public void draw() {
        System.out.println(super.getName() +" properties: " + "base is " + base + ", height is "+ height);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}
