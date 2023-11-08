package com.study.prictice.demos.demo.redis;

/**
 * @Author ouyang    @Date 2023/10/10 0010
 * @Description
 * @menu
 */

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonBloomFilterDemo {

    public static void main(String[] args) {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        RLock test = redisson.getLock("test");

        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("user");
        // 初始化布隆过滤器，预计统计元素数量为55000000，期望误差率为0.03
        bloomFilter.tryInit(55000000L, 0.03);
        bloomFilter.add("Tom");
        bloomFilter.add("Jack");
        System.out.println(bloomFilter.count());   //2
        System.out.println(bloomFilter.contains("Tom"));  //true
        System.out.println(bloomFilter.contains("Linda"));  //false
    }
}