package com.balaur.chamberlain.shop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "chamberlain.shop.product")
public class ShopProperties {

  Double discount;
}
