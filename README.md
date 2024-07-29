# Reservas API

## Descripción

Esta API permite reservar una casa, validar un código de descuento y almacenar la información en una base de datos PostgreSQL.

## Requisitos

- Java 11 o superior
- Maven
- PostgreSQL

## Configuración

1. Clona el repositorio:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd reservas-api
    ```

2. Configura la base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/reservas
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. Construye y ejecuta la aplicación:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

### Crear una reserva

- **URL**: `/api/reservations`
- **Método**: `POST`
- **Cuerpo de la solicitud**:
    ```json
    {
        "userId": "123",
        "houseId": "456",
        "discountCode": "DISCOUNT10"
    }
    ```

- **Ejemplo de respuesta**:
    ```json
    {
        "id": 1,
        "userId": "123",
        "houseId": "456",
        "discountCode": "DISCOUNT10",
        "reservationDate": "2024-07-28",
        "discountValid": true
    }
    ```

## Pruebas

Para ejecutar las pruebas unitarias, usa:
```bash
mvn test
