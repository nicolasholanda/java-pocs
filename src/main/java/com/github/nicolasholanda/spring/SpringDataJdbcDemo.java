package com.github.nicolasholanda.spring;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

class Customer {
    @Id
    private Long id;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

@Repository
interface CustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findByName(String name);
}

public class SpringDataJdbcDemo {

    public static void execute() {
        System.out.println("Spring Data JDBC Demo:");
        System.out.println("Features:");
        System.out.println("- CrudRepository - basic CRUD operations");
        System.out.println("- @Id - marks primary key field");
        System.out.println("- findById, findAll, save, delete");
        System.out.println("- Custom query methods (findByName)");
        System.out.println("- H2 in-memory database");
        System.out.println("Run within Spring Boot context to execute");
    }
}
