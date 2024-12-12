package com.example.jparelationi.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "area should not be empty")
    private String area;
    @NotEmpty(message = "street should not be empty")
    private String street;
    @NotEmpty(message = "building number should not be empty")
    private String Building_number;
}
