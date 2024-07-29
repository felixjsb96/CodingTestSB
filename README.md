# Reservas API

## Descripción

Esta API permite reservar un libro, validar un código de descuento y almacenar la información en una base de datos H2.

## Requisitos

- Java 11 o superior
- Maven
- H2

## Configuración

1. Clona el repositorio:
    ```bash
    git clone <https://github.com/felixjsb96/CodingTestSB.git>
    cd reservas-api
    ```

2. Configura la base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:h2:mem:reservas_db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
	spring.datasource.driverClassName=org.h2.Driver
	spring.datasource.username=sa
	spring.datasource.password=password
	spring.h2.console.enabled=true
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
