package com.balaur.chamberlain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductWithType {

  private final Long id;

  private final String name;

  private final double price;

  private final String measureType;

  private final String description;

  private final String type;
}
