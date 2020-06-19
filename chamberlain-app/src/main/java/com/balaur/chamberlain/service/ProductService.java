package com.balaur.chamberlain.service;

import com.balaur.chamberlain.dao.ProductTypeEnum;
import com.balaur.chamberlain.dao.ProductWithType;
import com.balaur.chamberlain.dao.tables.pojos.Product;
import com.balaur.chamberlain.repository.ProductRepository;
import com.balaur.chamberlain.repository.ProductRequestRepository;
import com.balaur.chamberlain.repository.ProductTypeRepository;

import java.util.List;

public class ProductService {

  private final ProductRepository productRepository;

  private final ProductRequestRepository productRequestRepository;

  private final ProductTypeRepository productTypeRepository;

  public ProductService(final ProductRepository productRepository,
                        final ProductRequestRepository productRequestRepository,
                        final ProductTypeRepository productTypeRepository) {

    this.productRepository = productRepository;
    this.productRequestRepository = productRequestRepository;
    this.productTypeRepository = productTypeRepository;
  }

  public List<ProductWithType> findAll() {

    return productRepository.findAllWithType();
  }

  public Long insertIntoProductRequest(final String productName) {

    return productRequestRepository.insertIntoReturningId(productName);
  }

  public Long insertIntoReturningId(final String name, final double price, final String measureType, final String description, final ProductTypeEnum type) {

    Long typeId = productTypeRepository.getIdByType(type);
    return productRepository.insertIntoReturningId(new Product(null, name, typeId, price, 0, measureType, description));
  }
}
