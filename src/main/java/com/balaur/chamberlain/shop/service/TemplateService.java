package com.balaur.chamberlain.shop.service;

import io.vavr.collection.List;

public interface TemplateService<T> {

  List<T> findAll();

  T find(Long id);

  T create(T t);

  Long delete();
}
