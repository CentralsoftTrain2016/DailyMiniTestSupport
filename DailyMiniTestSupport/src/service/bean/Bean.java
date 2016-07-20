package service.bean;

import domain.value.Message;

public class Bean {
	private Message message;
	public Bean()
	{
		message = new Message("");
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
