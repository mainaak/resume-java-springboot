package com.koalmine.curriculumvitae.controller;

import com.koalmine.curriculumvitae.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin("*")
public class UserController {

    private final RestTemplate restTemplate;

    @Value("${base.url}")
    private String baseURL;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public UserDTO getUserInformation(){
        ResponseEntity<UserDTO> res = restTemplate.getForEntity(baseURL + "/user", UserDTO.class);
        return res.getBody();
    }
}
