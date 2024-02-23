package edu.zjnu.biz.entity;

/**
 * @description: Book 对象
 * @author: 杨海波
 * @date: 2022-09-05 15:34
 **/
public class Book {

	private Long id;

	private Long userId;

	private String uuid;

	private String name;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", userId=" + userId +
				", uuid='" + uuid + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
