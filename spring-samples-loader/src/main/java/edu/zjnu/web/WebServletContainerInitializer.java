package edu.zjnu.web;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author: 杨海波
 * @date: 2022-12-15 11:46:37
 * @description: todo
 */
@HandlesTypes({DispatcherServlet.class})
public class WebServletContainerInitializer implements ServletContainerInitializer {


	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

		configurateServletContext(ctx);
	}

	private void configurateServletContext(ServletContext container) {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");
	}
}
