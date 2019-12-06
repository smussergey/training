package ua.training.part1;

public class FinallyCancelReturnFromTry{

        public static void main(String[] args) {
            System.err.println(f());
        }

        public static int f() {
            try {
                return 0;
            } finally {
                throw new RuntimeException();
            }
        }
}
