package cn.didadu.controller;

import cn.didadu.dao.Person4RedisDao;
import cn.didadu.domain.Person4Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinggg on 16/4/25.
 */
@RestController
public class RedisController {

    @Autowired
    Person4RedisDao person4RedisDao;

    @RequestMapping("/set") //1
    public void set(){
        Person4Redis person = new Person4Redis("1","wyf", 32);
        person4RedisDao.save(person);
        person4RedisDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr") //2
    public String getStr(){
        return person4RedisDao.getString();
    }

    @RequestMapping("/getPerson") //3
    public Person4Redis getPerson(){
        return person4RedisDao.getPerson();
    }

}
