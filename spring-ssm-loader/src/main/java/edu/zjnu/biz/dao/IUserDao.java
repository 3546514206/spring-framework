package edu.zjnu.biz.dao;

import edu.zjnu.biz.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description: IUserDao
 * @author: 杨海波
 * @date: 2022-05-19 09:21
 **/
@Repository
public interface IUserDao {

	/**
	 * @param id
	 * @return
	 */
	User getUserInfoById(@Param("id") Long id);

	/**
	 * @param id
	 * @return
	 */
	List<User> getUserVOS(@Param("id") Long id);

	/**
	 * @param users
	 */
	void insertBatch(@Param("users") List<User> users);

	/**
	 * @return
	 */
	List<User> selectAll();

	/**
	 * @param user
	 */
	void updateById(@Param("updateUser") User user);

	/**
	 * 对比mybtais版本差异
	 *
	 * @param param
	 */
	List<User> compareMybatisVersion(Map<String, Object> param);
}
