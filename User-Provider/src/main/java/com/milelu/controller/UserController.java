package com.milelu.controller;

import com.milelu.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/24 23:14
 */
@RestController
public class UserController implements Api {

    @Value("${server.port}")
    private String port;

    @Override
    public Map alive() {
        Map map = new HashMap();
        map.put("alive", 1);
        map.put("name", "麋了鹿");
        map.put("port", port);
        return map;
    }

    @Override
    public Map byId(Integer id) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("name", "麋了鹿");
        return map;
    }

    @Override
    public Map<String, Object> updateUser(Map<String, Object> accept) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", accept.get("name"));
        return map;
    }
}
