package com.balaur.chamberlain.shop.service;

import com.balaur.chamberlain.shop.ShopProperties;
import com.balaur.chamberlain.shop.model.Basket;
import com.balaur.chamberlain.shop.model.Product;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static com.balaur.chamberlain.shop.Type.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ShopServiceTest {

  @Autowired
  ProductService productService;

  @Autowired
  BasketService basketService;

  @Autowired
  ShopProperties shopProperties;

  @Test
  public void shouldCreateBasketWithProducts() {

    //given
    List<Product> products = List.of(
        productService.create(new Product(BAKERY, "chleb", 2.50, LocalDateTime.now())),
        productService.create(new Product(FRESH_FOOD, "jajka", 8.00, LocalDateTime.now())),
        productService.create(new Product(DRINKS, "piwko", 10.00, LocalDateTime.now()))
    );

    //when
    Basket basket = basketService.create(products);

    //then
    assertTrue(basket.getProducts().contains(products.get(0)));
    assertEquals(basket.getProducts().length(), products.length());
  }

  @Test
  public void shouldMeasureProperDiscount() {

    //given
    Product product = productService.create(new Product(BAKERY, "chleb", 2.50, LocalDateTime.now()));

    List<Product> products10 = List.empty();
    for(int idx=0; idx<10; idx++) {
      products10 = products10.append(product);
    }

    List<Product> products15 = List.empty();
    for(int idx=0; idx<15; idx++) {
      products15 = products15.append(product);
    }

    List<Product> products20 = List.empty();
    for(int idx=0; idx<20; idx++) {
      products20 = products20.append(product);
    }

    //when
    Basket basket1 = basketService.create(List.of(product));
    Basket basket2 = basketService.create(products10);
    Basket basket3 = basketService.create(products15);
    Basket basket4 = basketService.create(products20);


    //then
    assertEquals(0, basket1.getDiscount());
    assertEquals(10, products10.length());
    assertEquals(shopProperties.getDiscount(), basket2.getDiscount());
    assertEquals(shopProperties.getDiscount(), basket3.getDiscount());
    assertEquals(shopProperties.getDiscount() * 2, basket4.getDiscount());

  }

}
