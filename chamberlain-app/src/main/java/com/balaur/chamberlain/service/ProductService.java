package com.balaur.chamberlain.service;

import com.balaur.chamberlain.model.ProductWithType;
import com.balaur.chamberlain.repository.ProductRepository;
import com.balaur.chamberlain.repository.ProductRequestRepository;

import java.util.List;

public class ProductService {

  private final ProductRepository productRepository;

  private final ProductRequestRepository productRequestRepository;

  public ProductService(final ProductRepository productRepository, final ProductRequestRepository productRequestRepository) {

    this.productRepository = productRepository;
    this.productRequestRepository = productRequestRepository;
  }

  public List<ProductWithType> findAll() {

    return productRepository.findAllWithType();
  }

  public Long insertIntoProductRequest(final String productName) {

    return productRequestRepository.insertIntoReturningId(productName);
  }
}
