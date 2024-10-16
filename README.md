Steps to Run a Application 
Projects requirements - java 11 or more , Sts or Intellij and postman
Clone the Application in local . 
Import project as existing maven application 
Build the application with command "mvn clean install"
After the build is success .right click on the KeyvalueStoreApplication.class give run as springboot application 
After the Springboot started .
Open the postman and fllow the below steps 
Testing the Key-Value Store API
Now that the application is running, you can test the API using a tool like Postman or cURL.

Endpoints:
Create a Key-Value Pair (Optional TTL):
Method: POST
URL: http://localhost:8080/kvstore/create

Parameters:
key: The key string (max 32 chars).
value: The JSON object (max 16KB).
ttl: (Optional) Time-to-Live in seconds.

Example:
POST http://localhost:8080/kvstore/create?key=myKey&value=myValue&ttl=60

Example Request:
curl -X POST "http://localhost:8080/kvstore/create?key=testKey&value=testValue&ttl=60"

Read a Key-Value Pair:
Method: GET
URL: http://localhost:8080/kvstore/read/{key}
Example:
GET http://localhost:8080/kvstore/read/testKey

Example Request:
curl -X GET "http://localhost:8080/kvstore/read/testKey"

Delete a Key-Value Pair:
Method: DELETE
URL: http://localhost:8080/kvstore/delete/{key}
Example:
DELETE http://localhost:8080/kvstore/delete/testKey

Example Request:
curl -X DELETE "http://localhost:8080/kvstore/delete/testKey"
