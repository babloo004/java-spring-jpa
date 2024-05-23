# java-spring-jpa
# Spring JPA Example

This repository demonstrates the use of Spring JPA (Java Persistence API) to interact with a database in a simplified manner. The primary focus is on how Spring JPA makes database operations easier by abstracting the complexity of writing queries, allowing developers to define methods in a Domain Specific Language (DSL), which are then converted into JPQL (Java Persistence Query Language) and executed by the JPA EntityManager.


Spring JPA stands for the Java Persistence API. It simplifies database interactions by allowing developers to define repository interfaces that extend `JpaRepository`, which provides CRUD operations and other database interactions without the need to write boilerplate code. This example illustrates how to create and use JPA repositories, define custom query methods using DSL, and work with entities.


## Project Structure

```plaintext
.
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── avinash
│       │           └── SpringJPA
│       │               ├── SpringJpaApplication.java
│       │               ├── model
│       │               │   └── Student.java
│       │               └── repo
│       │                   └── StudentRepo.java
│       └── resources
│           ├── application.properties
└── README.md
```


### Prerequisites

- Java 11 or higher
- Maven



## Usage

After starting the application, you can test the repository methods by modifying the `SpringJpaApplication` class.

Example code to save a student and retrieve students by first name or marks:
```java
ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
Student s1 = context.getBean(Student.class);
s1.setRoll(322250);
s1.setFname("Rajesh");
s1.setLname("Mannepalli");
s1.setMarks(77);

StudentRepo repo = context.getBean(StudentRepo.class);
repo.save(s1);

System.out.println(repo.findByfname("Avinash"));
System.out.println(repo.findBymarks(95));
```

## Code Explanation

### `SpringJpaApplication.java`

This is the main class that bootstraps the Spring Boot application. It demonstrates how to create a `Student` object, set its properties, and save it to the database using `StudentRepo`.

### `model/Student.java`

This is the entity class mapped to a database table using the `@Entity` annotation. The `@Id` annotation denotes the primary key of the entity.

### `repo/StudentRepo.java`

This is the repository interface that extends `JpaRepository`. It provides methods for performing CRUD operations on the `Student` entity. Custom query methods are defined using DSL.

#### Custom Query Methods

- `List<Student> findByfname(String fname);`
- `List<Student> findBymarks(int marks);`

These methods use DSL to define queries that will be converted into JPQL and executed at runtime.

### `application.properties`

This file contains configuration properties for the Spring Boot application. It includes settings for the H2 database and JPA.

```properties
spring.application.name=RESTandJPA
spring.datasource.url=jdbc:mysql://localhost:3306/springjpa
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
