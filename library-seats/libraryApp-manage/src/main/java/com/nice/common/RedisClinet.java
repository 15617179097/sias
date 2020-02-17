package com.nice.common;

public interface RedisClinet {
    String set(String key, String value);
    String get(String key);
    //集合
    long hSet(String hName, String hKey, String value);
    //获取hash
    String hGet(String hName, String hKey);
    //自增
    long incr(String key);
    //设置过期时间
    long expire(String key, int second);
    //查询失效时间
    long ttl(String key);
    //删除
    long del(String key);
    //删除hash
    long hdel(String hName, String hKey);
}
