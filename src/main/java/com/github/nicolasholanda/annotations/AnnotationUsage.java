package com.github.nicolasholanda.annotations;

@Entity(table = "users")
@Deprecated(reason = "Use V2 user", since = "2.0")
class User {

    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Execute(priority = 1)
    public void initialize() {
        System.out.println("Initializing: " + name);
    }

    @Execute(priority = 2)
    @Deprecated(reason = "Use save method", since = "1.5")
    public void persist() {
        System.out.println("Persisting: " + name);
    }

    public void save() {
        System.out.println("Saving user: " + name);
    }
}

public class AnnotationUsage {
    static void execute() {
        System.out.println("User class with @Entity, @Column, @Execute, @Deprecated");
        System.out.println("Product class with @Entity, @Column, @Execute");
    }
}

