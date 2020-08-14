package com.example.r03;

import com.example.r03.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Jarvan
 * @create 2020/8/14 15:19
 */
@SpringBootTest
public class 工具类Test {
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.set("k5","工具类");
        System.out.println(redisUtil.get("k4"));
    }
}
