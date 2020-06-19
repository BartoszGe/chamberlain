package com.balaur.chamberlain.controller;

import com.balaur.chamberlain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "rest/shop")
public class GroceryStoreController {

  private final ProductService productService;

  public GroceryStoreController(final ProductService productService) {

    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<?> getProducts() {

    return ResponseEntity.ok(productService.findAll());
  }

  @PostMapping("/product")
  public ResponseEntity<?> postProduct(@RequestParam(required = true) final String name) {

    return ResponseEntity.ok(productService.insertIntoProductRequest(name));
  }
}
