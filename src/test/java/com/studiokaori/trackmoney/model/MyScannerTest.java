package com.studiokaori.trackmoney.model;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyScannerTest {

    @Test
    void getScanner() {
        Scanner scanner1 = MyScanner.getInstance();
        Scanner scanner2 = MyScanner.getInstance();

        // supposed to be only one scanner instance
        assertEquals(scanner1, scanner2);
    }

}