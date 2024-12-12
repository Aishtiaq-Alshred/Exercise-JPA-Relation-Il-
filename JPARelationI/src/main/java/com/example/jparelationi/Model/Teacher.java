package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be null")
    @Column(columnDefinition = "varchar(255) not null")
    private String name;
    @NotNull(message = "age should not be null")
    @Positive(message = "age should be number")
    @Column(columnDefinition = "int not null check(age>0)")
    private Integer age;
    @NotNull(message = "email should not be null")
    @Email(message = "should be valid email")
    @Column(columnDefinition = "varchar(255) not null unique")
    private String email;
    @NotNull(message = "salary should not be null")
    @Positive(message = "salary must be positive")
    @Column(columnDefinition = "int not null check(salary>0)")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;
}
