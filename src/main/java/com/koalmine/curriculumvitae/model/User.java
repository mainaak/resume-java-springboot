package com.koalmine.curriculumvitae.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    @Size(min = 1, max = 50, message = "Username must be between 1 - 50 characters long")
    private final String username;

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 100, message = "Name must be between 1 - 100 characters long")
    private final String name;

    @NotBlank(message = "Designation cannot be blank")
    @NotNull(message = "Designation cannot be null")
    @Size(min = 1, max = 100, message = "Designation must be between 1 - 100 characters long")
    private final String designation;

    @NotBlank(message = "Location cannot be blank")
    @NotNull(message = "Location cannot be null")
    @Size(min = 1, max = 50, message = "Location must be between 1 - 50 characters long")
    private final String location;

    @NotBlank(message = "EmailId cannot be blank")
    @NotNull(message = "EmailId cannot be null")
    @Size(min = 1, message = "EmailId must be greater than 1 character long")
    @Email(message = "Email ID is not of valid format")
    private final String email_id;

    @NotBlank(message = "LinkedIn cannot be blank")
    @NotNull(message = "LinkedIn cannot be null")
    @Size(min = 1, message = "LinkedIn must be greater than 1 character long")
    private final String linked_in_id;

    @NotBlank(message = "GitHub cannot be blank")
    @NotNull(message = "GitHub cannot be null")
    @Size(min = 1, message = "GitHub must be greater than 1 character long")
    private final String github_id;
}
