package Tirgul.week8_questions;

public class TestInterface {
    public static void main(String[] args) {
        // Hold references to objects that implement the Drawable interface
        Drawable[] drawables = new Drawable[2];
        drawables[0] = new Circle(5);
        drawables[1] = new Rectangle(10, 5);

        for (Drawable drawable : drawables) {
            drawable.draw();
        }


        /*
        // Not working because Drawable is an interface and cannot be instantiated
        Drawable drawable = new Drawable();
        Better Short Explanation:
        An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.
        An interface is not a class. Writing an interface is similar to writing a class, but they are two different concepts. A class describes the attributes and behaviors of an object. An interface contains behaviors that a class implements.
        Unless the class that implements the interface is abstract, all the methods of the interface must be defined in the class.
         */











    }
}
