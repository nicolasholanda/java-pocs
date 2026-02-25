package com.github.nicolasholanda.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootDemo.class)
class SpringDataJdbcTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        assertNotNull(customers);
    }

    @Test
    void testFindById() {
        Customer customer = customerRepository.findById(1L).orElse(null);
        assertNotNull(customer);
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testSave() {
        Customer newCustomer = new Customer("Test User", "test@example.com");
        Customer saved = customerRepository.save(newCustomer);
        assertNotNull(saved.getId());
        assertEquals("Test User", saved.getName());
    }

    @Test
    void testFindByName() {
        Iterable<Customer> customers = customerRepository.findByName("John Doe");
        assertNotNull(customers);
        assertTrue(customers.iterator().hasNext());
    }

    @Test
    void testDelete() {
        Customer customer = new Customer("To Delete", "delete@example.com");
        Customer saved = customerRepository.save(customer);
        Long id = saved.getId();

        customerRepository.deleteById(id);
        assertFalse(customerRepository.findById(id).isPresent());
    }
}
