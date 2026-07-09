package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testAppCreation() {

        App app = new App();

        assertNotNull(app);

    }

    @Test
    void testMessage() {

        App app = new App();

        assertEquals("Hello World!", app.getMessage());

    }

}
