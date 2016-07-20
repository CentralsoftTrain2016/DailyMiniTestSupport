package service;

import db.ResultDao;
import db.UserDao;
import service.bean.TestBean;

public class TestService extends Service{

	private ResultDao resultDao;
	private UserDao userDao;

	@Override
	void prePare() {
		resultDao = new ResultDao(con);
		userDao = new UserDao(con);
	}

	public TestBean getTestDetail(){

		TestBean testBean = new TestBean();

		return testBean;
	}

}
