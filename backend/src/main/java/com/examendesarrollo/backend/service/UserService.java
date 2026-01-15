package com.examendesarrollo.backend.service;

import java.util.Optional;
import com.examendesarrollo.backend.model.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    User save(User user);
}
