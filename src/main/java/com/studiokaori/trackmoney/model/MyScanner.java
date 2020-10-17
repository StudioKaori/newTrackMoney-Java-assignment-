package com.studiokaori.trackmoney.model;

import java.util.Scanner;

public class MyScanner {
    public static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static Scanner getInstance() {
        return scanner;
    }

    public static void close() {
        scanner.close();
    }
}
