Key-Value Store (Spring Boot)
This project is a simple Key-Value Store implemented in Spring Boot, supporting basic CRUD operations (Create, Read, Delete) with TTL (Time-to-Live) functionality. The key-value pairs are stored locally in a file-based system. This API allows users to add key-value pairs with optional TTL, retrieve values, and delete entries.

Project Requirements
Java 11 or higher
STS (Spring Tool Suite) or IntelliJ IDEA
Postman (or cURL) for API testing
How to Run the Application
1. Clone the Application Locally
Clone the Git repository to your local machine:

2. Import the Project as an Existing Maven Project
Open your IDE (STS or IntelliJ IDEA).
Go to File → Import → Existing Maven Projects.
Browse to the directory where the project was cloned and select the pom.xml file.


4. Build the Application
Open a terminal or command prompt in your project root and run the following Maven command:

"mvn clean install"

This command will compile the project, download dependencies, and run unit tests.

4. Run the Application
After a successful build, right-click on the KeyValueStoreApplication.java file in your IDE.
Select Run As → Spring Boot Application.
Once started, the application will run on port 8080 by default.

Testing the Key-Value Store API
You can test the API using Postman or cURL. Below are the supported endpoints:

Endpoints:
1. Create a Key-Value Pair (with optional TTL)
Method: POST
URL: http://localhost:8080/kvstore/create
Parameters:
key: The key string (max 32 chars).
value: The JSON object (max 16KB).
ttl: (Optional) Time-to-Live in seconds.
Example Request:
curl -X POST "http://localhost:8080/kvstore/create?key=myKey&value=myValue&ttl=60"

2. Read a Key-Value Pair
Method: GET
URL: http://localhost:8080/kvstore/read/{key}
Example Request:
curl -X GET "http://localhost:8080/kvstore/read/testKey"

3. Delete a Key-Value Pair
Method: DELETE
URL: http://localhost:8080/kvstore/delete/{key}
Example Request:
curl -X DELETE "http://localhost:8080/kvstore/delete/testKey"


Project Structure
KeyValueStoreApplication.java: Main class to run the Spring Boot application.
KvStoreController.java: Handles the API requests (POST, GET, DELETE).
KvStoreService.java: Implements the business logic for managing the key-value pairs.
KvStoreRepository.java: Manages the persistence of key-value pairs in the local file system.


Notes
The application uses a local file-based storage solution for persisting key-value pairs.
TTL (Time-to-Live) functionality is supported, and the system automatically removes expired keys.
Thread-safe access is ensured, allowing concurrent access in a single client environment.
