package edu.zjnu.annotation;

import edu.zjnu.xml.inject.Man;
import org.springframework.stereotype.Component;

/**
 * @description: PersonDao
 * @author: 杨海波
 * @date: 2022-01-27
 **/
@Component("personDao")
public class PersonDao implements IPersonDao {

	@Override
	public Man getPersonByName(String name, Integer age) {
//        Person person = new Person(name);
		Man man = new Man();
		man.setName(name);
		man.setAge(age);
		return man;
	}

	@Override
	public Man getDefaultUser() {
//        Person person = new Person("猪头三");
		Man man = new Man();
		man.setName("猪头三");
		man.setAge(18);
		return man;
	}
}
