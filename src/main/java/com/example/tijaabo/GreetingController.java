package com.example.tijaabo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class GreetingController {
    @GetMapping
    public String welcome(){
        return " So dhawaw Ina Ali";
    }
    @GetMapping("/greet/{name}")
    public String Greet(@PathVariable String name){
        return " Welcome " + name;
    }

    //ResponseEntity
    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "SuccessHeaderValue");
        return ResponseEntity.ok()
                .headers(headers)
                .body("Request successful!");
    }
    @GetMapping("/Not-found")
    public ResponseEntity<String> getNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: Resource not found.");
    }
    @PostMapping("/create")
    public ResponseEntity<String> createResource() {
        URI location = URI.create("/api/resource/123");  // Mocked location
        return ResponseEntity.created(location)
                .body("Resource created successfully!");
    }
}
