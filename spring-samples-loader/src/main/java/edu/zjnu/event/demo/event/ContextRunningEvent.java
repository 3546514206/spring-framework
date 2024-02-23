package edu.zjnu.event.demo.event;

/**
 * @description: ContextRunningEvent
 * @author: 杨海波
 * @date: 2022-03-28 14:06
 **/
public class ContextRunningEvent extends AbstractContextEvent {
	private static final long serialVersionUID = -6159391039546783874L;

	private long timestamp;

	private Object source;

	public ContextRunningEvent(Object source) {
		this.timestamp = System.currentTimeMillis();
		this.source = source;
	}

	public final long getTimestamp() {
		return this.timestamp;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}
}
