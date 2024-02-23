package edu.zjnu.web.biz;

/**
 * @author: 杨海波
 * @date: 2022-12-15 10:06:05
 * @description: Message
 */
public class Message {

	String name;
	String text;

	public Message(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}


}
