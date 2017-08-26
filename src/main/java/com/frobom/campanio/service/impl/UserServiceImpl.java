package com.frobom.campanio.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frobom.campanio.entity.Role;
import com.frobom.campanio.entity.User;
import com.frobom.campanio.entity.VerificationToken;
import com.frobom.campanio.repository.RoleRepository;
import com.frobom.campanio.repository.UserRepository;
import com.frobom.campanio.repository.VerificationTokenRepository;
import com.frobom.campanio.service.UserService;
import com.frobom.campanio.web.error.InvalidTokenException;
import com.frobom.campanio.web.error.UserNotExistException;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User findById(long id) {
        return null;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return null;
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void verifyUser(String token) throws InvalidTokenException {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            throw new InvalidTokenException();
        }
        verificationToken.updateToken(UUID.randomUUID().toString());
        // update?
        User user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void createUserAndVerificationToken(User user, String token) {
        Role role = roleRepository.getDefaultRole();
        user.setRole(role);
        userRepository.save(user);
        VerificationToken verificationToken = new VerificationToken(token, user);
        tokenRepository.save(verificationToken);
    }

    @Override
    @Transactional
    public void resetPassword(String token, String password) throws InvalidTokenException {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken != null) {
            User user = verificationToken.getUser();
            user.setPassword(password);
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public void requestPasswordReset(String email, String token) throws UserNotExistException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotExistException();
        }
        VerificationToken verificationToken = new VerificationToken(token, user);
        tokenRepository.save(verificationToken);
    }

}
