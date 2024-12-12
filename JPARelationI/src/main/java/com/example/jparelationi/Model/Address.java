package com.example.jparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(100) not null")
    private String area;
    @Column(columnDefinition = "varchar(100) not null")
    private  String street;
    @Column(columnDefinition = "varchar(100) not null")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;



}
