package com.github.nicolasholanda.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SpringBootDemo.class, CacheConfig.class, BookService.class})
class CaffeineCacheTest {

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setup() {
        bookService.clearCache();
        bookService.resetCallCount();
    }

    @Test
    void testCacheableFirstCall() {
        String book = bookService.getBook(1L);
        assertEquals("Spring in Action", book);
        assertEquals(1, bookService.getCallCount());
    }

    @Test
    void testCacheableSecondCallUsesCachedValue() {
        bookService.getBook(1L);
        bookService.getBook(1L);
        assertEquals(1, bookService.getCallCount());
    }

    @Test
    void testCachePutUpdatesCache() {
        bookService.getBook(1L);
        assertEquals(1, bookService.getCallCount());

        bookService.updateBook(1L, "Updated Title");

        String book = bookService.getBook(1L);
        assertEquals("Updated Title", book);
        assertEquals(1, bookService.getCallCount());
    }

    @Test
    void testCacheEvictRemovesFromCache() {
        bookService.getBook(1L);
        assertEquals(1, bookService.getCallCount());

        bookService.deleteBook(1L);

        bookService.getBook(1L);
        assertEquals(2, bookService.getCallCount());
    }

    @Test
    void testClearCacheRemovesAllEntries() {
        bookService.getBook(1L);
        bookService.getBook(2L);
        assertEquals(2, bookService.getCallCount());

        bookService.clearCache();

        bookService.getBook(1L);
        bookService.getBook(2L);
        assertEquals(4, bookService.getCallCount());
    }
}
