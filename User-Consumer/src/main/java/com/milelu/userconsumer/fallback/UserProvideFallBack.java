package com.milelu.userconsumer.fallback;

import com.milelu.userconsumer.api.UserApi;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/27 13:52
 */
@Component
public class UserProvideFallBack implements UserApi {
    @Override
    public Map alive() {
        Map<Object, Object> map = new HashMap<>();
        map.put("error", "请稍候再试");
        return map;
    }

    @Override
    public Map byId(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> updateUser(Map<String, Object> map) {
        return null;
    }
}
