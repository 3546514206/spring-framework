package edu.zjnu.biz.service;

import edu.zjnu.biz.entity.Book;

import java.util.Map;

/**
 * @author: 杨海波
 * @date: 2023-01-09 14:34:12
 * @description: todo
 */
public interface IBookService {

	Book getBookById(Long id);

	/**
	 * 插入书籍
	 *
	 * @param result
	 */
	void insert(Map<String, Object> result);

	/**
	 * @param updateBook
	 */
	void updateById(Book updateBook);
}
