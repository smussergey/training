package ua.training.part1;

public class TryFinallyWithoutCatchApp {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
}

//>>finally
//        >>Exception in thread"main"java.lang.RuntimeException
