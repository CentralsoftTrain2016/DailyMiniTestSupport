package service;

import java.sql.SQLException;

import db.TestDao;
import domain.Test;
import domain.User;

public class MenuService extends Service{

	private TestDao testDao;

	@Override
	void prePare() {
		testDao = new TestDao(con);
	}

	public boolean isExistUnreleasedTest(User user) {

		boolean flg = false;

		try {
			Test test = testDao.getUnreleasedTest(user);

			// テストを作成中ならtrueにする
			if(test != null){
				flg = true;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return flg;
	}

}
