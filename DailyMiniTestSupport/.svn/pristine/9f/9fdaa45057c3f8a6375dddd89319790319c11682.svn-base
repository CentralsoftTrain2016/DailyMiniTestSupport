package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Result;
import domain.Test;
import domain.User;
import domain.value.Score;
import domain.value.UserName;
import domain.value.date.AnswerDate;
import domain.value.id.ResultID;
import domain.value.id.TestID;
import domain.value.id.UserID;
import service.bean.ScoreListBean;

public class ResultDao extends Dao{

	public ResultDao(Connection con) {
		super(con);
	}

//-----------------------------------------------------------------------------------------------------------------

	// レコード数取得
	private static final String SELECT_RECORD_COUNT =
			  "SELECT "
			+ "  RESULTID "
			+ "FROM "
			+ "  RESULT "
			;

	public int getRecordCount() throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		Result result = null;
		int count = 0;

		  try{
			stmt = con.prepareStatement(SELECT_RECORD_COUNT);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next()){
		    	result = new Result();
		    	count = rset.getInt(1);
			}

		}finally{
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
		return count;
	}

//-----------------------------------------------------------------------------------------------------------------

	// 点数の一覧を取得
	private static final String SELECT_SCORELIST =
			  "SELECT "
			+ "  * "
			+ "FROM "
			+ "  ( "
			+ "   SELECT "
			+ "     ROWNUM ROWNUMBER "
			+ "   , tbl.RESULTID "
			+ "   , tbl.TESTID "
			+ "   , tbl.USERID "
			+ "   , tbl.SCORE "
			+ "   , tbl.ANSWERDATE "
			+ "   , tbl.USERNAME "
			+ "  FROM "
			+ "    ( "
			+ "     SELECT "
			+ "       RESULT.RESULTID "
			+ "     , TEST.TESTID "
			+ "     , USERS.USERID "
			+ "     , RESULT.SCORE "
			+ "     , RESULT.ANSWERDATE "
			+ "     , USERS.USERNAME "
			+ "     FROM "
			+ "       RESULT "
			+ "     , TEST "
			+ "     , USERS "
			+ "     WHERE "
			+ "       RESULT.USERID = USERS.USERID "
			+ "         AND "
			+ "       RESULT.TESTID = TEST.TESTID "
			+ "     ORDER BY "
			+ "       RESULT.ANSWERDATE DESC "
			+ "     , USERS.USERNAME DESC "
			+ "    ) "
			+ "    tbl "
			+ "  ) "
			+ "  tblx "
			+ "WHERE "
			+ "  ROWNUMBER BETWEEN ? AND ? "
			;

	public ScoreListBean getScoreList(int start, int end) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		ScoreListBean scoreListBean = new ScoreListBean();
		Result result = null;
		User user = null;
		Test test = null;

		List<Result> resultList = new ArrayList<Result>();

		try{
			stmt = con.prepareStatement(SELECT_SCORELIST);
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
		    		result = new Result();
		    		user = new User();
		    		test = new Test();

					result.setResultid(new ResultID(rset.getString(2)));
					test.setTestID(new TestID(rset.getString(3)));
					user.setUserid(new UserID(rset.getString(4)));
					result.setScore(new Score(rset.getInt(5)));
					result.setAnswerDate(new AnswerDate(rset.getString(6)));
					user.setUsername(new UserName(rset.getString(7)));
					result.setUser(user);
					resultList.add(result);
					scoreListBean.setResultList(resultList);
				}
		}

		finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}

		return scoreListBean;

	}

//-----------------------------------------------------------------------------------------------------------------

	// 特定ユーザの点数一覧を取得
	public ScoreListBean getScoreList2(int start, int end, User user) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		ScoreListBean scoreListBean = new ScoreListBean();
		Result result = null;
//		User user = null;
		Test test = null;

		List<Result> resultList = new ArrayList<Result>();

		try{
			stmt = con.prepareStatement(SELECT_SCORELIST + "AND User.UserID = ? ");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			stmt.setString(3, user.getUserid().toString());

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
		    		result = new Result();
		    		user = new User();
		    		test = new Test();

					result.setResultid(new ResultID(rset.getString(2)));
					test.setTestID(new TestID(rset.getString(3)));
					user.setUserid(new UserID(rset.getString(4)));
					result.setScore(new Score(rset.getInt(5)));
					result.setAnswerDate(new AnswerDate(rset.getString(6)));
					resultList.add(result);
					scoreListBean.setResultList(resultList);
				}
		}

		finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}

		return scoreListBean;
	}

//-----------------------------------------------------------------------------------------------------------------

	// 日付の昇順にソート
	private static final String SELECT_SCORELIST_DATE_SORT_ASC =
			  "SELECT "
			+ "  * "
			+ "FROM "
			+ "  ( "
			+ "   SELECT "
			+ "     ROWNUM ROWNUMBER "
			+ "   , tbl.RESULTID "
			+ "   , tbl.TESTID "
			+ "   , tbl.USERID "
			+ "   , tbl.SCORE "
			+ "   , tbl.ANSWERDATE "
			+ "   , tbl.USERNAME "
			+ "  FROM "
			+ "    ( "
			+ "     SELECT "
			+ "       RESULT.RESULTID "
			+ "     , TEST.TESTID "
			+ "     , USERS.USERID "
			+ "     , RESULT.SCORE "
			+ "     , RESULT.ANSWERDATE "
			+ "     , USERS.USERNAME "
			+ "     FROM "
			+ "       RESULT "
			+ "     , TEST "
			+ "     , USERS "
			+ "     WHERE "
			+ "       RESULT.USERID = USERS.USERID "
			+ "         AND "
			+ "       RESULT.TESTID = TEST.TESTID "
			+ "     ORDER BY "
			+ "       RESULT.ANSWERDATE ASC "
			+ "      , USERS.USERNAME ASC "
			+ "    ) "
			+ "    tbl "
			+ "  ) "
			+ "  tblx "
			+ "WHERE "
			+ "  ROWNUMBER BETWEEN ? AND ? "
			;

	public ScoreListBean getScoreListDateSortAsc(int start, int end) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		ScoreListBean scoreListBean = new ScoreListBean();
		Result result = null;
		User user = null;
		Test test = null;

		List<Result> resultList = new ArrayList<Result>();

		try{
			stmt = con.prepareStatement(SELECT_SCORELIST_DATE_SORT_ASC);
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
				   	result = new Result();
				   	user = new User();
				   	test = new Test();

					result.setResultid(new ResultID(rset.getString(2)));
					test.setTestID(new TestID(rset.getString(3)));
					user.setUserid(new UserID(rset.getString(4)));
					result.setScore(new Score(rset.getInt(5)));
					result.setAnswerDate(new AnswerDate(rset.getString(6)));
					user.setUsername(new UserName(rset.getString(7)));
					result.setUser(user);
					resultList.add(result);
					scoreListBean.setResultList(resultList);
				}

		}finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
		return scoreListBean;
	}

//-----------------------------------------------------------------------------------------------------------------

	// 日付が降順で名前の降順にソート
	private static final String SELECT_SCORELIST_NAME_SORT_DESC =
					"SELECT "
					+ "  * "
					+ "FROM "
					+ "  ( "
					+ "   SELECT "
					+ "     ROWNUM ROWNUMBER "
					+ "   , tbl.RESULTID "
					+ "   , tbl.TESTID "
					+ "   , tbl.USERID "
					+ "   , tbl.SCORE "
					+ "   , tbl.ANSWERDATE "
					+ "   , tbl.USERNAME "
					+ "  FROM "
					+ "    ( "
					+ "     SELECT "
					+ "       RESULT.RESULTID "
					+ "     , TEST.TESTID "
					+ "     , USERS.USERID "
					+ "     , RESULT.SCORE "
					+ "     , RESULT.ANSWERDATE "
					+ "     , USERS.USERNAME "
					+ "     FROM "
					+ "       RESULT "
					+ "     , TEST "
					+ "     , USERS "
					+ "     WHERE "
					+ "       RESULT.USERID = USERS.USERID "
					+ "         AND "
					+ "       RESULT.TESTID = TEST.TESTID "
					+ "     ORDER BY "
					+ "       USERS.USERNAME DESC "
					+ "     , RESULT.ANSWERDATE DESC"
					+ "    ) "
					+ "    tbl "
					+ "  ) "
					+ "  tblx "
					+ "WHERE "
					+ "  ROWNUMBER BETWEEN ? AND ? "
					;

	public ScoreListBean getScoreListNameSortDesc(int start, int end) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		ScoreListBean scoreListBean = new ScoreListBean();
		Result result = null;
		User user = null;
		Test test = null;

		List<Result> resultList = new ArrayList<Result>();

		try{
			stmt = con.prepareStatement(SELECT_SCORELIST_NAME_SORT_DESC);
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
		    		result = new Result();
		    		user = new User();
		    		test = new Test();

					result.setResultid(new ResultID(rset.getString(2)));
					test.setTestID(new TestID(rset.getString(3)));
					user.setUserid(new UserID(rset.getString(4)));
					result.setScore(new Score(rset.getInt(5)));
					result.setAnswerDate(new AnswerDate(rset.getString(6)));
					user.setUsername(new UserName(rset.getString(7)));
					result.setUser(user);
					resultList.add(result);
					scoreListBean.setResultList(resultList);
				}
		}

		finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}

		return scoreListBean;

	}

//-----------------------------------------------------------------------------------------------------------------

	// 日付が降順で名前の昇順にソート
	private static final String SELECT_SCORELIST_NAME_SORT_ASC =
				"SELECT "
				+ "  * "
				+ "FROM "
				+ "  ( "
				+ "   SELECT "
				+ "     ROWNUM ROWNUMBER "
				+ "   , tbl.RESULTID "
				+ "   , tbl.TESTID "
				+ "   , tbl.USERID "
				+ "   , tbl.SCORE "
				+ "   , tbl.ANSWERDATE "
				+ "   , tbl.USERNAME "
				+ "  FROM "
				+ "    ( "
				+ "     SELECT "
				+ "       RESULT.RESULTID "
				+ "     , TEST.TESTID "
				+ "     , USERS.USERID "
				+ "     , RESULT.SCORE "
				+ "     , RESULT.ANSWERDATE "
				+ "     , USERS.USERNAME "
				+ "     FROM "
				+ "       RESULT "
				+ "     , TEST "
				+ "     , USERS "
				+ "     WHERE "
				+ "       RESULT.USERID = USERS.USERID "
				+ "         AND "
				+ "       RESULT.TESTID = TEST.TESTID "
				+ "     ORDER BY "
				+ "       USERS.USERNAME ASC "
				+ "     , RESULT.ANSWERDATE DESC"
				+ "    ) "
				+ "    tbl "
				+ "  ) "
				+ "  tblx "
				+ "WHERE "
				+ "  ROWNUMBER BETWEEN ? AND ? "
				;

	public ScoreListBean getScoreListNameSortAsc(int start, int end) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		ScoreListBean scoreListBean = new ScoreListBean();
		Result result = null;
		User user = null;
		Test test = null;

		List<Result> resultList = new ArrayList<Result>();

		try{
			stmt = con.prepareStatement(SELECT_SCORELIST_NAME_SORT_ASC);
			stmt.setInt(1, start);
			stmt.setInt(2, end);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
		    		result = new Result();
		    		user = new User();
		    		test = new Test();

					result.setResultid(new ResultID(rset.getString(2)));
					test.setTestID(new TestID(rset.getString(3)));
					user.setUserid(new UserID(rset.getString(4)));
					result.setScore(new Score(rset.getInt(5)));
					result.setAnswerDate(new AnswerDate(rset.getString(6)));
					user.setUsername(new UserName(rset.getString(7)));
					result.setUser(user);
					resultList.add(result);
					scoreListBean.setResultList(resultList);
				}

		}finally{

			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
		return scoreListBean;
	}
}
