package com.balaur.chamberlain.service;

import com.balaur.chamberlain.dao.tables.pojos.OrderService;
import com.balaur.chamberlain.dao.tables.pojos.ProductXOrder;
import com.balaur.chamberlain.repository.OrderRepository;
import com.balaur.chamberlain.repository.ProductXOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

  private final OrderRepository orderRepository;

  private final ProductXOrderRepository productXOrderRepository;

  public ProductOrderService(final OrderRepository orderRepository,
                             final ProductXOrderRepository productXOrderRepository) {

    this.orderRepository = orderRepository;
    this.productXOrderRepository = productXOrderRepository;
  }

  public Long insertIntoReturningId(final OrderService serviceOrder) {

    return orderRepository.insertIntoReturningId(serviceOrder);
  }

  public List<OrderService> findAllOrders() {

    return this.orderRepository.findAll();
  }

  public void insertProductForOrders(final ProductXOrder productXOrder) {

    productXOrderRepository.insert(productXOrder);
  }
}
