package com.milelu.controller;

import com.milelu.Api;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/24 23:14
 */
@RestController
public class UserController implements Api {

    @Override
    public Map alive() {
        Map map = new HashMap();
        map.put("alive", 1);
        map.put("name", "麋了鹿");
        return map;
    }

    @Override
    public Map byId(Integer id) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("name", "麋了鹿");
        return map;
    }
}
