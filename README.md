# Shopping Application

Shopping is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:

## Building and Running the application

```
git clone https://github.com/SaraParaDev/shopping.git

cd shopping
mvn clean install
cd target
java -jar items-on-sale-0.0.1-SNAPSHOT.jar
```

You can then access the application using the below end points as mentioned in the swagger UI link below

## Swagger UI

Access the below end point for documentation on the API end points

http://localhost:8085/swagger-ui.html

## Database Configuration

In its default configuration, Shopping application uses an in-memory database (H2) which gets populated at startup with data. The h2 console is automatically exposed at http://localhost:8085/h2-console and it is possible to inspect the content of the database using the jdbc:h2:mem:testdb url.
 

## API End points

To monitor shopping application status:
```
GET /api/shopping/health
```
To generate Json Web Token using user id and password:
```
POST /api/shopping/auth/generate-token
```
To Get recommended items based on User orders, wish and hot deals: 

Pass the Jwt token generated from the /auth/generate-token endpoint with Authorization header

Example: Bearer tokenString

```
GET /api/shopping/recommendations/{userId}
```
## Prerequisites

The following items should be installed in your system:
* Java 8 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

# License

The Shopping application released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).