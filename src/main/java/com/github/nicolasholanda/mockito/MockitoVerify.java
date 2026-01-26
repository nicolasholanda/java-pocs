package com.github.nicolasholanda.mockito;

import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MockitoVerify {

    static void execute() {

        System.out.println("verify times:");
        UserRepository mockRepo = mock(UserRepository.class);
        User user = new User(1L, "John");

        mockRepo.save(user);
        mockRepo.save(user);
        verify(mockRepo, times(2)).save(user);
        System.out.println("Verified save called 2 times");

        System.out.println("verify never:");
        verify(mockRepo, never()).findById(anyLong());
        System.out.println("Verified findById never called");

        System.out.println("verify atLeast:");
        mockRepo.findById(1L);
        mockRepo.findById(1L);
        mockRepo.findById(1L);
        verify(mockRepo, atLeast(2)).findById(1L);
        System.out.println("Verified findById called at least 2 times");

        System.out.println("verify atMost:");
        verify(mockRepo, atMost(5)).findById(1L);
        System.out.println("Verified findById called at most 5 times");

        System.out.println("verify order:");
        UserRepository mockRepo2 = mock(UserRepository.class);
        mockRepo2.findById(1L);
        mockRepo2.save(user);
        InOrder inOrder = inOrder(mockRepo2);
        inOrder.verify(mockRepo2).findById(1L);
        inOrder.verify(mockRepo2).save(user);
        System.out.println("Verified method call order");

        System.out.println("verifyNoMoreInteractions:");
        UserRepository mockRepo3 = mock(UserRepository.class);
        mockRepo3.findById(1L);
        verify(mockRepo3).findById(1L);
        verifyNoMoreInteractions(mockRepo3);
        System.out.println("Verified no more interactions");
    }
}

