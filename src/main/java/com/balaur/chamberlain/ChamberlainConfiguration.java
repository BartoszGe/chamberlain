package com.balaur.chamberlain;

import com.balaur.chamberlain.shop.ShopConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ShopConfiguration.class})
public class ChamberlainConfiguration {

}
