package com.balaur.chamberlain;

import com.balaur.chamberlain.repository.*;
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
  public ProductTypeRepository productTypeRepository(final DefaultDSLContext dsl) {

    return new ProductTypeRepository(dsl);
  }

  @Bean
  public ProductRequestRepository productRequestRepository(final DefaultDSLContext dsl) {

    return new ProductRequestRepository(dsl);
  }

  @Bean
  public ProductService productService(final ProductRepository productRepository,
                                       final ProductRequestRepository productRequestRepository,
                                       final ProductTypeRepository productTypeRepository) {

    return new ProductService(productRepository, productRequestRepository, productTypeRepository);
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
