package com.nice.service.impl;

import com.nice.common.RedisClinet;
import com.nice.common.impl.RedisClusterClinet;
import com.nice.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisClinet jedisPool;

    @Override
    public String setV(String key, String value) {
        return jedisPool.set(key,value);
    }

    @Override
    public String getV(String key) {
        return jedisPool.get(key);
    }

    @Override
    public long expire(String key, int second) {
        return jedisPool.expire(key, 50);
    }

}
