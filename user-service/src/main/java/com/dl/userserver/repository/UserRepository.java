package com.dl.userserver.repository;

import com.dl.userserver.domain.User;

import java.util.Optional;

/**
 * @author lcb 2019/9/14
 */
public interface UserRepository {
    Optional<User> findUserById(Long id);
}
