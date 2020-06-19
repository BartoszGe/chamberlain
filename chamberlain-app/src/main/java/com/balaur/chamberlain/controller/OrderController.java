package com.balaur.chamberlain.controller;

import com.balaur.chamberlain.dao.chamberlain.tables.pojos.ServiceOrder;
import com.balaur.chamberlain.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "rest/order")
public class OrderController {

  private final OrderService orderService;

  public OrderController(final OrderService orderService) {

    this.orderService = orderService;
  }

  @PostMapping("/new")
  public ResponseEntity<?> postProduct(@RequestParam(required = true) Double price,
                                       @RequestParam(required = true) String deliveryTime,
                                       @RequestParam(required = true) String deliveryPlace) {
    ;
    final ServiceOrder serviceOrder = new ServiceOrder(null, price, Timestamp.valueOf(deliveryTime), deliveryPlace);
    return ResponseEntity.ok(orderService.insertIntoReturningId(serviceOrder));
  }
}
