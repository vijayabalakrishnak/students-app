package com.mycompany.app;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {
    }

    public String getMessage() {
        return MESSAGE;
    }

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Home endpoint
        server.createContext("/", App::homeHandler);

        // Health endpoint
        server.createContext("/health", App::healthHandler);

        server.setExecutor(null);
        server.start();

        System.out.println("=================================");
        System.out.println("Student Application Started");
        System.out.println("Listening on port 8080");
        System.out.println("=================================");
    }

    private static void homeHandler(HttpExchange exchange) throws IOException {

        String response = "Hello World! Welcome to Student Application";

        exchange.sendResponseHeaders(200, response.getBytes().length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    private static void healthHandler(HttpExchange exchange) throws IOException {

        String response = "Application is UP";

        exchange.sendResponseHeaders(200, response.getBytes().length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
