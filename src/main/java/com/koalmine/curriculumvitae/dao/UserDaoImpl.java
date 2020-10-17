package com.koalmine.curriculumvitae.dao;

import com.koalmine.curriculumvitae.exceptions.UserValidationException;
import com.koalmine.curriculumvitae.exceptions.UsernameAlreadyExistsException;
import com.koalmine.curriculumvitae.model.User;
import com.koalmine.curriculumvitae.model.dto.SuccessDTO;
import com.koalmine.curriculumvitae.model.dto.UserDTO;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("Makeshift-DB")
public class UserDaoImpl implements UserDao {

    private final List<User> USER_DB = new ArrayList<>();
    private static int count = 0;

    @Override
    public UserDTO getUser(String username) {
        Optional<User> userDto = USER_DB.stream().findFirst().filter(user -> user.getUsername().equals(username));
        if (userDto.isPresent())
            return new UserDTO(
                    userDto.get().getName(),
                    userDto.get().getDesignation(),
                    userDto.get().getLocation(),
                    userDto.get().getEmail_id(),
                    userDto.get().getLinked_in_id(),
                    userDto.get().getGithub_id()
            );
        throw new UserValidationException("User with the username " + username + " was not found");
    }

    @Override
    public UserDTO[] getAllUsers() {
        List<UserDTO> userDTO = new ArrayList<>();

        USER_DB.forEach(user -> userDTO.add(new UserDTO(
                user.getName(),
                user.getDesignation(),
                user.getLocation(),
                user.getEmail_id(),
                user.getLinked_in_id(),
                user.getGithub_id())
        ));
        return userDTO.toArray(new UserDTO[0]);
    }

    @Override
    public UserDTO createUser(User user) {
        USER_DB.forEach(user1 -> {
            if (user1.getUsername().equals(user.getUsername())){
                throw new UsernameAlreadyExistsException("Username " + user.getUsername() + " already exists!");
            }
        });
        USER_DB.add(user);
        return new UserDTO(user.getName(), user.getDesignation(), user.getLocation(), user.getEmail_id(), user.getLinked_in_id(), user.getGithub_id());
    }

    @Override
    public UserDTO updateUser(User user) {
        boolean removed = USER_DB.removeIf(u -> u.getUsername().equals(user.getUsername()));
        if (removed)
            LoggerFactory.getLogger(UserDaoImpl.class).info("User with username {} was found", user.getUsername());

        USER_DB.add(user);
        return new UserDTO(user.getName(), user.getDesignation(), user.getLocation(), user.getEmail_id(), user.getLinked_in_id(), user.getGithub_id());
    }

    @Override
    public SuccessDTO deleteUser(String username) {
        boolean removed = USER_DB.removeIf(u -> u.getUsername().equals(username));
        if (removed)
            LoggerFactory.getLogger(UserDaoImpl.class).info("User with username {} was found", username);

        return new SuccessDTO("SUCCESS", "User with username " + username + " was deleted");
    }

    @Override
    public int generateUsers() {
        USER_DB.add(new User(
                "gauranshi",
                "Gauranshi Sharma",
                "Student",
                "Kullu, Himachal Pradesh",
                "test_email@test.test",
                "LinkedIn.com/en/testid",
                "https://GitHub.com/test"
        ));
        count++;
        return count;
    }
}
