package com.trxjster.todobackend.service;

import com.trxjster.todobackend.model.User;
import com.trxjster.todobackend.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    private User userExample = new User();
    private User persistedUser = new User();

    @BeforeEach
    void setUp() {
        userExample.setName("Mike");
        userExample.setLastName("Mock");
        userExample.setUsername("MikeMock123");
    }

    @Test
    void assertThatUserIsSavedCorrectly(){
        when(userService.create(any(User.class))).then(returnsFirstArg());

        persistedUser = userService.create(userExample);

        verify(userRepo, times(1)).save(any(User.class));
        assertThat(persistedUser.getUsername()).isEqualTo(userExample.getUsername());
        assertThat(persistedUser.getName()).isEqualTo(userExample.getName());
        assertThat(persistedUser.getLastName()).isEqualTo(userExample.getLastName());


    }

    @Test
    void assertThatGettingUserWithNonExistingIdThrowsException() {
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
            userService.getUserById("Invalid User ID");
        });
        Assertions.assertEquals("User with id Invalid User ID not found", thrown.getMessage());
    }

    @Test
    void assertThatRetrievedUserIsUpdatedCorrectly() {
        persistedUser.setUsername("modified");
        when(userService.updateUser((persistedUser))).then(returnsFirstArg());
        User updatedUser = userService.updateUser(persistedUser);
        assertThat(updatedUser.getUsername()).isEqualTo("modified");
    }

}