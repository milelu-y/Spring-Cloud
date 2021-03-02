package com.milelu.userconsumer.api;

import com.milelu.Api;
import com.milelu.userconsumer.factory.UserProvideFallBackFactory;
import com.milelu.userconsumer.fallback.UserProvideFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/24 23:35
 */
@FeignClient(name = "user-provider",fallbackFactory = UserProvideFallBackFactory.class)
public interface UserApi extends Api {

}
