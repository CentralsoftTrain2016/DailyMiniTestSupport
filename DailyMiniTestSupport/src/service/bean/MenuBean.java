package service.bean;

import domain.User;

public class MenuBean extends Bean{

	public MenuBean(){
		super();
	}

	private User user;

	private Boolean isExistUnRease;


	public Boolean isExistUnRease() {
		return isExistUnRease;
	}

	public void setIsExistUnRease(Boolean isExistUnRease) {
		this.isExistUnRease = isExistUnRease;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
