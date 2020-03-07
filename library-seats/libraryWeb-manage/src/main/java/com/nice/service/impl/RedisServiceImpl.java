package com.nice.service.impl;

import com.nice.common.RedisClinet;
import com.nice.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisClinet jedisPool;

    //添加缓存
    @Override
    public String setV(String key, String value) {
        //10小时过期时间
        jedisPool.expire(key, 50);
        return jedisPool.set(key,value);
    }

    //获取id
    @Override
    public String getV(String key) {
        return jedisPool.get(key);
    }

    //设置过期
    @Override
    public long expire(String key, int second) {
        return jedisPool.expire(key, 50);
    }

    //查看过期时间
    @Override
    public long ttl(String key) {
        return jedisPool.ttl(key);
    }

}
