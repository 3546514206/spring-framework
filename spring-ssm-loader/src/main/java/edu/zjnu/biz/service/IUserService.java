package edu.zjnu.biz.service;

import edu.zjnu.biz.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @description: IUserService
 * @author: 杨海波
 * @date: 2022-05-19 08:59
 **/
public interface IUserService {

	/**
	 * @param id
	 */
	User getUserInfoById(Long id);

	/**
	 * @param id
	 * @return
	 */
	List<User> getUserVOS(long id);

	/**
	 * @param result
	 */
	void insert(Map<String, Object> result);

	/**
	 * @param user
	 */
	void updateById(User user);

	/**
	 * 比较版本差异
	 */
	List<User> compareMybatisVersion();
}
