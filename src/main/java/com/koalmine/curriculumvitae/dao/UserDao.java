package com.koalmine.curriculumvitae.dao;

import com.koalmine.curriculumvitae.model.User;
import com.koalmine.curriculumvitae.model.dto.UserDTO;

public interface UserDao {
    UserDTO getUser(String username);
    UserDTO[] getAllUsers();
    UserDTO createUser(User user);
    int generateUsers();
}
