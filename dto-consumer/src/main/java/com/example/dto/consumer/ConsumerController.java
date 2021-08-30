package com.example.dto.consumer;

import com.example.dto.common.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ConsumerController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public String showProduct(Model model) {
        ResponseEntity<List> restExchange = restTemplate.exchange("http://localhost:8189/", HttpMethod.GET, null, List.class);
        List<ProductDTO> products = (List<ProductDTO>)restExchange.getBody();
        model.addAttribute("products", products);
        return "products";
    }

//    @GetMapping("/products")
//    public List<ProductDTO> showProducts() {
//        return restTemplate.getForObject("http://localhost:8189/", List.class);
//    }
}
