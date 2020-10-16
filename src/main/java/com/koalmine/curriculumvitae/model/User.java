package com.koalmine.curriculumvitae.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    @Size(min = 1, max = 50, message = "Username must be between 1 - 50 characters long")
    private final String username;

    private final String name;
    private final String designation;
    private final String location;
    private final String email_id;
    private final String linked_in_id;
    private final String github_id;
}
