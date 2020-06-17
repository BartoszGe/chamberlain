package com.balaur.chamberlain.service;

import com.balaur.chamberlain.model.ProductWithType;
import com.balaur.chamberlain.repository.ProductRepository;

import java.util.List;

public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(final ProductRepository productRepository) {

    this.productRepository = productRepository;
  }

  public List<ProductWithType> findAll() {

    return productRepository.findAllWithType();
  }
}
