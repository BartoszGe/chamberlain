package com.balaur.chamberlain;

import com.balaur.chamberlain.repository.ProductRepository;
import com.balaur.chamberlain.repository.ProductRequestRepository;
import com.balaur.chamberlain.service.ProductService;
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
}
