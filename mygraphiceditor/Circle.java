package mygraphiceditor;
public class Circle extends Shape{
    private double radius;
    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    private double circumFerence(){
        return 2 * Math.PI * radius;
    }
    private double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public void draw() {
        System.out.println(super.getName() +" properties: radius is " + radius + "; длина окружности " + circumFerence()
                + "; площадь круга " + calculateArea());
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}