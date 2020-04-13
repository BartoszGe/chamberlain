package com.balaur.chamberlain.shop.model;

import com.balaur.chamberlain.shop.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Product {

  Type type;

  String name;

  Double price;

  LocalDateTime dateOfProduction;
}
