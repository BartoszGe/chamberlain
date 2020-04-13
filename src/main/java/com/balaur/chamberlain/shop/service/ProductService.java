package com.balaur.chamberlain.shop.service;

import com.balaur.chamberlain.shop.model.Product;
import io.vavr.collection.List;

public class ProductService implements TemplateService<Product> {

  @Override
  public List<Product> findAll() {

    return null;
  }

  @Override
  public Product find(final Long id) {

    return null;
  }

  @Override
  public Product create(final Product product) {

    return product;
  }

  @Override
  public Long delete() {

    return null;
  }
}
