package com.studiokaori.trackmoney;

import com.studiokaori.trackmoney.controller.MainController;

/**
 * This class is the main class of the "Track Money" application.
 * "rack Money" is a very simple, text based money tracker.
 * This class simply calls main menu.
 *
 * @author Kaori Persson
 * @version 2020.09
 */
public class Main {

    public static void main(String[] args) {

        // added comment here for git pull test
        new MainController().run();

    }
}
