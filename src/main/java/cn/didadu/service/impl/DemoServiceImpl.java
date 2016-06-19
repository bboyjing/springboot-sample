package cn.didadu.service.impl;


import cn.didadu.dao.PersonRepository;
import cn.didadu.domain.Person;
import cn.didadu.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	PersonRepository personRepository; //1
	
	@Transactional(rollbackFor={IllegalArgumentException.class}) //2
	public Person savePersonWithRollBack(Person person){
		Person p =personRepository.save(person);

		if(person.getName().equals("汪云飞")){
			throw new IllegalArgumentException("汪云飞已存在，数据将回滚"); //3
		}
		return p;
	}

	@Transactional(noRollbackFor={IllegalArgumentException.class}) //4
	public Person savePersonWithoutRollBack(Person person){
		Person p =personRepository.save(person);
		
		if(person.getName().equals("汪云飞")){
			throw new IllegalArgumentException("汪云飞虽已存在，数据将不会回滚");
		}
		return p;
	}

	/**
	 * 新增缓存
	 * @param person
	 * @return
	 */
	@Override
	@CachePut(value = "people", key = "#person.id")
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
		return p;
	}

	/**
	 * 从缓存中删除key
	 * @param id
	 */
	@Override
	@CacheEvict(value = "people")//2
	public void remove(Long id) {
		System.out.println("删除了id、key为"+id+"的数据缓存");
		//这里不做实际删除操作
	}

	/**
	 * 增加缓存
	 * @param person
	 * @return
	 */
	@Override
	@Cacheable(value = "people", key = "#person.id")//3
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
		return p;
	}

}
