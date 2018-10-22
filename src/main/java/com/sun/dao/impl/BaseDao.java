package com.sun.dao.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class BaseDao {
      @Autowired
      private StringRedisTemplate redisTemplate;

      protected boolean existsKey(String key){
          boolean ret = false;
          if(StringUtils.isNotBlank(key)){
              ret =  redisTemplate.hasKey(key);
          }
          return ret;
      }

      protected long incr(String key){
         return incrValue(key,1L);
      }

      protected long incrValue(String key,long value){
          return redisTemplate.opsForValue().increment(key,value);
      }

      protected void setKeyExpire(String key,long seconds,TimeUnit unit){
          redisTemplate.expire(key,seconds, unit);
      }

      protected String get(String key){
          return redisTemplate.opsForValue().get(key);
      }

      protected void set(String key,String value){
          redisTemplate.opsForValue().set(key,value);
      }
}
