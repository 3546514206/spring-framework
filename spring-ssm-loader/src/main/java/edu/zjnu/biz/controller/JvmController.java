package edu.zjnu.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: 杨海波
 * @date: 2022-07-12 08:12
 **/
@Controller
@RequestMapping("/jvm")
public class JvmController {


	@RequestMapping("/test")
	public String getUser(Model model) {

		List<byte[]> list = new ArrayList<>();

		//int i = 0;
		while (true) {
			list.add(new byte[1024 * 1024]);
			//System.out.println(++i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


