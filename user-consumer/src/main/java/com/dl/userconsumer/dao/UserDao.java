package com.dl.userconsumer.dao;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.dl.userconsumer.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author lcb 2019/9/14
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDao {
    private final RestTemplate restTemplate;

    public User getUserById(Long id) {
        String url = "http://127.0.0.1:8002/user/get_by_id";
        JSONObject body = new JSONObject();
        body.put("id", id);
//         HttpUtil.createPost(url).body(body.toString()).execute();
        return restTemplate.postForObject(url, body, User.class);

    }

}
