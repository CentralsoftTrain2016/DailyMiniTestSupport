package db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Choice;
import domain.Question;
import domain.Test;
import domain.Theme;
import domain.value.CommentaryText;
import domain.value.Text;
import domain.value.Enum.QuestionTypeEnum;
import domain.value.id.QuestionID;
import domain.value.id.ThemeID;

public class QuestionDao extends Dao {

	public QuestionDao(Connection con) {
		super(con);
	}

	//-----------------------------------------------------------------------------------------------------------------

		private static final String GET_QUESTION_BY_TESTID =
				"	SELECT QUESTION.QUESTIONID,	"
						+"	  QUESTION.TESTID,	"
						+"	  QUESTION.THEMEID,	"
						+"	  QUESTION.QUESTIONTYPE,	"
						+"	  QUESTION.TEXT,	"
						+"	  QUESTION.COMMENTARYTEXT	"
						+"	FROM QUESTION	"
						+"	WHERE "
						+ " 	QUESTION.TESTID  =?";

		public void getQuestionByTestID( Test test) throws SQLException{

			PreparedStatement stmt = null;
			ResultSet rset = null;
			ChoiceDao cDao = new ChoiceDao(con);

			  try{
				stmt = con.prepareStatement(GET_QUESTION_BY_TESTID);
				stmt.setString(1, test.getTestID().toString());

				// ＳＱＬ実行
				rset = stmt.executeQuery();

				while (rset.next())
					{
						Question q = new Question(
								new QuestionID( rset.getString(1)),
								test,
								new Theme( new ThemeID( rset.getString(3))),
								new Text( rset.getString(5)),
								new CommentaryText( rset.getString(6)),
								QuestionTypeEnum.valueOf(rset.getString(4))
								);
						cDao.getItemByQuestionID(q);
						test.add(q);
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

		}

		//----------------------------------------------------
		private static final String UPDATE_QUESTION =
				"	UPDATE QUESTION			"
						+"	SET			"
						+"	  QUESTION.TESTID,			=?,	"
						+"	  QUESTION.THEMEID,			=?,	"
						+"	  QUESTION.QUESTIONTYPE,	=?	"
						+"	  QUESTION.TEXT,			=?	"
						+"	  QUESTION.COMMENTARYTEXT	=?	"
						+"	WHERE				"
						+"	  QUESTION.QUESTIONID,			=?,	";
		public void regist(Question q) throws SQLException {
			ChoiceDao cDao = new ChoiceDao(con);
			PreparedStatement stmtUpdate = null;
			ResultSet rset = null;

			  try{
				  stmtUpdate = con.prepareStatement(UPDATE_QUESTION);

				  stmtUpdate.setString(1, q.getTest().getTestID().toString());
				  stmtUpdate.setString(2, q.getTheme().getThemeID().toString());
				  stmtUpdate.setString(3, q.getQuestionTypeEnum().name());
				  stmtUpdate.setString(4, q.getText().toString());
				  stmtUpdate.setString(5, q.getCommentaryText().toString());
				  stmtUpdate.setString(6, q.getQuestionID().toString());

				  // ＳＱＬ実行
				  int c = stmtUpdate.executeUpdate();
				  if(c != 1)
				  {
					  throw new SQLException("更新に失敗しました。行数：" + c);
				  }

				for( Choice choice: q )
				{
					cDao.save(choice);
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
		private static final String GET_NEW_QUESTION_ID =
				"select QUESTIONID_SEQ.nextval as nextval from dual";

		private static final String INSERT_QUESTION =
				"	INSERT INTO QUESTION(			"
						+"	  QUESTION.QUESTIONID,			"
						+"	  QUESTION.TESTID,			"
						+"	  QUESTION.THEMEID,			"
						+"	  QUESTION.QUESTIONTYPE,			"
						+"	  QUESTION.TEXT,			"
						+"	  QUESTION.COMMENTARYTEXT			"
						+"	)			"
						+"	values (			"
						+"	?,			"
						+"	?,			"
						+"	?,			"
						+"	?,			"
						+"	?,			"
						+"	? )			";
		public QuestionID save(Question q) throws SQLException {
			QuestionID id =null;
			if( q.getQuestionID() == null || q.getQuestionID().equals(""))
			{
				Question c =insert(q);
				id = c.getQuestionID();
			}
			else
			{
				regist(q);
				id = q.getQuestionID();
			}

			return id;
		}
		//------------------------------------
		private Question insert(Question q) throws SQLException
		{
			ChoiceDao cDao = new ChoiceDao(con);

			PreparedStatement stmtSeq = null;
			PreparedStatement stmtInsert = null;
			ResultSet rset = null;


			try
			{
				stmtSeq = con.prepareStatement(GET_NEW_QUESTION_ID);
				stmtInsert = con.prepareStatement(INSERT_QUESTION);

				// ＳＱＬ実行
				rset = stmtSeq.executeQuery();

				QuestionID questionID =null;
				while (rset.next())
				{
					BigDecimal dec = rset.getBigDecimal(1);
					questionID = new QuestionID(dec);
					q.setQuestionID(questionID);
				}

				stmtInsert.setString(1, questionID.toString());
				stmtInsert.setString(2, q.getTest().getTestID().toString());
				stmtInsert.setString(3, q.getTheme().getThemeID().toString());
				stmtInsert.setString(4, q.getQuestionTypeEnum().name());
				stmtInsert.setString(5, q.getText().toString());
				stmtInsert.setString(6, q.getCommentaryText().toString());
				// ＳＱＬ実行


				int c =stmtInsert.executeUpdate();
				  if(c != 1)
				  {
					  throw new SQLException("登録に失敗しました。行数：" + c);
				  }

				for( Choice choice: q )
				{
					cDao.save(choice);
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
			return q;
		}

}
