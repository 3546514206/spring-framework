package edu.zjnu.web;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;

/**
 * @author: 杨海波
 * @date: 2022-12-15 10:17:37
 * @description: todo
 */
public class TomcatStarter {
	private static int port = 8080;
	private static String contextPath = "/";

	public static void start() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		tomcat.setBaseDir(baseDir);
		tomcat.setPort(port);
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(port);
		tomcat.setConnector(connector);

		tomcat.addWebapp(contextPath, baseDir);
		tomcat.enableNaming();
		//手动创建
		//tomcat.getConnector();
		tomcat.start();
		tomcat.getServer().await();

	}

	public static void main(String[] args) throws IOException, LifecycleException {

		start();
	}
}
