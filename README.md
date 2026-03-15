# Order System AI Agent (Spring Boot + Gemini)

This project demonstrates a simple Order System using Spring Boot 3, Java 17, and an AI Agent powered by Google Gemini (via LangChain4j).

## Features
- **AI Agent**: Natural language interaction to manage orders.
- **Product Management**: Pre-loaded sample products (Laptop, Smartphone, etc.).
- **Order Processing**: Create orders and check status via the AI Agent.
- **H2 Database**: In-memory database for quick testing.

## Prerequisites
- Java 17+
- Maven
- A Gemini API Key from [Google AI Studio](https://aistudio.google.com/app/apikey)

## Configuration
1. Open `src/main/resources/application.properties`.
2. Replace `${GEMINI_API_KEY}` with your actual API key or set it as an environment variable.

## How to Run
```bash
mvn spring-boot:run
```

## How to Test
You can use `curl` or any API client (Postman/Insomnia) to talk to the agent.

### 1. Ask for product list
```bash
curl -X POST http://localhost:8080/api/agent/chat \
     -H "Content-Type: text/plain" \
     -d "What products do you have?"
```

### 2. Place an order
```bash
curl -X POST http://localhost:8080/api/agent/chat \
     -H "Content-Type: text/plain" \
     -d "I am John. I want to buy 2 Laptops"
```

### 3. Check order status
```bash
curl -X POST http://localhost:8080/api/agent/chat \
     -H "Content-Type: text/plain" \
     -d "Check the status of order 1"
```

## Project Structure
- `src/main/java/com/example/ordersystem/ai`: Contains the AI Agent interface and Tools.
- `src/main/java/com/example/ordersystem/service`: Business logic for order management.
- `src/main/java/com/example/ordersystem/model`: JPA Entities (Product, Order, OrderItem).
- `src/main/java/com/example/ordersystem/controller`: REST endpoint for the Chat Agent.
