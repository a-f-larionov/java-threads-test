interface funcInterface {
    Number funcA(int b);
}

class MyClass {
    public static void main(String[] args) {

        final int x = 55;

        funcInterface fi = (b) -> {
            return b * 2 + x;
        };

        //x++;
        System.out.println(fi.funcA(123));
    }
}