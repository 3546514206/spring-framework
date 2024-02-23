package edu.zjnu;

/**
 * @author 杨海波
 * @date 2024/2/2 09:33
 * @description DistributedIdComponent
 */
public class DistributedIdComponent {
	private String bizCode;
	private int length;

	public DistributedIdComponent() {

	}

	public DistributedIdComponent(String bizCode, int length) {
		this.bizCode = bizCode;
		this.length = length;
	}

	public String generateId() {
		System.out.println("mock generate id");
		return String.valueOf(System.currentTimeMillis()).substring(0, length);
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
