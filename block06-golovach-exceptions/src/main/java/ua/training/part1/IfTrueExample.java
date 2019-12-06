package ua.training.part1;

public class IfTrueExample {
        public static void main (String[]args){
            try {
                System.err.println("try");
                if (true) {
                    throw new RuntimeException();
                }
            } finally {
                System.err.println("finally");
            }
            System.err.println("more");
        }
    }
//>> try
//>> finally
//>> Exception in thread "main" java.lang.RuntimeException

//    public static void main(String[] args) {
//        try {
//            System.err.println("try");
//            throw new RuntimeException();
//        } finally {
//            System.err.println("finally");
//        }
//        System.err.println("more");
//    }
//}

//>> COMPILER ERROR: Unrechable statement
