package com.example.ordersystem.controller;

import com.example.ordersystem.ai.OrderAgent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@RequiredArgsConstructor
public class AgentController {
    private final OrderAgent orderAgent;

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        return orderAgent.chat(message);
    }
}
