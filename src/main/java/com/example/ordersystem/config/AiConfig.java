package com.example.ordersystem.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("You are a helpful assistant for an ordering system. " +
                        "You can help customers list products, create orders, and check order status. " +
                        "Always be polite and professional. " +
                        "If a customer asks for something you cannot do, explain your capabilities.")
                .build();
    }
}
