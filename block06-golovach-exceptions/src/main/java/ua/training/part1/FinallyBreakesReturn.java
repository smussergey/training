package ua.training.part1;

public class FinallyBreakesReturn {
        public static void main(String[] args) {
            System.err.println(f());
        }

        public static int f() {
            try {
                return 0;
            } finally {
                return 1;
            }
        }
    }

//>>1
