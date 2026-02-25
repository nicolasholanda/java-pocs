package com.github.nicolasholanda.spring;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
class UserController {
    private final Map<Long, String> users = new HashMap<>();
    private long counter = 0;

    UserController() {
        users.put(++counter, "Alice");
        users.put(++counter, "Bob");
    }

    @GetMapping
    Map<Long, String> getAll() {
        return users;
    }

    @GetMapping("/{id}")
    String getById(@PathVariable Long id) {
        String user = users.get(id);
        return user != null ? user : "";
    }

    @PostMapping
    Map<String, Object> create(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        long id = ++counter;
        users.put(id, name);
        return Map.of("id", id, "name", name);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        users.remove(id);
    }
}

public class RestIntegrationTestDemo {

    public static void execute() {
        System.out.println("REST Integration Test Demo:");
        System.out.println("Testing tools:");
        System.out.println("- MockMvc - test MVC layer without starting server");
        System.out.println("- WebTestClient - reactive testing client");
        System.out.println("- @WebMvcTest - slice test for controllers");
        System.out.println("- @AutoConfigureMockMvc - auto-configure MockMvc");
        System.out.println("See test classes for examples");
    }
}
