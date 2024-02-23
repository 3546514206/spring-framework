package edu.zjnu.biz.controller;

import edu.zjnu.biz.entity.Book;
import edu.zjnu.biz.entity.User;
import edu.zjnu.biz.service.IBookService;
import edu.zjnu.biz.service.IUserService;
import edu.zjnu.biz.utils.LocalDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 杨海波
 * @date: 2023-01-13 00:58:16
 * @description: 死锁演示
 */
@Controller
@RequestMapping("/deadLock")
public class DeadLockController {

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;

	@Autowired
	@Qualifier("userService")
	private IUserService userService;


	/**
	 * 事务一：
	 * 1》更新user表id=29的记录
	 * 2》更新book表id=29的记录
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/transactionOne")
	public String transactionOne(Model model) {
		// 更新user表id=29的记录(对改行记录上X锁)
		User updateUser = new User();
		updateUser.setId(29L);
		updateUser.setName("杨海波");
		updateUser.setAge(18);
		updateUser.setUuid("updateUser.transactionOne:" + LocalDateUtil.getLocalDateTimeStr());
		userService.updateById(updateUser);

		// 2》更新book表id=29的记录(也上X锁)
		Book updateBook = new Book();
		updateBook.setId(29L);
		updateBook.setName("《金瓶梅》");
		updateBook.setUuid("updateBook.transactionOne" + LocalDateUtil.getLocalDateTimeStr());
		bookService.updateById(updateBook);

		model.addAttribute("result", "transactionOne");
		return "result";
	}

	/**
	 * 事务一：
	 * 1》更新book表id=29的记录
	 * 2》更新user表id=29的记录
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/transactionTwo")
	public String transactionTwo(Model model) {
		// 1》更新book表id=29的记录(也上X锁)
		Book updateBook = new Book();
		updateBook.setId(29L);
		updateBook.setName("《嘻游记》");
		updateBook.setUuid("updateBook.transactionTwo" + LocalDateUtil.getLocalDateTimeStr());
		bookService.updateById(updateBook);


		// 2 更新user表id=29的记录(对改行记录上X锁)
		User updateUser = new User();
		updateUser.setId(29L);
		updateUser.setName("罗思雯");
		updateUser.setAge(16);
		updateUser.setUuid("updateUser.transactionTwo:" + LocalDateUtil.getLocalDateTimeStr());
		userService.updateById(updateUser);

		model.addAttribute("result", "transactionTwo");
		return "result";
	}


}
