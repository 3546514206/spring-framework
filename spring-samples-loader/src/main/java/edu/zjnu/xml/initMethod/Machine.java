package edu.zjnu.xml.initMethod;

/**
 * @author: 杨海波
 * @date: 2022-12-16 15:02:26
 * @description: todo
 */
public class Machine {

	private String name;

	public Machine() {
		System.out.println("Machine's constructor!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void init() {
		System.out.println("Machine's init!");
	}

	public void destroy() {
		System.out.println("Machine's destroy!");
	}

}
