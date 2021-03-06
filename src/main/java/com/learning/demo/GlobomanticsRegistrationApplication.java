package com.learning.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class GlobomanticsRegistrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(GlobomanticsRegistrationApplication.class, args);
  }
}
