package ua.training.part1;

public class AreaApp {
    public static void main(String[] args) {
        System.out.println("area = " + area(-5, 9));
    }

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
}
