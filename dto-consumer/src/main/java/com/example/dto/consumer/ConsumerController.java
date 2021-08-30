package com.example.dto.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    @GetMapping("/products")
    public String showProducts() {
        Optional<List> products = Optional.ofNullable(restTemplate.getForObject("http://localhost:8189/", List.class));
        return "products" + products;
    }
}
