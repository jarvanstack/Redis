package com.bmft;

import redis.clients.jedis.Jedis;

/**
 * @Author Jarvan
 * @create 2020/8/14 11:02
 * 测试是否能连接成功远程 redis
 */
public class ConnectionTest {
    public static void main(String[] args) {
        //这里连接的是 c04 而且 6000 tcp ,udp 已经打开
        Jedis jedis = new Jedis("192.168.43.130", 6000);
//        jedis.auth("password");//如果没有密码这里可以省略

        System.out.println(jedis.ping());
    }
}
