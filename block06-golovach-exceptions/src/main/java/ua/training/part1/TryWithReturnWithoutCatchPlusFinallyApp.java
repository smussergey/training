package ua.training.part1;

public class TryWithReturnWithoutCatchPlusFinallyApp {
    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }
}

//>> finally
