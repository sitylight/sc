package com.dl.userconsumer.controller;

import com.dl.userconsumer.domain.User;
import com.dl.userconsumer.domain.dto.UserDTO;
import com.dl.userconsumer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lcb 2019/9/14
 */
@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumerController {
    private final UserService userService;
    @PostMapping("/users")
    public List<User> consume(@RequestBody final UserDTO userDTO) {
        return userService.users(userDTO.getIds());
    }
}
