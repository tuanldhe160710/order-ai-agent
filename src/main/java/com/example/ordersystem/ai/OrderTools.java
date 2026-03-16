package com.example.ordersystem.ai;

import com.example.ordersystem.service.OrderService;
import com.example.ordersystem.model.Product;
import org.springframework.ai.tool.annotation.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderTools {
    private final OrderService orderService;

    @Tool(description = "Get the list of all available products")
    public String getProductList() {
        List<Product> products = orderService.getAllProducts();
        if (products.isEmpty()) {
            return "No products available currently.";
        }
        return products.stream()
                .map(p -> String.format("- %s (Price: $%.2f)", p.getName(), p.getPrice()))
                .collect(Collectors.joining("\n"));
    }

    @Tool(description = "Create a new order for a customer")
    public String placeOrder(String customerName, String productName, int quantity) {
        return orderService.createOrder(customerName, productName, quantity);
    }

    @Tool(description = "Check the status of an existing order by ID")
    public String checkOrderStatus(long orderId) {
        return orderService.getOrderStatus(orderId);
    }
}
