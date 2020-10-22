package com.studiokaori.trackmoney.model;

import java.util.Scanner;

/**
 * This class provides scanner instance for all classes.
 */
public class MyScanner {
    public static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    /**
     * Returns scanner instance.
     *
     * @return scanner instance
     */
    public static Scanner getInstance() {
        return scanner;
    }

    public static void close() {
        scanner.close();
    }
}
