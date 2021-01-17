package com.learning.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfiguration {

  @Bean
  public IntegrationFlow amqpOutbound(RabbitTemplate rabbitTemplate) {
    return IntegrationFlows
        .from(toRabbit())
        .transform(Transformers.toJson())
        .handle(Amqp.outboundAdapter(rabbitTemplate)
            .routingKey("globomantics.registrationRequest"))
        .get();
  }

  @Bean
  public MessageChannel toRabbit() {
    return new DirectChannel();
  }
}
