package com.github.nicolasholanda.spring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

class Product {
    private Long id;
    private String name;
    private double price;

    Product() {
    }

    Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

@RestController
@RequestMapping("/api/products")
class ProductController {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    ProductController() {
        products.add(new Product(counter.incrementAndGet(), "Laptop", 999.99));
        products.add(new Product(counter.incrementAndGet(), "Mouse", 29.99));
    }

    @GetMapping
    List<Product> getAll() {
        return products;
    }

    @GetMapping("/{id}")
    Product getById(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    Product create(@RequestBody Product product) {
        product.setId(counter.incrementAndGet());
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    Product update(@PathVariable Long id, @RequestBody Product updated) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                updated.setId(id);
                products.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}

@RestController
@RequestMapping("/api/hello")
class HelloController {

    @GetMapping
    String hello() {
        return "Hello from Spring Boot REST!";
    }

    @GetMapping("/{name}")
    String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping
    String create(@RequestBody String message) {
        return "Received: " + message;
    }
}

public class RestSupportDemo {

    public static void execute() {
        System.out.println("REST Support Demo:");
        System.out.println("Controllers registered:");
        System.out.println("- GET /api/hello");
        System.out.println("- GET /api/hello/{name}");
        System.out.println("- POST /api/hello");
        System.out.println("- GET /api/products");
        System.out.println("- GET /api/products/{id}");
        System.out.println("- POST /api/products");
        System.out.println("- PUT /api/products/{id}");
        System.out.println("- DELETE /api/products/{id}");
        System.out.println("Start Spring Boot application to test endpoints");
    }
}
