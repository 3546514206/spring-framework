package edu.zjnu.biz.controller;

import edu.zjnu.biz.entity.User;
import edu.zjnu.biz.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 描述
 * @author: 杨海波
 * @date: 2022-01-29
 **/

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	@RequestMapping("/getUserInfoById")
	public String getUser(Model model) {
		User user = userService.getUserInfoById(30L);
		model.addAttribute("user", user);
		return "user";
	}

	@RequestMapping("/compareMybatisVersion")
	public String compareMybatisVersion(Model model) {
		List<User> users = userService.compareMybatisVersion();
		model.addAttribute("user", users);
		return "user";
	}

	@RequestMapping("/getUserVO")
	public String getUserVO(Model model) {
		List<User> users = userService.getUserVOS(30L);
		model.addAttribute("userVO", users.get(0));
		return "relatedQuery";
	}
}
