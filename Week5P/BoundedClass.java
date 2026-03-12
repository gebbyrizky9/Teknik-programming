// Bounded Type: T hanya boleh A atau subclass-nya (B, C)
class Bound<T extends A> {

    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    // Bisa panggil displayClass() karena T pasti turunan A
    public void doRunTest() {
        this.objRef.displayClass();
    }
}

// Superclass A (batas atas untuk T)
class A {

    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

// Subclass B — valid sebagai T karena extends A
class B extends A {

    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

// Subclass C — valid sebagai T karena extends A
class C extends A {

    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

public class BoundedClass {

    public static void main(String a[]) {

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        // similarly passing super class A
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
    }
}
