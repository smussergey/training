package ua.training;

public class CustomArrayListApp {
    public static void main(String[] args) {
        CustomArrayListImpl<String> str = new CustomArrayListImpl<>();
        str.add("first");
        str.add("second");
        str.add("third");
        str.add("forth");

        System.out.println("Initial values:");
        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
        System.out.println("size = " + str.size());
    }
}
