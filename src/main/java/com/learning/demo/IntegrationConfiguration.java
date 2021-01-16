package com.learning.demo;

import com.learning.demo.service.RegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfiguration {

  @Bean
  public MessageChannel registrationRequest() {
    return MessageChannels.direct("registrationRequest").get();
  }

  @Bean
  public IntegrationFlow integrationFlow(RegistrationService registrationService) {
    return IntegrationFlows
        .from("registrationRequest")
        .handle(registrationService, "register")
        .get();
  }
}
