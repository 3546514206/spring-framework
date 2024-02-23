package edu.zjnu.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @description: todo
 * @author: 杨海波
 * @date: 2022-01-29
 **/

@Controller
@RequestMapping("/web")
public class WebLoaderController {

	@RequestMapping("/loader")
	public String loader(Model model) {
		Date date = new Date();
		model.addAttribute("date", date);

		return "success";
	}
}
