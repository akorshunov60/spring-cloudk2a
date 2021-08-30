package com.example.dto.producer;

import com.example.dto.common.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository pr;

    @GetMapping("/")
    public List<ProductDTO> getProducts() { return pr.findAllBy();}
}
