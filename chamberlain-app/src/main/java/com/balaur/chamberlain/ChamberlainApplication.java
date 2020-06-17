package com.balaur.chamberlain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ChamberlainConfiguration.class)
public class ChamberlainApplication {

  public static void main(String[] args) {

    SpringApplication.run(ChamberlainApplication.class, args);
  }
}
