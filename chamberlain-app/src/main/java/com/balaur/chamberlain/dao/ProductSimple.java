package com.balaur.chamberlain.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductSimple {
  private final long id;

  private final int amount;

  private final long orderId;
}
