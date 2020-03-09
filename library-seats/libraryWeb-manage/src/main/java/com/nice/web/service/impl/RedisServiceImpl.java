package com.nice.web.service.impl;

import com.nice.web.common.RedisClinet;
import com.nice.web.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisClinet jedisPool;

    /**
     * @Description 添加缓存
     * @Param key,value
     * @return
     **/
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
