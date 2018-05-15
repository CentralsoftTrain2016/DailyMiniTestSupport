package service;

import java.sql.SQLException;

import db.TestDao;
import db.ThemeDao;
import domain.Test;
import domain.ThemePeriod;
import domain.User;
import domain.value.Enum.CreateTestSubmitTypeEnum;
import service.bean.CreateTestBean;

public class CreateTestService extends Service {
 private ThemeDao themeDao ;
 private TestDao testDao ;


 @Override
	void prePare() {
	 themeDao = new ThemeDao(this.con);
	 testDao = new TestDao(this.con);
	}

	public void getTheme(CreateTestBean createTestBean2){
		ThemePeriod themeperiod;
		try {
			themeperiod = themeDao.getThemepriod();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//テーマピリオドにテーマリストが入って戻ってくる

		createTestBean2.getTest().setThemePeriod( themeperiod);
	}

	public CreateTestBean getUnreleasedTest(User user)
	{
		CreateTestBean ctb = new CreateTestBean();

		try {
			Test test =  testDao.getTestByUnrereased(user);
			ctb.setTest(test);
			getTheme(ctb);
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return ctb;
	}

	public String doSubmitAction(CreateTestSubmitTypeEnum submitType, CreateTestBean createTestBean, User user)
	{

		return submitType.doSubmitAction(createTestBean, con);

	}

	public void registTest(CreateTestBean createTestBean) {


	}

}
