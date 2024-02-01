# User Service

## Running the Application

To run the Spring Boot application using Gradle Wrapper, follow these steps:

1. Clone this repository to your local machine.
2. Navigate to the project directory in your terminal.
3. Build the application by running `./gradlew build`.
4. Start the application by running `./gradlew bootRun`.
5. The application will start and listen on port 8000 in development mode and port 9000 in production mode.

Alternatively, you can run the application using Docker. Follow these steps:

1. Ensure you have Docker installed on your machine.
2. Clone this repository to your local machine.
3. Navigate to the project directory in your terminal.
4. Build the Docker image by running `docker build -t users-service .`.
5. Once the image is built, run the Docker container by executing `docker run -p 8000:8000 users-service`.
  - When using a prod build (see `application.yml`) run the Docker container by executing `docker run -p 9000:9000 users-service`.

## API Endpoints

### Swagger API documentation
- [localhost:8000/swagger-ui/index.html](/http://localhost:8000/swagger-ui/index.html)

### Get User by ID

- Method: GET
- Path: /users/{id}
- Description: Returns the user with the given ID.
- Parameters:
  - id (integer, path, required): The ID of the user.

### Update User

- Method: PUT
- Path: /users/{id}
- Description: Updates the user with the given ID.
- Parameters:
  - id (integer, path, required): The ID of the user.
- Request Body:
  - Content Type: application/json
  - Schema: 
    ```json
    {
      "id": "integer",
      "name": "string",
      "firstName": "string",
      "email": "string"
    }
    ```
- Responses:
  - 200: OK

### Delete User

- Method: DELETE
- Path: /users/{id}
- Description: Deletes the user with the given ID.
- Parameters:
  - id (integer, path, required): The ID of the user.
- Responses:
  - 200: OK

### Get All Users

- Method: GET
- Path: /users
- Description: Returns a list of all users.
- Responses:
  - 200: OK

### Create User

- Method: POST
- Path: /users
- Description: Creates a new user.
- Request Body:
  - Content Type: application/json
  - Schema: 
    ```json
    {
      "name": "string", // not null
      "firstName": "string", // not null
      "email": "string" // not null, unique
    }
    ```
- Responses:
  - 200: OK

### Get Users By First Name

- Method: GET
- Path: /users/search
- Description: Returns a list of users by their first name.
- Parameters:
  - firstName (string, query, required): The first name of the user.
- Responses:
  - 200: OK
