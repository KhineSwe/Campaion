package com.frobom.campanio.service;

import java.util.List;

import com.frobom.campanio.entity.User;
import com.frobom.campanio.web.error.InvalidTokenException;
import com.frobom.campanio.web.error.UserNotExistException;

public interface UserService {

    void save(User user);

    User findById(long id);

    List<User> findAll();

    User findByEmail(String email);

    void verifyUser(String token) throws InvalidTokenException;

    void createUserAndVerificationToken(User user, String token);

    void requestPasswordReset(String email, String token) throws UserNotExistException;

    void resetPassword(String token, String password) throws InvalidTokenException;


}
