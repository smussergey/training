package ua.training;

public class WithoutReturnStatementApp {
    public static void main(String[] args) {
        double d = sqrWithoutReturnButWithWhile(10.0);  // sqr - in loop
        System.out.println(d); // d - nothing is assigned
    }

    //compiles
    public static double sqrWithoutReturnButWithWhile(double arg) {
        while (true) ;
    }

    // doesn't compile
//    public static double sqrWithoutReturn(double arg) {
//        // nothing
//    }

    //compiles
    public static double sqrWithThrow(double arg) {
        throw new RuntimeException();
    }
}
