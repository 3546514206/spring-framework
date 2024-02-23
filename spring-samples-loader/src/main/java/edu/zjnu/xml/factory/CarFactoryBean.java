package edu.zjnu.xml.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author: 杨海波
 * @date: 2022-12-16 09:38:59
 * @description: CarFactoryBean
 */
public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public Car getObject() {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return FactoryBean.super.isSingleton();
	}
}
