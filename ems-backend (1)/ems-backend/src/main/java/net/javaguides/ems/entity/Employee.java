package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor  // Created For All Parameterized Constructor
@Entity   // To Specify a class As A JPA Entity
@Table(name="employees")   // To Specify Table Name . Hibernate is succesfully created employee table in DB
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Database Feature to Automatically Increment the Feature the Primary Key
    private Long id;
    @Column(name="first_name")// If u not specified column name jpa provide field name
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id" , nullable = false , unique = true)
    private String email;
}
