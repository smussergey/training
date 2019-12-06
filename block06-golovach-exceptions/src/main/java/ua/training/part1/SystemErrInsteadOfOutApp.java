package ua.training.part1;

public class SystemErrInsteadOfOutApp {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}
