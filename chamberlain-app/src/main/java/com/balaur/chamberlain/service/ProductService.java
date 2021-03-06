package com.balaur.chamberlain.service;

import com.balaur.chamberlain.dao.ProductTypeEnum;
import com.balaur.chamberlain.dao.ProductWithType;
import com.balaur.chamberlain.dao.tables.pojos.Product;
import com.balaur.chamberlain.repository.ProductRepository;
import com.balaur.chamberlain.repository.ProductRequestRepository;
import com.balaur.chamberlain.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

  public List<Product> getByOrder(final Long id) {

    return productRepository.getByOrderId(id);
  }

  public List<ProductWithType> findAllNotDeprecated() {

    return productRepository.findAllNotDeprecatedWithType();
  }

  public Long insertIntoProductRequest(final String productName) {

    return productRequestRepository.insertIntoReturningId(productName);
  }

  public Long insertIntoReturningId(final String name, final double price, final String measureType, final String description, final ProductTypeEnum type) {

    Long typeId = productTypeRepository.getIdByType(type);
    return productRepository.insertIntoReturningId(new Product(null, name, typeId, price, 0, measureType, description, false));
  }

  public Long deprecateProduct(final Long id) {

    productRepository.deprecateProduct(id);
    return id;
  }
}
