package cn.didadu.controller;

import cn.didadu.dao.PersonMongoRepository;
import cn.didadu.domain.Location;
import cn.didadu.domain.Person4Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by jinggg on 16/4/25.
 */

@RestController
public class MongoDataController {

    @Autowired
    PersonMongoRepository personMongoRepository;


    @RequestMapping("/save4Mongo")
    public Person4Mongo save4Mongo(){
        Person4Mongo  p = new Person4Mongo("wyf",32);
        Collection<Location> locations =  new LinkedHashSet<Location>();
        Location loc1 = new Location("上海","2009");
        Location loc2 = new Location("合肥","2010");
        Location loc3 = new Location("广州","2011");
        Location loc4 = new Location("马鞍山","2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);

        return personMongoRepository.save(p);
    }

    @RequestMapping("/q14Mongo")
    public Person4Mongo q14Mongo(String name){
        return personMongoRepository.findByName(name);
    }

    @RequestMapping("/q24Mongo")
    public List<Person4Mongo> q24Mongo(Integer age){
        return personMongoRepository.withQueryFindByAge(age);
    }


}
