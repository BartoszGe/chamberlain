package com.balaur.chamberlain.shop;

import com.balaur.chamberlain.shop.service.BasketService;
import com.balaur.chamberlain.shop.service.ProductService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ShopProperties.class)
public class ShopConfiguration {

  @Bean
  BasketService basketService(ShopProperties shopProperties) {

    return new BasketService(shopProperties);
  }

  @Bean
  ProductService productService() {
    return new ProductService();
  }
}
