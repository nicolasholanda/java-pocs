package com.github.nicolasholanda.mockito;

import org.mockito.*;

import static org.mockito.Mockito.*;

class EmailService {
    void sendEmail(String to, String message) {
        System.out.println("Sending email to: " + to);
    }
}

class NotificationService {
    EmailService emailService;

    void notify(String email, String message) {
        emailService.sendEmail(email, message);
    }
}

public class MockitoAnnotations {

    @Mock
    UserRepository mockRepo;

    @Spy
    RealUserService spyService;

    @InjectMocks
    NotificationService notificationService;

    @Captor
    ArgumentCaptor<String> stringCaptor;

    static void execute() {

        MockitoAnnotations instance = new MockitoAnnotations();
        try (AutoCloseable ignored = org.mockito.MockitoAnnotations.openMocks(instance)) {

            System.out.println("@Mock annotation:");
            when(instance.mockRepo.findById(1L)).thenReturn(new User(1L, "Mocked User"));
            User user = instance.mockRepo.findById(1L);
            System.out.println("Mock user: " + user.name);

            System.out.println("@Spy annotation:");
            instance.spyService.saveUser(new User(2L, "Spy Test"));
            verify(instance.spyService).saveUser(any(User.class));
            System.out.println("Spy verified");

            System.out.println("@InjectMocks annotation:");
            instance.notificationService.emailService = mock(EmailService.class);
            instance.notificationService.notify("test@test.com", "Hello");
            verify(instance.notificationService.emailService).sendEmail("test@test.com", "Hello");
            System.out.println("InjectMocks verified");

            System.out.println("@Captor annotation:");
            EmailService emailMock = mock(EmailService.class);
            emailMock.sendEmail("user@example.com", "Test message");
            verify(emailMock).sendEmail(instance.stringCaptor.capture(), anyString());
            System.out.println("Captured email: " + instance.stringCaptor.getValue());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

