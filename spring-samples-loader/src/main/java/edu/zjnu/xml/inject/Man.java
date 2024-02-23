package edu.zjnu.xml.inject;

/**
 * @description: Person
 * @author: 杨海波
 * @date: 2022-01-26
 **/
public class Man {

	private String name;

	private Integer age;

//    public Person(String name) {
//        this.name = name;
//    }

	private Wife wife;

	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

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
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
