package com.bmft;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author Jarvan
 * @create 2020/8/14 13:09
 * 测试事务手写
 */
public class MultiTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.43.130", 6000);
        jedis.flushDB();//清理数据库
        Transaction multi = jedis.multi();//开启事务
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "嘉文");
            jsonObject.put("age", "18");
            multi.set("k1", jsonObject.toJSONString());//放入队列
            multi.set("k2", jsonObject.toJSONString());
            //int i = 1/0;  ======= 在执行前异常就会因为事务而失败
            multi.exec();//执行

        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常，回滚
            multi.discard();
        } finally {
            System.out.println(jedis.get("k1"));
            System.out.println(jedis.get("k2"));
            jedis.close();//最后关闭连接 资源
        }


    }
}
