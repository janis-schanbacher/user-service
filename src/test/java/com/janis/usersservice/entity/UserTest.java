package com.janis.usersservice.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static java.lang.Long.*;

public class UserTest {
    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setName("John Doe");
        user.setFirstName("John");
        user.setEmail("john.doe@example.com");

        assertEquals(Long.valueOf(1), user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("John", user.getFirstName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testNoArgsConstructor() {
        User user = new User();

        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getFirstName());
        assertNull(user.getEmail());
    }

    @Test
    public void testAllArgsConstructor() {
        User user = new User(Long.valueOf(1), "John Doe", "John", "john.doe@example.com");

        assertEquals(Long.valueOf(1), user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("John", user.getFirstName());
        assertEquals("john.doe@example.com", user.getEmail());
    }
}
