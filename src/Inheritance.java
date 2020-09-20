public class Inheritance {

    public static void main(String[] args) {

        A a = new B();

        a.methodAbstract();
    }
}

abstract class A extends Object {

    protected int x = 5;

    abstract void methodAbstract();

    public A() {
        System.out.println("class A constructor");
        x = 123;
    }
}

class B extends A {

    protected int x = 10;

    //private boolean x;

    public void B() {
        System.out.println("B method");
    }

    public B() {
        super();
        System.out.println("class B constructor");
        x = 23444;
    }

    @Override
    void methodAbstract() {
        System.out.println(super.x);
        System.out.println(x);
    }
}