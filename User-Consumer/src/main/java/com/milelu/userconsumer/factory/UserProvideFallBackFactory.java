package com.milelu.userconsumer.factory;

import com.milelu.userconsumer.api.UserApi;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/28 0:23
 */
@Component
public class UserProvideFallBackFactory implements FallbackFactory<UserApi> {
    @Override
    public UserApi create(Throwable throwable) {
        return new UserApi() {
            @Override
            public Map alive() {
                Map map = new HashMap<>();
                if ( throwable instanceof HystrixTimeoutException){
                    map.put("timeout", "服务器连接超时，请稍后再试！！！");
                }else {
                    map.put("error", 500);
                }
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
        };
    }
}
