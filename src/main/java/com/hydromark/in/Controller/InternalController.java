package com.hydromark.in.Controller;

import com.hydromark.in.DTO.Products;
import com.hydromark.in.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/v1/internal")
public class InternalController {
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/addProduct")
    public Map<String, String> addProduct(@RequestParam("productId") Long productId,
                                 @RequestParam("productName") String productName,
                                 @RequestParam("productDesc") String productDesc,
                                 @RequestParam("productImage") MultipartFile productImage) throws IOException {
        String product = Base64.getEncoder().encodeToString(productImage.getBytes());
        productRepository.save(new Products(productId, productName, productDesc, product));
        return Map.of("success", "success");
    }

    @GetMapping("/getProductImage")
    public List<String> getProductsImages() {
        List<Products> products =  productRepository.findAll();
        List<String> productImages = new ArrayList<>();
        for(Products product : products) {
            productImages.add(product.getProductImage());
        }
        return productImages;
    }
    @GetMapping("/getProducts")
    public List<String> getProducts() {
        List<Products> products =  productRepository.findAll();
        List<String> productName = new ArrayList<>();
        for(Products product : products) {
            productName.add(product.getProductName());
        }
        return productName;
    }
}
