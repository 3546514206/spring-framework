package edu.zjnu;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 杨海波
 * @date 2024/2/2 09:33
 * @description DistributedIdFactoryBean
 */
public class DistributedIdFactoryBean implements InitializingBean, FactoryBean<DistributedIdComponent> {

	private String bizCode;
	private int length;

	private DistributedIdComponent distributedIdComponent;

	@Override
	public DistributedIdComponent getObject() throws Exception {
		return distributedIdComponent;
	}

	@Override
	public Class<?> getObjectType() {
		return DistributedIdComponent.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		distributedIdComponent = new DistributedIdComponent(bizCode, length);
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
