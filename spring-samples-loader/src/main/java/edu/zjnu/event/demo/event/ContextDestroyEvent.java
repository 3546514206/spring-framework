package edu.zjnu.event.demo.event;

/**
 * @description: ContextDestroyEvent
 * @author: 杨海波
 * @date: 2022-03-28 14:07
 **/
public class ContextDestroyEvent extends AbstractContextEvent {
	private static final long serialVersionUID = -6159391039546783872L;
	private final Object source;
	private long timestamp;

	public ContextDestroyEvent(Object source) {
		this.timestamp = System.currentTimeMillis();
		this.source = source;
	}

	public final long getTimestamp() {
		return this.timestamp;
	}

	public Object getSource() {
		return source;
	}
}
