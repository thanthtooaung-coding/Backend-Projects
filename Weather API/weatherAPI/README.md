# Weather API

Weather API is a Spring Boot application that fetches and returns weather data from a third-party API. It utilizes Redis for caching to optimize performance and reduce the number of API calls. This application is ideal for developers looking to understand how to work with third-party APIs, caching mechanisms, and environment variables in a Spring Boot environment.

## Features
- **Fetch Weather Data**: Retrieves weather data for a specified city from Visual Crossing's API.
- **Caching with Redis**: Caches weather data using Redis to reduce the load on the third-party API and improve response times.
- **Error Handling**: Provides clear error messages when the API is unavailable or the city code is invalid.

## How to Use

### Run the Application:
1. Ensure you have Redis installed and running on `localhost:6379`.
2. Compile and run the Spring Boot application using Maven or your preferred IDE.

### Fetch Weather Data:
1. Make a GET request to `/weather/{city}` where `{city}` is the name of the city you want to retrieve the weather data for.
2. The API will return the current weather data for the specified city.

### Example Request:
```bash
curl http://localhost:8080/weather/NewYork
```

### Caching:
- The weather data for each city is cached in Redis for a certain duration to optimize performance. The cache is automatically invalidated after the expiration time.

### Error Handling:
- **Service Unavailable**: If the third-party API is down or unreachable, the API will return a `503 Service Unavailable` response.
- **Invalid City Code**: If the city code provided is invalid, the API will return an appropriate error message.

## Requirements
- Java 17 or higher
- Spring Boot 3.3.3
- Redis server running on localhost:6379

## Installation

### Clone the repository:
```bash
git clone https://github.com/thanthtooaung-coding/Backend-Projects
```

### Navigate to the project directory:
```bash
cd Backend-Projects/Weather API/weatherAPI
```

### Build and run the application:
```bash
./mvnw spring-boot:run
```

## License
This project is licensed under the [MIT License](../../LICENSE).