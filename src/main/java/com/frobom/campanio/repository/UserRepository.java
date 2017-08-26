package com.frobom.campanio.repository;

import com.frobom.campanio.entity.User;

public interface UserRepository {

    void save(User user);

    User findByEmail(String email);

}
