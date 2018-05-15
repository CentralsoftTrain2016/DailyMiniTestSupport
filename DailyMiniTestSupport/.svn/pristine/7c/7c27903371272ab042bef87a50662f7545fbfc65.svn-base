package db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Choice;
import domain.Question;
import domain.value.CommentaryText;
import domain.value.Text;
import domain.value.Enum.IsCorrectEnum;
import domain.value.id.ChoiceID;

public class ChoiceDao extends Dao {

	public ChoiceDao(Connection con) {
		super(con);
	}
	//-----------------------------------------------------------------------------------------------------------------

		private static final String GET_CHOICE_BY_QUESTIONID =
		"	SELECT 	"
		+"	  CHOICE.CHOICEID,	"
		+"	  CHOICE.TEXT,	"
		+"	  CHOICE.COMMENTARYTEXT,	"
		+"	  CHOICE.ISRIGHT,	"
		+"	  CHOICE.QUESTIONID	"
		+"	FROM CHOICE	"
		+"	WHERE	"
		+"	 CHOICE.QUESTIONID = ?	";
		public void getItemByQuestionID( Question q) throws SQLException
		{

			PreparedStatement stmt = null;
			ResultSet rset = null;


			  try{
				stmt = con.prepareStatement(GET_CHOICE_BY_QUESTIONID);
				stmt.setString(1, q.getQuestionID().toString());

				// ＳＱＬ実行
				rset = stmt.executeQuery();

				while (rset.next())
					{
						Choice choice = new Choice(
								new ChoiceID( 			rset.getString(1) ),
								q,
								new Text(				rset.getString(2)),
								new CommentaryText( 	rset.getString(3)),
								IsCorrectEnum.valueOf(	rset.getString(4))
								);
						q.add(choice);
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
		private static final String UPDATE_CHOICE =
				"	UPDATE CHOICE		"
				+"	SET		"
				+"	 CHOICE.QUESTIONID	=?,	"
				+"	  CHOICE.ISRIGHT	=?,	"
				+"	  CHOICE.TEXT	=?,	"
				+"	  CHOICE.COMMENTARYTEXT	=?	"
				+"	WHERE		"
				+"	  CHOICE.CHOICEID = ?		";


		public void regist(Choice choice) throws SQLException {

			PreparedStatement stmtUpdate = null;
			ResultSet rset = null;


			  try{
				  stmtUpdate = con.prepareStatement(UPDATE_CHOICE);

				  stmtUpdate.setString(1, choice.getQuestion().getQuestionID().toString());
				  stmtUpdate.setString(2, choice.getIsCorrect().name());
				  stmtUpdate.setString(3, choice.getText().toString());
				  stmtUpdate.setString(4, choice.getCommentaryText().toString());
				  stmtUpdate.setString(5, choice.getChoiceID().toString());
				  // ＳＱＬ実行

				  int c = stmtUpdate.executeUpdate();
				  if(c != 1)
				  {
					  throw new SQLException("更新に失敗しました。行数：" + c);
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
		private static final String GET_NEW_CHOICE_ID =
				"select CHOICEID_SEQ.nextval as nextval from dual";

		private static final String INSERT_CHOICE =
				"	INSERT INTO CHOICE (	"
				+"	  CHOICE.CHOICEID,	"
				+"	  CHOICE.QUESTIONID,	"
				+"	  CHOICE.ISRIGHT,	"
				+"	  CHOICE.TEXT,	"
				+"	  CHOICE.COMMENTARYTEXT	"
				+"	)	"
				+"	values (	"
				+"	?,	"
				+"	?,	"
				+"	?,	"
				+"	?,	"
				+"	? )	";

		public ChoiceID save(Choice choice) throws SQLException {
			ChoiceID id =null;
			if( choice.getChoiceID() == null || choice.getChoiceID().equals(""))
			{
				Choice c =inser(choice);
				id = c.getChoiceID();
			}
			else
			{
				regist(choice);
				id = choice.getChoiceID();
			}

			return id;
		}
		//------------------------------------
		private Choice inser(Choice choice) throws SQLException
		{

			PreparedStatement stmtSeq = null;
			PreparedStatement stmtInsert = null;
			ResultSet rset = null;


			try
			{
				stmtSeq = con.prepareStatement(GET_NEW_CHOICE_ID);
				stmtInsert = con.prepareStatement(INSERT_CHOICE);

				// ＳＱＬ実行
				rset = stmtSeq.executeQuery();

				ChoiceID choiceID =null;
				while (rset.next())
				{
					BigDecimal dec = rset.getBigDecimal(1);
					choiceID = new ChoiceID(dec);
					choice.setChoiceID(choiceID);
				}

				stmtInsert.setString(1, choiceID.toString());
				stmtInsert.setString(2, choice.getQuestion().getQuestionID().toString());
				stmtInsert.setString(3, choice.getIsCorrect().name());
				stmtInsert.setString(4, choice.getText().toString());
				stmtInsert.setString(5, choice.getCommentaryText().toString());
				// ＳＱＬ実行

				int c =stmtInsert.executeUpdate();
				  if(c != 1)
				  {
					  throw new SQLException("登録に失敗しました。行数：" + c);
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
			return choice;
		}


}
