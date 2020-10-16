package com.koalmine.curriculumvitae.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String designation;
    private String location;
    private String email_id;
    private String linked_in_id;
    private String github_id;
}
