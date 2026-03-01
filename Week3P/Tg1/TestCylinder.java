public class TestCylinder { 
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder 1:");
        System.out.println("radius=" + c1.getRadius() + ", height=" + c1.getHeight());
        System.out.println("surface area=" + c1.getArea() + ", volume=" + c1.getVolume());
        System.out.println(c1.toString() + "\n");

        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder 2:");
        System.out.println("radius=" + c2.getRadius() + ", height=" + c2.getHeight());
        System.out.println("surface area=" + c2.getArea() + ", volume=" + c2.getVolume());
        System.out.println(c2.toString() + "\n");

        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder 3:");
        System.out.println("radius=" + c3.getRadius() + ", height=" + c3.getHeight());
        System.out.println("surface area=" + c3.getArea() + ", volume=" + c3.getVolume());
        System.out.println(c3.toString() + "\n");
        
        // Testing the new constructor
        Cylinder c4 = new Cylinder(3.0, 5.0, "blue");
        System.out.println("Cylinder 4:");
        System.out.println(c4.toString() + "\n");
        
        // coba coba hiraukan saja
        Circle c5 = new Circle(2);
        System.out.println("Cylinder 5:");
        System.out.println("surface area=" + c5.getArea());
    }
}