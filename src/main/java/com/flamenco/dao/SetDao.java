package com.flamenco.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.flamenco.model.Set;

import redis.clients.jedis.Jedis;

@Repository
public class SetDao extends AbstractBaseRedisDao<String, Set> {

	/**  
     * 新增 
     *<br>------------------------------<br> 
     * @param user 
     * @return 
     */  
    public boolean add(final Set set) {
    	
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] key  = serializer.serialize(set.getId());  
                byte[] name = serializer.serialize(set.getName());
                return connection.setNX(key, name);  
            }  
        });  
        return result;  
    }
    
    /**  
     * 通过key获取 
     * <br>------------------------------<br> 
     * @param keyId 
     * @return 
     */  
    public Set get(final String keyId) {  
        Set result = redisTemplate.execute(new RedisCallback<Set>() {  
            public Set doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] key = serializer.serialize(keyId);  
                byte[] value = connection.get(key);  
                if (value == null) {  
                    return null;
                }  
                String name = serializer.deserialize(value);  
                return new Set(keyId, name, null);  
            }  
        });  
        return result;  
    }
}
