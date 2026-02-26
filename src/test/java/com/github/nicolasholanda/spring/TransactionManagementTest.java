package com.github.nicolasholanda.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SpringBootDemo.class, AccountService.class})
class TransactionManagementTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setup() {
        accountRepository.deleteAll();
    }

    @Test
    void testSuccessfulTransfer() {
        Account from = accountService.createAccount("Alice", 1000.0);
        Account to = accountService.createAccount("Bob", 500.0);

        accountService.transfer(from.getId(), to.getId(), 200.0);

        Account updatedFrom = accountRepository.findById(from.getId()).orElseThrow();
        Account updatedTo = accountRepository.findById(to.getId()).orElseThrow();

        assertEquals(800.0, updatedFrom.getBalance());
        assertEquals(700.0, updatedTo.getBalance());
    }

    @Test
    void testTransactionRollbackOnError() {
        Account from = accountService.createAccount("Alice", 1000.0);
        Account to = accountService.createAccount("Bob", 500.0);

        assertThrows(RuntimeException.class, () ->
            accountService.transferWithError(from.getId(), to.getId(), 200.0)
        );

        Account updatedFrom = accountRepository.findById(from.getId()).orElseThrow();
        Account updatedTo = accountRepository.findById(to.getId()).orElseThrow();

        assertEquals(1000.0, updatedFrom.getBalance());
        assertEquals(500.0, updatedTo.getBalance());
    }

    @Test
    void testInsufficientBalance() {
        Account from = accountService.createAccount("Alice", 100.0);
        Account to = accountService.createAccount("Bob", 500.0);

        assertThrows(RuntimeException.class, () ->
            accountService.transfer(from.getId(), to.getId(), 200.0)
        );

        Account updatedFrom = accountRepository.findById(from.getId()).orElseThrow();
        assertEquals(100.0, updatedFrom.getBalance());
    }

    @Test
    void testReadOnlyTransaction() {
        accountService.createAccount("Alice", 1000.0);
        accountService.createAccount("Bob", 500.0);

        var accounts = accountService.getAllAccounts();
        assertEquals(2, accounts.size());
    }
}
