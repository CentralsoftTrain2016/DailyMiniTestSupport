package db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Question;
import domain.Result;
import domain.Test;
import domain.Theme;
import domain.User;
import domain.value.Text;
import domain.value.UserName;
import domain.value.Enum.IsReleasedEnum;
import domain.value.date.RegistrationDate;
import domain.value.id.ResultID;
import domain.value.id.TestID;
import domain.value.id.UserID;
import service.bean.TestListBean;
import service.bean.TestListItem;

public class TestDao extends Dao{

	public TestDao(Connection con) {
		super(con);
	}

	// リリースしたかどうかを取得
	private static final String SELECT_UNRELEASED =
			  "SELECT "
			+ "  TESTID "
			+ ", CREATEUSER "
			+ "FROM "
			+ "  TEST "
			+ "WHERE "
			+ "  CREATEUSER =? "
			+ "AND "
			+ "  ISRELEASED =?";

	public Test getUnreleasedTest(User user) throws SQLException{
		 PreparedStatement stmt = null;
		 ResultSet rset = null;
		 Test test = null;

		  try{
			stmt = con.prepareStatement(SELECT_UNRELEASED);
			stmt.setString(1, user.getUserid().toString());
			stmt.setString(2, IsReleasedEnum.PROGLESS.name());

			rset = stmt.executeQuery();

			while (rset.next())
				{
					test = new Test();
					test.setTestID(new TestID(rset.getString(1)));
					User user2 = new User();
					user2.setUserid(new UserID(rset.getString(2)));
					test.setCreateUser(user2);
					test.setIsReleased(IsReleasedEnum.PROGLESS);
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

		return test;
	}

//-----------------------------------------------------------------------------------------------------------------

	// テストのリストを取得
	private static final String SELECT_TESTLIST =
			  "SELECT "
			+ "  * "
			+ "FROM "
			+ "  ( "
			+ "   SELECT "
			+ "   ROWNUM ROWNUMBER"
			+ " , tbl.REGISTRATIONDATE "
			+ " , tbl.TEXT "
			+ " , tbl.CREATEUSER "
			+ " , tbl.USERNAME "
			+ " , tbl.TESTID "
			+ " , tbl.RESULTID "
			+ "  FROM "
			+ "    ( "
			+ "     SELECT "
			+ "       TEST.REGISTRATIONDATE "
			+ "     , THEME.TEXT "
			+ "     , TEST.CREATEUSER "
			+ "     , USERS.USERNAME "
			+ "     , TEST.TESTID "
			+ "     , RESULT.RESULTID "
			+ "     FROM "
			+ "       TEST "
			+ "     LEFT OUTER JOIN "
			+ "         RESULT "
			+ "     ON "
			+ "         TEST.TESTID = RESULT.TESTID "
			+ "     , THEME "
			+ "     , QUESTION "
			+ "     , USERS "
			+ "     WHERE "
			+ "       TEST.TESTID = QUESTION.TESTID "
			+ "         AND "
			+ "       QUESTION.THEMEID = THEME.THEMEID "
			+ "         AND "
			+ "       TEST.CREATEUSER = USERS.USERID "
			+ "         AND "
			+ "       TEST.ISRELEASED = ? "
			+ "     ORDER BY "
			+ "       TEST.REGISTRATIONDATE DESC "
			+ "    ) "
			+ "   tbl "
			+ "  ) tblx "
			+ "WHERE "
			+ "  ROWNUMBER BETWEEN ? AND ? ";

	public TestListBean getTestList(int start, int end) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		TestListBean testListItemList = new TestListBean();
		Test test = null;
		Theme theme = null;

		start = (start - 1) * 3 + 1;
		end = end * 3;

		  try{
			stmt = con.prepareStatement(SELECT_TESTLIST);
			stmt.setString(1, IsReleasedEnum.RELEASED.name());
			stmt.setInt(2, start);
			stmt.setInt(3, end);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
		    		TestListItem testListItem = new TestListItem();
		    		test = new Test();
					theme = new Theme();
					Result result = null;

					// 結果があればnewする
					if(rset.getString(7) != null){
						result = new Result();
						result.setResultid(new ResultID(rset.getString(7)));
					}

					Question question = new Question(null, test, theme, null, null, null);

					test.setRegistrationDate(new RegistrationDate(rset.getString(2)));

					theme.setText(new Text(rset.getString(3)));

					User user = new User();

					user.setUserid(new UserID(rset.getString(4)));
					test.setCreateUser(user);
					user.setUsername(new UserName(rset.getString(5)));
					
					test.setTestID(new TestID(rset.getString(6)));
					test.add(question);
					test.setIsReleased(IsReleasedEnum.RELEASED);
					question.setTheme(theme);

					testListItem.setResult(result);
					testListItem.setTest(test);
					testListItemList.addUniqueTest(testListItem);
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

		return testListItemList;

	}

//-----------------------------------------------------------------------------------------------------------------

	// レコード数取得
	private static final String SELECT_RECORD_COUNT =
			  "SELECT "
			+ "  count(*) "
			+ "FROM "
			+ "  TEST "
			;

	public int getRecordCount() throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		Test test = null;
		int count = 0;

		  try{
			stmt = con.prepareStatement(SELECT_RECORD_COUNT);

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next()){
		    	test = new Test();
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

	private static final String GET_TEST_BY_USER_UNRELEASED =
	"	SELECT "
	+"		TEST.TESTID AS TESTID1,	"
	+"	  	TEST.THEMEPERIODID AS THEMEPERIODID1,	"
	+"	  	TEST.REGISTRATIONDATE	"
	+"	FROM TEST	"
	+"	WHERE	"
	+"	  TEST.CREATEUSER =?	"
	+"	 AND 	"
	+"	  TEST.ISRELEASED = ?	";


	public Test getTestByUnrereased( User user) throws SQLException{
		QuestionDao qDao = new QuestionDao(con);

		PreparedStatement stmt = null;
		ResultSet rset = null;

		Test test = null;
		test = new Test();

		  try{
			stmt = con.prepareStatement(GET_TEST_BY_USER_UNRELEASED);
			stmt.setString(1, user.getUserid().toString());
			stmt.setString(2, IsReleasedEnum.PROGLESS.name());

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
					test.setTestID( new TestID( rset.getString(1)));
					test.setCreateUser(user);
					test.setRegistrationDate(new RegistrationDate(rset.getString(3)));

					//Questionを取得
					qDao.getQuestionByTestID(test);
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

		return test;
	}

//-----------------------------------------------------------------------------------------------------------------

	private static final String GET_TEST_BY_TESTID =
	"	SELECT "
	+"	  TEST.TESTID AS TESTID1,	"
	+"	  TEST.THEMEPERIODID AS THEMEPERIODID1,	"
	+"	  TEST.REGISTRATIONDATE,	"
	+"	FROM TEST	"
	+"	WHERE	"
	+"	  TEST.TESTID =?	";



	public Test getTestByTestID( TestID testID ) throws SQLException{
		QuestionDao qDao = new QuestionDao(con);

		PreparedStatement stmt = null;
		ResultSet rset = null;

		Test test = null;
		test = new Test();

		  try{
			stmt = con.prepareStatement(GET_TEST_BY_TESTID);
			stmt.setString(1, testID.toString() );

			// ＳＱＬ実行
			rset = stmt.executeQuery();

			while (rset.next())
				{
					test.setTestID( 		new TestID( rset.getString(1)));
					test.setCreateUser( 	new User( new UserID( rset.getString(2))));
					test.setRegistrationDate(new RegistrationDate(rset.getString(3)));

					//Questionを取得
					qDao.getQuestionByTestID(test);
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

		return test;
	}


	//----------------------------------------------------
	private static final String UPDATE_TEST =
			"	UPDATE TEST			"
					+"	SET 			"
					+"	 CREATEUSER       = ?,			"
					+"	 THEMEPERIODID   = ?,			"
					+"	 REGISTRATIONDATE = ?,			"
					+"	 ISRELEASED      = ?			"
					+"	WHERE 			"
					+"	  TESTID        = ?			";

	public void regist(Test test) throws SQLException {
		QuestionDao qDao = new QuestionDao(con);
		PreparedStatement stmtUpdate = null;
		ResultSet rset = null;

		test.setIsReleased(IsReleasedEnum.RELEASED);
		test.setRegistrationDate(RegistrationDate.now());
		  try{
			  stmtUpdate = con.prepareStatement(UPDATE_TEST);

			  stmtUpdate.setString(1, test.getCreateUser().getUserid().toString());
			  stmtUpdate.setString(2, test.getThemePeriod().getThemePeriodID().toString() );
			  stmtUpdate.setString(3, test.getRegistrationDate().toString());
			  stmtUpdate.setString(4, test.getIsReleased().name());
			  stmtUpdate.setString(5, test.getTestID().toString());

			  // ＳＱＬ実行
			  int c = stmtUpdate.executeUpdate();
//			  if(c != 1)
//			  {
//				  throw new SQLException("更新に失敗しました。行数：" + c);
//			  }

			for( Question question: test )
			{
				qDao.save(question);
			}

		}
		finally{

			if(stmtUpdate != null){
				stmtUpdate.close();
				stmtUpdate = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
	}

	//----------------------------------------------------
	private static final String GET_NEW_TEST_ID =
			"select TESTID_SEQ.nextval as nextval from dual";

	private static final String INSERT_TEST =
			"	INSERT		"
					+"	INTO TEST		"
					+"	  (		"
					+"	    TESTID,		"
					+"	    CREATEUSER,		"
					+"	    THEMEPERIODID,		"
					+"	    REGISTRATIONDATE,		"
					+"	    ISRELEASED		"
					+"	  )		"
					+"	  VALUES		"
					+"	  (		"
					+"	?,		"
					+"	?,		"
					+"	?,		"
					+"	?,		"
					+"	?		"
					+"	  )		";
	public TestID save(Test test) throws SQLException {
		TestID id =null;
		if( test.getTestID() == null || test.getTestID().equals(""))
		{
			Test t =insert(test);
			id = t.getTestID();
		}
		else
		{
			regist(test);
			id = test.getTestID();
		}

		return id;
	}
	//------------------------------------
	private Test insert(Test test) throws SQLException
	{
		QuestionDao qDao = new QuestionDao(con);

		PreparedStatement stmtSeq = null;
		PreparedStatement stmtInsert = null;
		ResultSet rset = null;


		try
		{
			stmtSeq = con.prepareStatement(GET_NEW_TEST_ID);
			stmtInsert = con.prepareStatement(INSERT_TEST);

			// ＳＱＬ実行
			rset = stmtSeq.executeQuery();

			TestID testID =null;
			while (rset.next())
			{
				BigDecimal dec = rset.getBigDecimal(1);
				testID = new TestID(dec);
				test.setTestID(testID);
			}

			stmtInsert.setString(1, testID.toString());
			stmtInsert.setString(2, test.getCreateUser().getUserid().toString());
			stmtInsert.setString(3, test.getThemePeriod().getThemePeriodID().toString());
			stmtInsert.setString(4, test.getRegistrationDate().toString());
			stmtInsert.setString(5, test.getIsReleased().name());
			// ＳＱＬ実行


			int c =stmtInsert.executeUpdate();
//			  if(c != 1)
//			  {
//				  throw new SQLException("登録に失敗しました。行数：" + c);
//			  }

			for( Question question: test )
			{
				qDao.save(question);
			}

		}
		finally{

			if(stmtSeq != null){
				stmtSeq.close();
				stmtSeq = null;
			}
			if(stmtInsert != null){
				stmtInsert.close();
				stmtInsert = null;
			}
			if(rset != null){
				rset.close();
				rset = null;
			}
		}
		return test;
	}

}
