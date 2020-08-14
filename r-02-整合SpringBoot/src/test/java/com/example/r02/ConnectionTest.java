package com.example.r02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author Jarvan
 * @create 2020/8/14 13:48
 */
@SpringBootTest
public class ConnectionTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test(){
        //这个一般只是操作数据，如果你想像之前一样控制刷新数据库需要获得connection对象
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        redisTemplate.opsForValue().set("k1","v1");
        System.out.println(redisTemplate.opsForValue().get("k1"));

    }
}
