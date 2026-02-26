package com.github.nicolasholanda.spring;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
class CacheConfig {
}

@Service
class BookService {
    private final Map<Long, String> database = new HashMap<>();
    private int callCount = 0;

    BookService() {
        database.put(1L, "Spring in Action");
        database.put(2L, "Clean Code");
        database.put(3L, "Effective Java");
    }

    @Cacheable(value = "books", key = "#id")
    String getBook(Long id) {
        callCount++;
        System.out.println("Database call " + callCount + " for book ID: " + id);
        simulateSlowService();
        return database.get(id);
    }

    @CachePut(value = "books", key = "#id")
    String updateBook(Long id, String title) {
        System.out.println("Updating book ID: " + id);
        database.put(id, title);
        return title;
    }

    @CacheEvict(value = "books", key = "#id")
    void deleteBook(Long id) {
        System.out.println("Deleting book ID: " + id);
        database.remove(id);
    }

    @CacheEvict(value = "books", allEntries = true)
    void clearCache() {
        System.out.println("Clearing all cache");
    }

    int getCallCount() {
        return callCount;
    }

    void resetCallCount() {
        callCount = 0;
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class CaffeineCacheDemo {

    public static void execute() {
        System.out.println("Caffeine Cache Demo:");
        System.out.println("Annotations:");
        System.out.println("- @EnableCaching - enables Spring caching");
        System.out.println("- @Cacheable - caches method result");
        System.out.println("- @CachePut - updates cache");
        System.out.println("- @CacheEvict - removes from cache");
        System.out.println("- allEntries=true - clears entire cache");
        System.out.println("Run within Spring Boot context to test caching");
    }
}
