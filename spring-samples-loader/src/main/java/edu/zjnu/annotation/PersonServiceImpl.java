package edu.zjnu.annotation;

import edu.zjnu.xml.inject.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: PersonServiceImpl
 * @author: 杨海波
 * @date: 2022-01-27
 **/
@Service(value = "userService")
public class PersonServiceImpl {

	@Autowired
	private IPersonDao personDao;

	public Man getPersonByNameAndAge(String name, Integer age) {
		return personDao.getPersonByName(name, age);
	}

	public Man getDefaultUser() {
		return personDao.getDefaultUser();
	}
}
