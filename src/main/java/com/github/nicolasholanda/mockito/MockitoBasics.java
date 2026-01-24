package com.github.nicolasholanda.mockito;

import java.util.List;

import static org.mockito.Mockito.*;

interface UserRepository {
    User findById(Long id);

    void save(User user);

    List<User> findAll();
}

class User {
    Long id;
    String name;

    User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

class UserService {
    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    User getUser(Long id) {
        return repository.findById(id);
    }

    void saveUser(User user) {
        repository.save(user);
    }
}

public class MockitoBasics {

    static void execute() {
        UserRepository mockRepo = mock(UserRepository.class);
        System.out.println("Mock created: " + (mockRepo != null));

        User user = new User(1L, "John");
        when(mockRepo.findById(1L)).thenReturn(user);

        UserService service = new UserService(mockRepo);
        service.getUser(1L);
        verify(mockRepo).findById(1L);
        System.out.println("Verified findById was called");


        System.out.println("Verify save:");
        service.saveUser(user);
        verify(mockRepo).save(user);
        System.out.println("Verified save was called");
    }
}

