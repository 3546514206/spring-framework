package edu.zjnu.biz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: EnvironmentAware
 * @author:
 * @date: 2022-01-31
 **/
@Controller
@RequestMapping("/env")
public class EnvironmentController implements EnvironmentAware {

	private Environment environment = null;

	@RequestMapping("/toEnv")
	public String toEnvAware(Model model) {
		System.out.println(environment.toString());
		String environmentString = JSON.toJSONString(environment,
				SerializerFeature.PrettyFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat);
		model.addAttribute("environment", environmentString);
		return "env";
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
