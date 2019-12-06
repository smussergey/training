package ua.training.part1;

public class FinallyReturnValue {
    public static void main(String[] args) {
        System.err.println(f());
    }

    public static int f() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }
}

//>>1

