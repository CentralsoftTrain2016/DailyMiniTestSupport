package service.bean;

import domain.User;
import domain.value.Message;

public class NewUserBean extends Bean {
	public NewUserBean() {
		super();
	}

	private User user;
	private Message iDErrorMessage = new Message("");
	private Message nameErrorMessage = new Message("");
	private Message passwordErrorMessage = new Message("");

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getIDErrorMessage() {
		return iDErrorMessage;
	}

	public Message getNameErrorMessage() {
		return nameErrorMessage;
	}

	public Message getPasswordErrorMessage() {
		return passwordErrorMessage;
	}

	public void setIDErrorMessage(Message iDErrorMessage) {
		this.iDErrorMessage = iDErrorMessage;
	}

	public void setNameErrorMessage(Message nameErrorMessage) {
		this.nameErrorMessage = nameErrorMessage;
	}

	public void setPasswordErrorMessage(Message passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}
}
