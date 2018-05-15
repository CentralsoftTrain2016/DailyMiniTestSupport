package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ResultDao;
import db.UserDao;
import domain.Constant;
import domain.User;
import service.bean.ScoreListBean;

public class ScoreListService extends Service{

	private ResultDao resultDao;	// 結果
	private UserDao userDao;		// ユーザ

	@Override
	void prePare() {
		resultDao = new ResultDao(con);
		userDao = new UserDao(con);
	}

	// 点数一覧を取得
	public ScoreListBean getScoreList(int nowPage1, int flg){

		ScoreListBean scoreListBean = null;
		int start;
		int end;
		ScoreListBean test = null;

		start = (nowPage1 - 1) * Constant.PAGE_ITEMS + 1;
		end = nowPage1 * Constant.PAGE_ITEMS;

		try {

			// 日付降順(デフォルト)
			if(flg == 1){
				scoreListBean = resultDao.getScoreList(start, end);

			// 日付昇順
			}else if(flg == 2){
				scoreListBean = resultDao.getScoreListDateSortAsc(start, end);

			// 名前降順
			}else if(flg == 3){
				scoreListBean = resultDao.getScoreListNameSortDesc(start, end);

			// 名前昇順
			}else if(flg == 4){
				scoreListBean = resultDao.getScoreListNameSortAsc(start, end);
			}

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
		scoreListBean.setAllPage(allPage);
		scoreListBean.setNowPage(nowPage);
		scoreListBean.setItems(items);

		return scoreListBean;
	}



	// レコード数取得
	public int getRecordCount(){
		int recordCount = 0;	// レコード数
		try {
			recordCount = resultDao.getRecordCount();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return recordCount;
	}

	// ユーザリストを取得
	public List<User> getUserList() {

		ScoreListBean scoreListBean = new ScoreListBean();
		List<User> userList = new ArrayList<User>();

		try{
			userList = userDao.getUserList();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}

		return userList;
	}

	// 特定ユーザの点数一覧を取得
	public ScoreListBean getScoreList2(int nowPage1, User user){

		ScoreListBean scoreListBean = null;
		int start;
		int end;

		start = (nowPage1 - 1) * Constant.PAGE_ITEMS + 1;
		end = nowPage1 * Constant.PAGE_ITEMS;

		try {
			scoreListBean = resultDao.getScoreList2(start, end, user);
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
		scoreListBean.setAllPage(allPage);
		scoreListBean.setNowPage(nowPage);
		scoreListBean.setItems(items);

		return scoreListBean;
	}
}
