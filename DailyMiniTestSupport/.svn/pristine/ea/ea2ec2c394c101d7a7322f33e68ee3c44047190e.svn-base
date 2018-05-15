package service;


import db.UserDao;
import domain.User;
import domain.value.LoginUserName;
import domain.value.Password;
import service.bean.LoginBean;
import java.sql.SQLException;

public class LoginService extends Service{

	private UserDao userDao;


	@Override
	void prePare() {
		userDao = new UserDao(this.con);
	}

	public void createUser(User user){
		//userDao = new UserDao(this.con);
		userDao.userCreate(user); //DBnitouroku
	}

	public LoginBean getUserByLoginUserNameAndPassword(LoginUserName loginUserName, Password password) {

		LoginBean loginBean = new LoginBean();
		User user;

		try {
			user = userDao.getUserByLoginUserNameAndPassword(loginUserName, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		loginBean.setUser(user);

		return loginBean;
	}
}
