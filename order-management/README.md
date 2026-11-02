# Order Management System — Spring Boot, MySQL, JPA and Swagger

A separate order-management application related to the Product Management System. It uses the **same MySQL database** and references the existing `products` table. No Docker.

## Requirements
- Java 17+
- MySQL 8+
- Maven 3.9+ or IntelliJ IDEA/Eclipse

## Important relationship setup
1. Start the Product Management application at least once so it creates the `products` table.
2. Create the database if not already created:
   ```sql
   CREATE DATABASE product_management;
   ```
3. Configure the same MySQL credentials in this project's `src/main/resources/application.properties`.
4. Run this app on port 8081. It creates `customer_orders` and `order_items`; it maps the existing `products` table as read-only catalogue data.

Relationship:
- One `CustomerOrder` has many `OrderItem` rows.
- Each `OrderItem` references one existing `Product`.
- One `Product` can appear in many order items.
- `unitPrice` is copied at order creation so later product price changes don't change historical order totals.

## Run
```powershell
mvn spring-boot:run
```
Or import as a Maven project and run `OrderManagementApplication.java`.

## Swagger
- UI: http://localhost:8081/swagger-ui.html
- OpenAPI JSON: http://localhost:8081/v3/api-docs

## Create an order
First create a product in Product Management or use an existing product ID from `GET http://localhost:8080/api/products`.

Then in Swagger, run `POST /api/orders` with:
```json
{
  "customerName": "Asha Sharma",
  "customerEmail": "asha@example.com",
  "shippingAddress": "12 MG Road, Bengaluru, Karnataka",
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 2, "quantity": 1 }
  ]
}
```
Use real product IDs that exist in the `products` table. The server reads each product price and calculates the order total.

## Endpoints
- `POST /api/orders` — create order with product IDs and quantities
- `GET /api/orders` — list orders
- `GET /api/orders/{id}` — order details including items and linked products
- `PUT /api/orders/{id}` — edit order while status is CREATED
- `DELETE /api/orders/{id}` — delete CREATED or CANCELLED order
- `PATCH /api/orders/{id}/status?status=CONFIRMED` — change status
- `GET /api/orders/search/customer?name=Asha`
- `GET /api/orders/search/email?email=asha@example.com`
- `GET /api/orders/search/status?status=CREATED`
- `GET /api/orders/page?page=0&size=10&sortBy=createdAt&direction=DESC`

Statuses: `CREATED`, `CONFIRMED`, `SHIPPED`, `DELIVERED`, `CANCELLED`.

## Troubleshooting
- **Product not found:** create a product first and use its actual ID.
- **Unknown database:** create `product_management`.
- **Table products doesn't exist:** run Product Management once before Order Management.
- **Access denied:** verify DB username/password.
- **Port conflict:** Order Management uses 8081 to run alongside Product Management on 8080.
- **Swagger:** open after the application has fully started.
