package com.koalmine.curriculumvitae.dao;

import com.koalmine.curriculumvitae.model.User;
import com.koalmine.curriculumvitae.model.dto.SuccessDTO;
import com.koalmine.curriculumvitae.model.dto.UserDTO;

public interface UserDao {
    UserDTO getUser(String username);
    UserDTO[] getAllUsers();
    UserDTO createUser(User user);
    UserDTO updateUser(User user);
    SuccessDTO deleteUser(String username);
    int generateUsers();
}
