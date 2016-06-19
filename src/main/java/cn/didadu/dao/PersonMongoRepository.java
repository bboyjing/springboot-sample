package cn.didadu.dao;

import cn.didadu.domain.Person4Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by jinggg on 16/4/25.
 */
public interface PersonMongoRepository extends MongoRepository<Person4Mongo, String> {

    Person4Mongo findByName(String name);

    @Query("{'age': ?0}") List<Person4Mongo> withQueryFindByAge(Integer age);

}
