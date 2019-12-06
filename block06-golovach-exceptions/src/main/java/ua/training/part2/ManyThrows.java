package ua.training.part2;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class ManyThrows {
    // пугаем ОБОИМИ исключениями
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        f0();
        f1();
    }

    public static void f0() throws EOFException {
    }

    public static void f1() throws FileNotFoundException {
    }
}

