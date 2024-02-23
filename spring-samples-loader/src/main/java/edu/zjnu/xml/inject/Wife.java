package edu.zjnu.xml.inject;

/**
 * @author: 杨海波
 * @date: 2022-12-13 17:31:17
 * @description: 老婆
 */
public class Wife {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Wife{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
