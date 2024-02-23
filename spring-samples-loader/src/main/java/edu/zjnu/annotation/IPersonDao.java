package edu.zjnu.annotation;

import edu.zjnu.xml.inject.Man;

/**
 * @description: IPersonDao
 * @author: 杨海波
 * @date: 2022-01-27
 **/
public interface IPersonDao {
	/**
	 * @param name
	 * @param age
	 * @return
	 */
	Man getPersonByName(String name, Integer age);

	Man getDefaultUser();
}
