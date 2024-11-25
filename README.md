# 🚘 Car Dealership Inventory Management API

This project is a **RESTful API** designed to manage a car dealership's inventory. It allows users to perform CRUD operations on car records, including searching for cars based on various criteria such as make, model, year, color, mileage, and price range.

## ✨ Key Features

- Perform CRUD operations on car records
- Search for cars based on make, model, year, color, mileage, and price range
- Efficient and scalable design using Spring Boot and Hibernate

## 🛠️ Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **MySQL**

## 🗂️ Project Structure

- **Controller**: Handles HTTP requests related to car operations such as creating, retrieving, updating, and deleting records.
- **Model**: Represents the car entity with attributes like VIN, make, model, year, color, mileage, and price.
- **Repository**: Extends `JpaRepository` to provide CRUD operations for the `Car` entity.
- **Service**: Provides business logic for car operations, including saving, retrieving, updating, and deleting car records.

## ⚙️ Prerequisites

- **Java 11** or higher
- **Maven**
- **MySQL**

## 🚀 Getting Started

1. **Clone the repository**:
   ```sh
   git clone https://github.com/sadramesbah/cars-inventory-api.git
   cd cars-inventory-api
    ```
  
2. **Set up the database**:
- create a database in MySQL
- Use the following SQL to create the **cars** table:
```sql
CREATE TABLE cars (
    car_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    car_vin VARCHAR(17) NOT NULL,
    car_make VARCHAR(50) NOT NULL,
    car_model VARCHAR(50) NOT NULL,
    car_year INT NOT NULL,
    car_color VARCHAR(20) NOT NULL,
    car_mileage INT NOT NULL,
    car_price DECIMAL(10, 2) NOT NULL
);
```
3. **Configure the application**
- update the `application.properties` with your database credentials and other configurations.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
spring.datasource.username={username}
spring.datasource.password={password}
spring.jpa.hibernate.ddl-auto=create-drop or validate
server.port={desired_port}
```

4. **Build and run the application**
```sh
mvn clean install
mvn spring-boot:run
```

5. **Access the API**
- The API will be available at: http://localhost:{server.port}/api/v1/cars

## 📄 API Endpoints

🆕 **Create a new car**
    
- `POST /api/v1/car`
- Request body:
  ```json
  {
    "vin": "1HGCM82633A004352",
    "make": "Honda",
    "model": "Accord",
    "year": 2020,
    "color": "Blue",
    "mileage": 15000,
    "price": 22000.00
  }
  ```

🔎 **Retrieve a car by ID**
- `GET /api/v1/car/{carId}`


📋 **Retrieve all cars**
- `GET /api/v1/cars`


✏️ **Update a car**
- `PUT /api/v1/car/{carId}`
- Request body: same as the create request body


❌ **Delete a car**
- `DELETE /api/v1/car/{carId}`


🔎 **Retrieve cars by make**
- `GET /api/v1/cars/make/{make}`


🔎 **Retrieve cars by model**
- `GET /api/v1/cars/model/{model}`


🔎 **Retrieve cars by year**
- `GET /api/v1/cars/year/{year}`


🔎 **Retrieve cars by color**
- `GET /api/v1/cars/color/{color}`


🔎 **Retrieve cars by price range**
- `GET /api/v1/cars/price/{minPrice}/{maxPrice}`


🔎 **Retrieve cars by mileage range**
- `GET /api/v1/cars/mileage/{minMileage}/{maxMileage}`


🔎 **Retrieve cars by make and model**
- `GET /api/v1/cars/make/{make}/model/{model}`


🔎 **Retrieve cars by make and year**
- `GET /api/v1/cars/make/{make}/year/{year}`


🔎 **Retrieve cars by make, model, and year**
- `GET /api/v1/cars/make/{make}/model/{model}/year/{year}`


🔎 **Retrieve cars by make and price range**
- `GET /api/v1/cars/make/{make}/price/{minPrice}/{maxPrice}`


🔎 **Retrieve cars by model and price range**
- `GET /api/v1/cars/model/{model}/price/{minPrice}/{maxPrice}`


🔎 **Retrieve cars by make, model, and price range**
- `GET /api/v1/cars/make/{make}/model/{model}/price/{minPrice}/{maxPrice}`
