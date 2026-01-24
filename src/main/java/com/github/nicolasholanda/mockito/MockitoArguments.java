package com.github.nicolasholanda.mockito;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class MockitoArguments {

    static void execute() {

        UserRepository mockRepo = mock(UserRepository.class);
        User user = new User(1L, "John");
        when(mockRepo.findById(anyLong())).thenReturn(user);

        User result1 = mockRepo.findById(1L);
        User result2 = mockRepo.findById(999L);
        System.out.println("Found with 1L: " + result1.name);
        System.out.println("Found with 999L: " + result2.name);


        when(mockRepo.findById(eq(5L))).thenReturn(new User(5L, "Alice"));
        User result3 = mockRepo.findById(5L);
        System.out.println("Found with eq(5L): " + result3.name);



        when(mockRepo.findById(argThat(id -> id > 100))).thenReturn(new User(999L, "Premium User"));
        User result4 = mockRepo.findById(150L);
        System.out.println("Found with id > 100: " + result4.name);



        doNothing().when(mockRepo).save(any(User.class));
        mockRepo.save(user);
        verify(mockRepo).save(any(User.class));
        System.out.println("Verified save with any matcher");
    }
}

