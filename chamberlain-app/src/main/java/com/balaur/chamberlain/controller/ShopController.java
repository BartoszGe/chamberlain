package com.balaur.chamberlain.controller;

import com.balaur.chamberlain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "rest/shop")
public class ShopController {

  private final ProductService productService;

  public ShopController(final ProductService productService) {

    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<?> getProducts() {

    return ResponseEntity.ok(productService.findAll());
  }
}
