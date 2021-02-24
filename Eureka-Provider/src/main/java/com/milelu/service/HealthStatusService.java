package com.milelu.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author MILELU
 * @date 2021/2/22 22:46
 */
@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status  = status;
    }

    @Override
    public Health health() {
        if (status){
            //如果是true 则启动
            return Health.up().build();
        }else {
            return Health.down().build();
        }
    }

    public String getStatus() {
        // TODO Auto-generated method stub
        return this.status.toString();
    }
}
