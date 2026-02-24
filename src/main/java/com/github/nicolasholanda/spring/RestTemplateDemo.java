package com.github.nicolasholanda.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
class ApiClient {
    private final RestTemplate restTemplate;

    ApiClient() {
        this.restTemplate = new RestTemplate();
    }

    String getPlaceholder() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    Map getUser(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        return restTemplate.getForObject(url, Map.class);
    }

    Map createPost(Map<String, Object> post) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return restTemplate.postForObject(url, post, Map.class);
    }

    void updatePost(int id, Map<String, Object> post) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        restTemplate.put(url, post);
    }

    void deletePost(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        restTemplate.delete(url);
    }

    String getWithHeaders() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Spring RestTemplate");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}

@Service
class ExternalApiService {
    private final ApiClient apiClient;

    ExternalApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    void demonstrateAll() {
        System.out.println("GET request:");
        String post = apiClient.getPlaceholder();
        System.out.println(post);

        System.out.println("GET user:");
        Map user = apiClient.getUser(1);
        System.out.println("User: " + user.get("name"));

        System.out.println("POST request:");
        Map<String, Object> newPost = Map.of(
                "title", "New Post",
                "body", "This is a new post",
                "userId", 1
        );
        Map created = apiClient.createPost(newPost);
        System.out.println("Created: " + created.get("id"));

        System.out.println("PUT request:");
        Map<String, Object> updatedPost = Map.of(
                "title", "Updated Post",
                "body", "Updated content",
                "userId", 1
        );
        apiClient.updatePost(1, updatedPost);
        System.out.println("Post updated");

        System.out.println("DELETE request:");
        apiClient.deletePost(1);
        System.out.println("Post deleted");

        System.out.println("GET with headers:");
        String withHeaders = apiClient.getWithHeaders();
        System.out.println(withHeaders);
    }
}

public class RestTemplateDemo {

    public static void execute() {
        System.out.println("RestTemplate Demo:");
        System.out.println("RestTemplate provides:");
        System.out.println("- getForObject/getForEntity - HTTP GET");
        System.out.println("- postForObject/postForEntity - HTTP POST");
        System.out.println("- put - HTTP PUT");
        System.out.println("- delete - HTTP DELETE");
        System.out.println("- exchange - generic HTTP method");
        System.out.println("Run within Spring Boot context to execute API calls");
    }
}
