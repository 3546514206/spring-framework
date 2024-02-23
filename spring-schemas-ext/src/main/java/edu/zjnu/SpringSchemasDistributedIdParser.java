package edu.zjnu;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author 杨海波
 * @date 2024/2/2 09:27
 * @description SpringSchemasDistributedIdParser
 */
public class SpringSchemasDistributedIdParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		// 解析xml内的标签
		String bizCode = element.getAttribute("bizCode");
		int length = Integer.parseInt(element.getAttribute("length"));
		String id = element.getAttribute("id");

		// 创建DistributedIdFactoryBean bean
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
		builder.getRawBeanDefinition().setBeanClass(DistributedIdFactoryBean.class);
		builder.setScope(BeanDefinition.SCOPE_SINGLETON);

		builder.addPropertyValue("bizCode", bizCode);
		builder.addPropertyValue("length", length);

		BeanDefinition beanDefinition = builder.getBeanDefinition();

		parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);

		return beanDefinition;
	}
}
