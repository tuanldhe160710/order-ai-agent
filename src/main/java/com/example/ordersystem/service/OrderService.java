package com.example.ordersystem.service;

import com.example.ordersystem.model.Order;
import com.example.ordersystem.model.OrderItem;
import com.example.ordersystem.model.Product;
import com.example.ordersystem.repository.OrderRepository;
import com.example.ordersystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public String createOrder(String customerName, String productName, int quantity) {
        Optional<Product> productOpt = productRepository.findByNameIgnoreCase(productName);
        if (productOpt.isEmpty()) {
            return "Product not found: " + productName;
        }

        Product product = productOpt.get();
        OrderItem item = OrderItem.builder()
                .product(product)
                .quantity(quantity)
                .build();

        Order order = Order.builder()
                .customerName(customerName)
                .items(List.of(item))
                .status("PENDING")
                .totalPrice(product.getPrice() * quantity)
                .build();

        Order savedOrder = orderRepository.save(order);
        return "Order created successfully with ID: " + savedOrder.getId() + ". Total price: " + savedOrder.getTotalPrice();
    }

    public String getOrderStatus(Long orderId) {
        return orderRepository.findById(orderId)
                .map(order -> "Order #" + orderId + " status is: " + order.getStatus())
                .orElse("Order not found with ID: " + orderId);
    }
}
