package edu.zjnu.biz.dao;

import edu.zjnu.biz.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 杨海波
 * @date: 2023-01-09 14:36:07
 * @description: todo
 */
@Repository
public interface IBookDao {

	Book getBookById(@Param("id") Long id);

	void insertBatch(@Param("books") List<Book> splitBooks);

	void updateById(@Param("updateBook") Book updateBook);
}
