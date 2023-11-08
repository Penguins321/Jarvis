package com.study.prictice.demos.demo.concurrence.juc.lock;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author ouyang    @Date 2023/10/19 0019
 * @Description
 * @menu
 */
public class Test {

    @Autowired
    private RedissonClient redissonClient;

    @org.junit.Test
    public void tes(){
        redissonClient.getLock("lock");
    }
}
