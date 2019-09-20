package com.dl.userserver.repository.impl;

import com.dl.userserver.domain.User;
import com.dl.userserver.mapper.UserMapper;
import com.dl.userserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author lcb 2019/9/14
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MybatisUserRepository implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(userMapper.selectByPrimaryKey(id));
    }
}
