package com.github.nicolasholanda.mockito;

import org.mockito.ArgumentCaptor;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MockitoAdvanced {

    static void execute() {

        System.out.println("doReturn:");
        UserRepository mockRepo = mock(UserRepository.class);
        doReturn(new User(1L, "DoReturn User")).when(mockRepo).findById(1L);
        User user = mockRepo.findById(1L);
        System.out.println("User: " + user.name);

        System.out.println("doThrow:");
        doThrow(new RuntimeException("Database error")).when(mockRepo).save(any(User.class));
        try {
            mockRepo.save(new User(2L, "Test"));
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("doAnswer:");
        doAnswer((Answer<User>) invocation -> {
            Long id = invocation.getArgument(0);
            return new User(id, "Custom Answer User " + id);
        }).when(mockRepo).findById(anyLong());
        User customUser = mockRepo.findById(42L);
        System.out.println("Custom user: " + customUser.name);

        System.out.println("doNothing:");
        UserRepository mockRepo2 = mock(UserRepository.class);
        doNothing().when(mockRepo2).save(any(User.class));
        mockRepo2.save(new User(3L, "Silent Save"));
        verify(mockRepo2).save(any(User.class));
        System.out.println("Silent save verified");

        System.out.println("ArgumentCaptor:");
        UserRepository mockRepo3 = mock(UserRepository.class);
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        mockRepo3.save(new User(10L, "Captured User"));
        verify(mockRepo3).save(userCaptor.capture());
        System.out.println("Captured user: " + userCaptor.getValue().name);

        System.out.println("thenReturn chaining:");
        UserRepository mockRepo4 = mock(UserRepository.class);
        when(mockRepo4.findById(1L))
            .thenReturn(new User(1L, "First"))
            .thenReturn(new User(1L, "Second"))
            .thenReturn(new User(1L, "Third"));
        System.out.println("Call 1: " + mockRepo4.findById(1L).name);
        System.out.println("Call 2: " + mockRepo4.findById(1L).name);
        System.out.println("Call 3: " + mockRepo4.findById(1L).name);

        System.out.println("thenThrow:");
        when(mockRepo4.findById(999L)).thenThrow(new RuntimeException("User not found"));
        try {
            mockRepo4.findById(999L);
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}

