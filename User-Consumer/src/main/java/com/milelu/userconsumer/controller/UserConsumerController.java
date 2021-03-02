package com.milelu.userconsumer.controller;

import com.milelu.userconsumer.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/24 23:35
 */
@RestController
public class UserConsumerController {

    @Autowired
    UserApi api;

    @Value("${server.port}")
    String port;

    @GetMapping("/alive")
    public Map alive() {
        System.out.println("端口：" + port);

        return api.alive();
    }

    @GetMapping("/byId/{id}")
    public Map byId(@PathVariable("id") Integer id) {
        return api.byId(id);
    }

    @PostMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody Map<String, Object> accept) {
        return api.updateUser(accept);
    }
}
