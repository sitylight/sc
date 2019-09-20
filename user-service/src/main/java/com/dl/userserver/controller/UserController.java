package com.dl.userserver.controller;

import com.dl.userserver.domain.User;
import com.dl.userserver.domain.dto.UserDTO;
import com.dl.userserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcb 2019/9/14
 */
@Log4j2
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/get_by_id")
    public User queryById(@RequestBody final UserDTO userDTO) {
        log.debug("get user params: {}", userDTO);
        return userRepository.findUserById(userDTO.getId()).orElse(null);
    }
}
