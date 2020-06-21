package com.balaur.chamberlain;

import com.balaur.chamberlain.repository.*;
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
  public ProductXOrderRepository productOrderRepository(final DefaultDSLContext dsl) {

    return new ProductXOrderRepository(dsl);
  }

  @Bean
  public OrderRepository orderRepository(final DefaultDSLContext dsl) {

    return new OrderRepository(dsl);
  }

  @Bean
  public UserRepository userRepository(final DefaultDSLContext dsl) {

    return new UserRepository(dsl);
  }
}
