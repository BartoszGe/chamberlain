package com.balaur.chamberlain.controller;

import com.balaur.chamberlain.dao.tables.pojos.OrderService;
import com.balaur.chamberlain.dao.tables.pojos.ProductXOrder;
import com.balaur.chamberlain.service.ProductOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "rest/order")
public class OrderController {

  private final ProductOrderService productOrderService;

  public OrderController(final ProductOrderService productOrderService) {

    this.productOrderService = productOrderService;
  }

  @GetMapping("/products")
  public ResponseEntity<?> getProductsOrder() {

    return ResponseEntity.ok(productOrderService.findAllOrders());
  }

  @PostMapping("/new")
  public ResponseEntity<?> postProductOrder(@RequestParam(required = true) Double price,
                                            @RequestParam(required = true) String deliveryTime,
                                            @RequestParam(required = true) String deliveryPlace) {

    final OrderService order = new OrderService(null, price, Timestamp.valueOf(deliveryTime), deliveryPlace, null);
    return ResponseEntity.ok(productOrderService.insertIntoReturningId(order));
  }

  @PostMapping("/fillBasket")
  public ResponseEntity<?> postProductSimple(@RequestParam(required = true) long id,
                                             @RequestParam(required = true) int amount,
                                             @RequestParam(required = true) long orderId) {

    productOrderService.insertProductForOrders(new ProductXOrder(null, id, amount, orderId));
    return ResponseEntity.ok().build();
  }
}
