package com.milelu.userconsumer.controller;

import com.milelu.userconsumer.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/alive")
    public Map alive() {
        return api.alive();
    }

    @GetMapping("/byId/{id}")
    public Map byId(@PathVariable("id") Integer id) {
        return api.byId(id);
    }
}
