package edu.zjnu;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author 杨海波
 * @date 2024/2/2 09:20
 * @description MySchemasExtNamespaceHandler
 */
public class SpringSchemasExtDistributedIdNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("distributed-id", new SpringSchemasDistributedIdParser());
	}
}
