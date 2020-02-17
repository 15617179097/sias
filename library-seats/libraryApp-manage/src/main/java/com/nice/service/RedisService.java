package com.nice.service;

public interface RedisService {
    public String setV(String key, String value);

    public String getV(String key);
}
