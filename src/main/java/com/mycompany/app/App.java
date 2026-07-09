package com.mycompany.app;

public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {
    }

    public static void main(String[] args) throws Exception {

        System.out.println(MESSAGE);

        while (true) {
            Thread.sleep(60000);
        }
    }

    public String getMessage() {
        return MESSAGE;
    }
}
