package edu.zjnu.biz.service;

import edu.zjnu.biz.dao.IBookDao;
import edu.zjnu.biz.dao.IUserDao;
import edu.zjnu.biz.entity.Book;
import edu.zjnu.biz.entity.User;
import edu.zjnu.biz.utils.NameUtil;
import edu.zjnu.biz.utils.SplitListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: 杨海波
 * @date: 2023-01-09 14:34:46
 * @description: BookService
 */
@Service
public class BookService implements IBookService {

	@Resource
	private IUserDao userDao;

	@Resource
	private IBookDao bookDao;

	@Transactional
	@Override
	public Book getBookById(Long id) {
		return bookDao.getBookById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insert(Map<String, Object> result) {
		List<User> users = userDao.selectAll();
		List<Book> books = new ArrayList<>();
		for (User user : users) {
			for (int i = 0; i < 100; i++) {
				Book book = new Book();
				book.setUuid(String.valueOf(UUID.randomUUID()));
				book.setName("《" + NameUtil.getName() + "》");
				book.setUserId(user.getId());
				books.add(book);
			}
		}

		List<List<Book>> splitBookList = SplitListUtil.split(books, 10);
		for (List<Book> splitBooks : splitBookList) {
			bookDao.insertBatch(splitBooks);
		}

		result.put("result", books);
	}

	@Override
	public void updateById(Book updateBook) {
		bookDao.updateById(updateBook);
	}
}
