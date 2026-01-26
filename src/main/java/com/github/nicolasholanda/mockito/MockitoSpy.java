package com.github.nicolasholanda.mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class RealUserService {
    List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Real User 1"));
        users.add(new User(2L, "Real User 2"));
        return users;
    }

    User findUser(Long id) {
        return new User(id, "Real User " + id);
    }

    void saveUser(User user) {
        System.out.println("Real save: " + user.name);
    }
}

public class MockitoSpy {

    static void execute() {

        System.out.println("Spy on real object:");
        RealUserService realService = new RealUserService();
        RealUserService spyService = spy(realService);

        List<User> users = spyService.getUsers();
        System.out.println("Real method called, got " + users.size() + " users");

        System.out.println("Stub spy method:");
        when(spyService.findUser(999L)).thenReturn(new User(999L, "Stubbed User"));
        User stubbedUser = spyService.findUser(999L);
        User realUser = spyService.findUser(1L);
        System.out.println("Stubbed: " + stubbedUser.name);
        System.out.println("Real: " + realUser.name);
    }
}

