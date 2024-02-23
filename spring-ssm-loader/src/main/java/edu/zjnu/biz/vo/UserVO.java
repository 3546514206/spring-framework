package edu.zjnu.biz.vo;

/**
 * @description: UserVO
 * @author: 杨海波
 * @date: 2022-09-05 15:36
 **/
public class UserVO {

	private Long id;

	private String name;

	private Integer age;

	private Long bookId;

	private String bookName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "UserVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", bookId=" + bookId +
				", bookName='" + bookName + '\'' +
				'}';
	}
}
