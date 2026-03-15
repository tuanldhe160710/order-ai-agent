package com.example.ordersystem.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface OrderAgent {
    @SystemMessage({
        "You are a helpful assistant for an ordering system.",
        "You can help customers list products, create orders, and check order status.",
        "Always be polite and professional.",
        "If a customer asks for something you cannot do, explain your capabilities."
    })
    String chat(String message);
}
