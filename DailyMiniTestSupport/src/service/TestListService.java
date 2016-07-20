package service;

import java.sql.SQLException;

import db.TestDao;
import domain.Constant;
import service.bean.TestListBean;

public class TestListService extends Service{

	private TestDao testDao;

	@Override
	void prePare() {
		testDao = new TestDao(con);
	}

	public TestListBean getTestList(int nowPage1) {

		TestListBean testListBean = null;
		int start;
		int end;

		start = (nowPage1 - 1) * Constant.PAGE_ITEMS + 1;
		end = nowPage1 * Constant.PAGE_ITEMS;

		try {
			testListBean = testDao.getTestList(start, end);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		int nowPage;			// 最初だけ1ページ目
		int allPage;

		nowPage = nowPage1;

		// レコード数を取得
		int items = getRecordCount();

		// 全ページ数を求める
		allPage = items / Constant.PAGE_ITEMS;
		if(allPage == 0){
			allPage = 1;
		}

		// ビーンに値をセット
		testListBean.setAllPage(allPage);
		testListBean.setNowPage(nowPage);
		testListBean.setItems(items);

		return testListBean;
	}

	// レコード数取得
	public int getRecordCount(){
		int recordCount = 0;	// レコード数
		try {
			recordCount = testDao.getRecordCount();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return recordCount;
	}

}
