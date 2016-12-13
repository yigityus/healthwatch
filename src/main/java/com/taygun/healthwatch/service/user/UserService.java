package com.taygun.healthwatch.service.user;

import com.taygun.healthwatch.domain.User;
import com.taygun.healthwatch.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
