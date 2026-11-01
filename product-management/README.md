# Product Management System (Spring Boot + MySQL + JPA + Swagger)

Includes product CRUD, searching, sorting, filtering, pagination, and automatic createdAt/updatedAt timestamps. No Docker and no order management.

## Requirements
- JDK 17+
- MySQL Server 8+
- Maven 3.9+ or import as an existing Maven project in IntelliJ/Eclipse

## 1. Create database
Run in MySQL Workbench:
```sql
CREATE DATABASE product_management;
```

## 2. Configure credentials
Edit `src/main/resources/application.properties`. Replace `change_me` with your local MySQL password, or set environment variables `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`.

## 3. Run
From the project folder:
```powershell
mvn spring-boot:run
```
Or import into IntelliJ/Eclipse and run `ProductManagementApplication.java`.

## 4. Swagger UI
Open http://localhost:8080/swagger-ui.html
OpenAPI JSON: http://localhost:8080/v3/api-docs
Expand an endpoint, click **Try it out**, enter parameters/body, then click **Execute**.

## 5. Example POST body
```json
{
  "name": "Samsung Galaxy S25",
  "description": "Samsung smartphone",
  "category": "Electronics",
  "brand": "Samsung",
  "price": 79999.00,
  "stockQuantity": 25,
  "rating": 4.5
}
```

## 6. Endpoints
- `POST /api/products` — create
- `GET /api/products` — list all
- `GET /api/products/{id}` — retrieve by ID
- `PUT /api/products/{id}` — update
- `DELETE /api/products/{id}` — delete
- `GET /api/products/search/name?name=Samsung`
- `GET /api/products/search/category?category=Electronics`
- `GET /api/products/search/brand?brand=Apple`
- `GET /api/products/search/price?min=50000&max=90000`
- `GET /api/products/search/category-brand?category=Electronics&brand=Samsung`
- `GET /api/products/search?keyword=Samsung`
- `GET /api/products/sort?sortBy=price&direction=DESC`
- `GET /api/products/filter?keyword=phone&category=Electronics&minPrice=10000&maxPrice=100000&page=0&size=10&sortBy=price&direction=ASC`

Allowed sort fields: `id`, `name`, `price`, `rating`, `category`, `brand`, `stockQuantity`. Direction: `ASC` or `DESC`. Responses also include `createdAt` and `updatedAt`, generated automatically by the application.

## Troubleshooting
- **Access denied:** verify MySQL username/password.
- **Unknown database:** run `CREATE DATABASE product_management;`.
- **Connection refused:** ensure MySQL Server is running on port 3306.
- **Port in use:** change `server.port`.
- **Swagger unavailable:** wait for startup to complete, then open `/swagger-ui.html`.
