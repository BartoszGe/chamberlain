package com.balaur.chamberlain.controller;

import com.balaur.chamberlain.dao.ProductTypeEnum;
import com.balaur.chamberlain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "rest/shop")
public class ProductController {

  private final ProductService productService;

  public ProductController(final ProductService productService) {

    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<?> getProducts() {

    return ResponseEntity.ok(productService.findAll());
  }

  @PostMapping("/product")
  public ResponseEntity<?> postProduct(@RequestParam(required = true) final String name,
                                       @RequestParam(required = true) final double price,
                                       @RequestParam(required = true) final String measureType,
                                       @RequestParam(required = true) final String description,
                                       @RequestParam(required = true) final String type) {

    return ResponseEntity.ok(productService.insertIntoReturningId(name, price, measureType, description, ProductTypeEnum.valueOf(type.toUpperCase())));
  }

  @PostMapping("/productRequest")
  public ResponseEntity<?> postProductRequest(@RequestParam(required = true) final String name) {

    return ResponseEntity.ok(productService.insertIntoProductRequest(name));
  }
}
