package edu.zjnu.biz.controller;

import edu.zjnu.biz.entity.Book;
import edu.zjnu.biz.service.IBookService;
import edu.zjnu.biz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 杨海波
 * @date: 2023-01-09 14:32:21
 * @description: TransactionController
 */
@RequestMapping("/transaction")
@Controller
public class TransactionController {

	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@RequestMapping("/test")
	public String test(Model model) {
		Book book = bookService.getBookById(1L);
		model.addAttribute("result", book.toString());
		return "result";
	}

	@RequestMapping("/insert")
	public String insert(Model model) {
		Map<String, Object> result = new HashMap<>();
		userService.insert(result);
		model.addAttribute("result", result);
		return "result";
	}

	@RequestMapping("/insertBooks")
	public String insertBooks(Model model) {
		Map<String, Object> result = new HashMap<>();
		bookService.insert(result);
		model.addAttribute("result", result);
		return "result";
	}


}
