package com.milelu.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/21 17:41
 */
@RestController
public class ConsumerController {

    @Autowired
    EurekaClient client;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/client")
    public Map client() {
        Map map = new HashMap();
//        List<InstanceInfo> services = client.getInstancesById("localhost:provider:60");
        List<InstanceInfo> provider = client.getInstancesByVipAddress("provider", false);
        if (provider.size() > 0) {
            InstanceInfo instanceInfo = provider.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/hi";
                map.put("url", url);
                ResponseEntity<Object> forEntity = restTemplate.getForEntity(url, Object.class);
                map.put("myInfo", forEntity.getBody());
            }
        }
        return map;
    }

    /**
     * 轮询
     * @return
     */
    @GetMapping("/poll")
    public Map poll() {
        Map map = new HashMap();
        ServiceInstance instanceInfo = loadBalancerClient.choose("provider");
        String url = "http://" + instanceInfo.getHost() + ":" + instanceInfo.getPort() + "/hi";
        map.put("url", url);
        ResponseEntity<Object> forEntity = restTemplate.getForEntity(url, Object.class);
        map.put("myInfo", forEntity.getBody());
        return map;
    }

    /**
     * 自动获取URL
     *
     * @return
     */
    @GetMapping("/automaticProcessURL")
    public Map automaticProcessURL() {
        Map map = new HashMap();
        String url = "http://provider/hi";
        map.put("url", url);
        ResponseEntity<Object> forEntity = restTemplate.getForEntity(url, Object.class);
        map.put("myInfo", forEntity.getBody());
        return map;
    }
}
