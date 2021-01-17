package com.learning.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.outbound.AmqpOutboundEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfiguration {

  @Bean
  public IntegrationFlow registrationRequestFlow() {
    return IntegrationFlows
        .from("registrationRequest")
        .transform(Transformers.toJson())
        .gateway("toRabbit")
        .get();
  }

  @Bean
  public IntegrationFlow amqpOutbound(RabbitTemplate rabbitTemplate) {
    AmqpOutboundEndpoint outbound = new AmqpOutboundEndpoint(rabbitTemplate);
    outbound.setRequiresReply(false);
    outbound.setExpectReply(false);
    outbound.setRoutingKey("globomantics.registrationRequest");

    return IntegrationFlows
        .from("toRabbit")
        .handle(outbound)
        .get();
  }

  @Bean
  public MessageChannel registrationRequest() {
    return new DirectChannel();
  }

  @Bean
  public MessageChannel toRabbit() {
    return new DirectChannel();
  }
}
