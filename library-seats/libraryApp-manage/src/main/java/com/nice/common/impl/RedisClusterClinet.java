package com.nice.common.impl;

import com.nice.common.RedisClinet;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/*
 redisCluster单机版
 */
public class RedisClusterClinet implements RedisClinet {


    @Autowired
    private JedisPool JedisPool;

   /* private static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"47.94.104.224",6379,300,"root");
        Jedis resource = jedisPool.getResource();
        String ss = resource.get("ss");
        System.out.println(ss);
    }*/
    @Override
    public String set(String key, String value) {
        Jedis jedis = JedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    @Override
    public String get(String key) {
        Jedis jedis = JedisPool.getResource();
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    @Override
    public long hSet(String hname, String hkey, String value) {
        Jedis jedis = JedisPool.getResource();
        Long string = jedis.hset(hname, hkey, value);
        jedis.close();
        return string;
    }

    @Override
    public String hGet(String hname, String hkey) {
        Jedis jedis = JedisPool.getResource();
        String string = jedis.hget(hname, hkey);
        jedis.close();
        return string;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = JedisPool.getResource();
        Long string = jedis.incr(key);
        jedis.close();
        return string;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = JedisPool.getResource();
        Boolean exists = jedis.exists(key);
        jedis.close();
        return exists;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = JedisPool.getResource();
        Long string = jedis.expire(key, second);
        jedis.close();
        return string;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = JedisPool.getResource();
        Long string = jedis.ttl(key);
        jedis.close();
        return string;
    }

    @Override
    public long del(String key) {
        Jedis jedis = JedisPool.getResource();
        Long string = jedis.del(key);
        jedis.close();
        return string;
    }

    @Override
    public long hdel(String hname, String hkey) {
        Jedis jedis = JedisPool.getResource();
        Long string = jedis.hdel(hname, hkey);
        jedis.close();
        return string;
    }
}
