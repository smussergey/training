package ua.training.part2;

public class CatchOrThrow {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.err.println("From catch block");
        }
    }
}

//    public static void main(String[] args) {
//        try {
//            throw new Exception();
//        } catch (Error e) {
//            // ...
//        }
//    }
//}
//
//>> COMPILATION ERROR: unhandled exception: java.lang.Exception