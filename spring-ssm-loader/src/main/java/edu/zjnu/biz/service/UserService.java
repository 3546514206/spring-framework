package edu.zjnu.biz.service;

import edu.zjnu.biz.dao.IUserDao;
import edu.zjnu.biz.entity.User;
import edu.zjnu.biz.utils.NameUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description: IUserService
 * @author: 杨海波
 * @date: 2022-05-19 08:59
 **/
@Service
public class UserService implements IUserService {

	@Resource
	private IUserDao userDao;


	@Override
	public User getUserInfoById(Long id) {
		return userDao.getUserInfoById(id);
	}

	@Override
	public List<User> getUserVOS(long id) {
		return userDao.getUserVOS(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insert(Map<String, Object> result) {

		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setAge(18);
			user.setUuid(String.valueOf(UUID.randomUUID()));
			user.setName(NameUtil.getName());
			users.add(user);
		}

		userDao.insertBatch(users);

		result.put("users", users);
	}

	@Override
	public void updateById(User user) {
		userDao.updateById(user);
	}

	/**
	 *
	 */
	@Override
	public List<User> compareMybatisVersion() {
		Map<String, Object> param = new HashMap<>();
		param.put("blurName", "cat");
		return userDao.compareMybatisVersion(param);
	}

}
