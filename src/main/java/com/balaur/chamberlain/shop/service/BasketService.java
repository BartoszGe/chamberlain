package com.balaur.chamberlain.shop.service;

import com.balaur.chamberlain.shop.ShopProperties;
import com.balaur.chamberlain.shop.model.Basket;
import com.balaur.chamberlain.shop.model.Product;
import io.vavr.collection.List;

public class BasketService implements TemplateService<Basket> {

  ShopProperties properties;

  public BasketService(final ShopProperties shopProperties) {

    properties = shopProperties;
  }

  @Override
  public List<Basket> findAll() {

    return null;
  }

  @Override
  public Basket find(final Long id) {

    return null;
  }

  @Override
  public Basket create(final Basket basket) {

    return basket;
  }

  public Basket create(final List<Product> products) {

    return new Basket(products, properties.getDiscount());
  }

  @Override
  public Long delete() {

    return null;
  }
}
