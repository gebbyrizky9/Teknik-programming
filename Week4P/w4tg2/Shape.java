package Week4P.w4tg2;

//*****************************************
// Shape.java
//
// Represents a generic shape.
//*****************************************
public abstract class Shape {
    protected String shapeName;

    // ----------------------------------
    // Constructor: Sets up the shape.
    // ----------------------------------
    public Shape(String name) {
        shapeName = name;
    }

    // -----------------------------------------
    // Returns the area of the shape.
    // -----------------------------------------
    public abstract double area();

    // -----------------------------------
    // Returns the shape name as a String.
    // -----------------------------------
    public String toString() {
        return shapeName;
    }
}
