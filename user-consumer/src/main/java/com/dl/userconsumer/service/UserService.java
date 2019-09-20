package com.dl.userconsumer.service;

import cn.hutool.json.JSONObject;
import com.dl.userconsumer.dao.UserDao;
import com.dl.userconsumer.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lcb 2019/9/14
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserDao userDao;
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    @Value("${service-instance.name:user-service}")
    private String serviceName;

    public List<User> users(final List<Long> ids) {
        final List<User> users = new ArrayList<>(ids.size());

//        final List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        final ServiceInstance serviceInstance = instances.get(0);
//        final String baseUrl =
//                "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/get_by_id";

        final String baseUrl = "http://" + serviceName + "/user/get_by_id";
        final JSONObject jsonObject = new JSONObject();
        ids.forEach(id -> {
            jsonObject.put("id", id);
            final User user = restTemplate.postForObject(baseUrl, jsonObject, User.class);
            if (user != null) {
                users.add(user);
            }
//            final User user = userDao.getUserById(id);
//            if (user != null) {
//                users.add(user);
//            }
        });
        return users;
    }
}
