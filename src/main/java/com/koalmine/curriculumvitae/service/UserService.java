package com.koalmine.curriculumvitae.service;

import com.koalmine.curriculumvitae.dao.UserDao;
import com.koalmine.curriculumvitae.model.User;
import com.koalmine.curriculumvitae.model.dto.SuccessDTO;
import com.koalmine.curriculumvitae.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("Makeshift-DB") UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDTO getUser(String username){
        return userDao.getUser(username);
    }

    public UserDTO[] getAllUsers(){
        return userDao.getAllUsers();
    }

    public UserDTO createUser(User user){
        return userDao.createUser(user);
    }

    public UserDTO updateUser(User user){
        getUser(user.getUsername());
        return userDao.updateUser(user);
    }

    public SuccessDTO deleteUser(String username){
        getUser(username);
        return userDao.deleteUser(username);
    }

    public int generateUsers(){
        return userDao.generateUsers();
    }
}
