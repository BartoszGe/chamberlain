package com.balaur.chamberlain;

import com.balaur.chamberlain.repository.ProductRepository;
import com.balaur.chamberlain.repository.ProductTypeRepository;
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
  public ProductTypeRepository productTypeRepository(final DefaultDSLContext dsl) {

    return new ProductTypeRepository(dsl);
  }

  @Bean
  public ProductService productService(final ProductRepository productRepository) {

    return new ProductService(productRepository);
  }
}
