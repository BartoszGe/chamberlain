package com.balaur.chamberlain.shop.model;

import io.vavr.collection.List;
import lombok.Getter;

@Getter
public class Basket {

  List<Product> products;

  Double discount;

  public Basket(final List<Product> products, final Double propertiesDiscount) {

    this.products = products;
    this.discount = measureDiscount(propertiesDiscount);
  }

  private Double measureDiscount(Double propertiesDiscount) {

    return (products.length() / 10) * propertiesDiscount;
  }
}
