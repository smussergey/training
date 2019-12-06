package ua.training.part2;

public class ParentChildApp {
    public static void test(Parent ref) {
        // тут все компилируется, Parent.f() пугает Exception и мы его ловим catch
        try {
            ref.f();
        } catch (Exception e) {
        }
    }
}
