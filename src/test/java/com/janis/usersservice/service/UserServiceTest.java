package com.janis.usersservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.janis.usersservice.entity.User;
import com.janis.usersservice.repository.UserRepository;
import com.janis.usersservice.service.UserService;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser(user);

        assertEquals(user, result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.updateUser(1L, user);

        assertEquals(user, result);
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testUpdateNonExistentUser() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            userService.updateUser(1L, user);
        }, "User not found");

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals(user, result);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetNonExistentUserById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1L);
        }, "User not found");

        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(users, result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUsersByFirstName() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAllByFirstName(anyString())).thenReturn(users);

        List<User> result = userService.getUsersByFirstName("John");

        assertEquals(users, result);
        verify(userRepository, times(1)).findAllByFirstName("John");
    }
}