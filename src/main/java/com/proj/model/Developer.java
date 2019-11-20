package com.proj.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First name is mandatory")
    private String fname;

    @NotBlank(message = "Last name is mandatory")
    private String lname;

    @NotBlank(message = "Title is mandatory")
    private String title;

    private long salary;

    @NotBlank(message = "Location is mandatory")
    private String location;


}
