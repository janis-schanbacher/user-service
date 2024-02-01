package com.janis.usersservice.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId(1);
        user.setName("John Doe");
        user.setFirstName("John");
        user.setEmail("john.doe@example.com");

        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("John", user.getFirstName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testNoArgsConstructor() {
        User user = new User();

        assertEquals(0, user.getId());
        assertNull(user.getName());
        assertNull(user.getFirstName());
        assertNull(user.getEmail());
    }

    @Test
    public void testAllArgsConstructor() {
        User user = new User(1, "John Doe", "John", "john.doe@example.com");

        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("John", user.getFirstName());
        assertEquals("john.doe@example.com", user.getEmail());
    }
}
