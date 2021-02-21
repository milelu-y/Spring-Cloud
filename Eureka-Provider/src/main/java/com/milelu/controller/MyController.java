package com.milelu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/21 17:10
 */
@RestController
public class MyController {

    final
    DiscoveryClient client;

    public MyController(DiscoveryClient client) {
        this.client = client;
    }

    @GetMapping("/hi")
    public Map hi() {
        Map map = new HashMap();
        map.put("name", "milelu");
        map.put("age", 18);
        return map;
    }

    @GetMapping("/client")
    public Map client(){
        Map map = new HashMap();
        List<String> services = client.getServices();
        map.put("services",services);
        map.put("description",client.description());
        map.put("order",client.getOrder());
        map.put("instances",client.getInstances("provider"));
        return map;
    }
}
