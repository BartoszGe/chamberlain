package com.balaur.chamberlain.service;

import com.balaur.chamberlain.dao.chamberlain.tables.pojos.ServiceOrder;
import com.balaur.chamberlain.repository.OrderRepository;

public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(final OrderRepository orderRepository) {

    this.orderRepository = orderRepository;
  }

  public Long insertIntoReturningId(final ServiceOrder serviceOrder) {

    return orderRepository.insertIntoReturningId(serviceOrder);
  }

}
