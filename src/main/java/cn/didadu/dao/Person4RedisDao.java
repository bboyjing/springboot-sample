package cn.didadu.dao;

import cn.didadu.domain.Person4Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by jinggg on 16/4/25.
 */

@Repository
public class Person4RedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //1

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valOpsStr; //3


    @Autowired
    RedisTemplate<Object, Object> redisTemplate; //2

    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps; //4

    public void stringRedisTemplateDemo(){ //5
        valOpsStr.set("xx", "yy");
    }


    public void save(Person4Redis person){ //6
        valOps.set(person.getId(),person);
    }

    public String getString(){//7
        return valOpsStr.get("xx");
    }

    public Person4Redis getPerson(){//8
        return (Person4Redis) valOps.get("1");
    }

}
