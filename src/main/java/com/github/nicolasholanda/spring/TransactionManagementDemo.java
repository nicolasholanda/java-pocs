package com.github.nicolasholanda.spring;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity
@Table(name = "account")
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private Double balance;

    public Account() {
    }

    public Account(String owner, Double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}

@Repository
interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByOwner(String owner);
}

@Service
class AccountService {
    private final AccountRepository accountRepository;

    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    void transfer(Long fromId, Long toId, Double amount) {
        Account from = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("From account not found"));
        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("To account not found"));

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.save(from);
        accountRepository.save(to);
    }

    @Transactional
    void transferWithError(Long fromId, Long toId, Double amount) {
        Account from = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("From account not found"));
        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("To account not found"));

        from.setBalance(from.getBalance() - amount);
        accountRepository.save(from);

        throw new RuntimeException("Simulated error - transaction should rollback");
    }

    @Transactional(readOnly = true)
    List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    Account createAccount(String owner, Double balance) {
        Account account = new Account(owner, balance);
        return accountRepository.save(account);
    }
}

public class TransactionManagementDemo {

    public static void execute() {
        System.out.println("Transaction Management with JPA:");
        System.out.println("Annotations:");
        System.out.println("- @Transactional - marks method as transactional");
        System.out.println("- readOnly=true - optimizes for read operations");
        System.out.println("- @Entity - marks JPA entity");
        System.out.println("- @Id, @GeneratedValue - primary key configuration");
        System.out.println("- Automatic rollback on exception");
        System.out.println("Run within Spring Boot context to test transactions");
    }
}
