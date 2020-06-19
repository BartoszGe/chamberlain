package com.balaur.chamberlain;

import com.balaur.chamberlain.repository.OrderRepository;
import com.balaur.chamberlain.repository.ProductRepository;
import com.balaur.chamberlain.repository.ProductRequestRepository;
import com.balaur.chamberlain.repository.UserRepository;
import com.balaur.chamberlain.service.OrderService;
import com.balaur.chamberlain.service.ProductService;
import com.balaur.chamberlain.service.UserService;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChamberlainConfiguration {

  @Bean
  public ProductRepository productRepository(final DefaultDSLContext dsl) {

    return new ProductRepository(dsl);
  }

  @Bean
  public ProductRequestRepository productRequestRepository(final DefaultDSLContext dsl) {

    return new ProductRequestRepository(dsl);
  }

  @Bean
  public ProductService productService(final ProductRepository productRepository,
                                       final ProductRequestRepository productRequestRepository) {

    return new ProductService(productRepository, productRequestRepository);
  }

  @Bean
  public OrderRepository orderRepository(final DefaultDSLContext dsl) {

    return new OrderRepository(dsl);
  }

  @Bean
  public OrderService orderService(final OrderRepository orderRepository) {

    return new OrderService(orderRepository);
  }

  @Bean
  public UserRepository userRepository(final DefaultDSLContext dsl) {

    return new UserRepository(dsl);
  }

  @Bean
  public UserService userService(final UserRepository userRepository) {

    return new UserService(userRepository);
  }
}
