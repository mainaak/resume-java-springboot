package com.koalmine.curriculumvitae.controller;

import com.koalmine.curriculumvitae.exceptions.UserValidationException;
import com.koalmine.curriculumvitae.model.User;
import com.koalmine.curriculumvitae.model.dto.SuccessDTO;
import com.koalmine.curriculumvitae.model.dto.UserDTO;
import com.koalmine.curriculumvitae.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {

    private final RestTemplate restTemplate;
    private final UserService userService;

    @Value("${base.url}")
    private String baseURL;

    @Autowired
    public UserController(RestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    @GetMapping("{username}")
    public UserDTO getUserInformation(@PathVariable String username){
//        ResponseEntity<UserDTO> res = restTemplate.getForEntity(baseURL + "/user", UserDTO.class);
//        return res.getBody();
        return userService.getUser(username);
    }

    @GetMapping()
    public UserDTO[] getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("random")
    public int generateUsers(){
        return userService.generateUsers();
    }

    @PostMapping("user")
    public UserDTO createUser(@Valid @RequestBody User user){

        if (user.getUsername().contains(" "))
            throw new UserValidationException("Username cannot have spaces!");

        return userService.createUser(user);
    }

    @PutMapping("user")
    public UserDTO updateUser(@Valid @RequestBody User user){

        if (user.getUsername().contains(" "))
            throw new UserValidationException("Username cannot have spaces!");

        return userService.updateUser(user);
    }

    @DeleteMapping("user")
    public SuccessDTO deleteUser(@RequestBody Map<String, String> request){
        if (!request.containsKey("username")){
            throw new UserValidationException("Please check your request JSON");
        }
        return userService.deleteUser(request.get("username"));
    }
}
