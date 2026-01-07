package com.monu.productions_ready_features.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    private String name;


    private String email;

    private  Integer age;

     private String role;
    private   LocalDate dateOfJoining;
    private Boolean isActive;




}
