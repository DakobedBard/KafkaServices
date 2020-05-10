## Ecommerse fullstack application and event driven microservices architecture

This repository contains a Spring Boot Microservices application as well a front end website.

To run the application

##### Compile & run the full stack
mvn clean package 

docker-compose up 


##### Run the authentication service & login & receive JWT token 
java -jar authentication/target/authentication-0.1.0-SNAPSHOT.jar

 curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"email":"user@example.com","password":1234}' \
  http://localhost:8080/auth/login


##### Run the inventory service & seed the products database
java -jar product-service/target/product-service-0.0.1-SNAPSHOT.jar

Verify that the products mongo collection has been seed by hitting the get products API endpoint
curl localhost:8040/products

