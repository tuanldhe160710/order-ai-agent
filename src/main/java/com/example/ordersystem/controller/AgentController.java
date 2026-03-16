package com.example.ordersystem.controller;

import com.example.ordersystem.ai.OrderTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
    
    private final ChatClient chatClient;

    public AgentController(ChatClient chatClient, OrderTools orderTools) {
        this.chatClient = chatClient.mutate()
                .defaultTools(orderTools)
                .build();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
