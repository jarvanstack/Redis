package com.example.r03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author Jarvan
 * @create 2020/8/14 14:28
 * 测试自己的RedisTemplate覆盖官方的Template，
 * 通过配置类
 */
@SpringBootTest
public class TemplateTest01 {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("k1","v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));
    }
}
