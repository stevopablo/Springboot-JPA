# JPA Project – BookStore

## Project Description

This project was developed to demonstrate the use of **JPA (Java Persistence API)** for data management in a Java application.  
The main goal is to **persist, query, and manage data efficiently** using object-relational mapping (ORM).

The project includes examples of:

- Creating JPA entities.
- Relationships between tables (`OneToOne`, `OneToMany`, `ManyToOne`, `ManyToMany`).
- CRUD operations (Create, Read, Update, Delete) using **EntityManager**.
- Queries with **JPQL (Java Persistence Query Language)**.

---

## Technologies Used

- Java 21  
- JPA (Jakarta Persistence API)  
- Hibernate (JPA implementation)  
- Database: PostgreSQL / MySQL  

---

## Main JPA Annotations Used

| Annotation       | Purpose                                               |
|------------------|-------------------------------------------------------|
| `@Entity`        | Marks the class as a JPA entity                       |
| `@Table`         | Specifies the table name in the database              |
| `@Id`            | Defines the attribute as the primary key              |
| `@GeneratedValue`| Configures automatic generation of the primary key    |
| `@Column`        | Maps attributes to columns with options (name, size, nullable) |
| `@OneToOne`      | One-to-one relationship between entities              |
| `@OneToMany`     | One-to-many relationship between entities             |
| `@ManyToOne`     | Many-to-one relationship between entities             |
| `@ManyToMany`    | Many-to-many relationship between entities            |
| `@Transient`     | Ignores attributes that should not be persisted       |
