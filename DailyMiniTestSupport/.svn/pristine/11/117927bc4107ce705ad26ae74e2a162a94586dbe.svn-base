package domain.value.Enum;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import db.TestDao;
import domain.Choice;
import domain.Question;
import domain.value.CommentaryText;
import domain.value.Text;
import service.bean.CreateTestBean;

public enum CreateTestSubmitTypeEnum {
	submitAddChoice1
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			Question q = createTestBean.getTest().get(0);
			Choice c = new Choice(null, q, new Text("") , new CommentaryText(""),  IsCorrectEnum.FAIL );
			q.add(c);

			return "createtest.jsp";
		}
	},
	submitAddChoice2
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			Question q = createTestBean.getTest().get(1);
			Choice c = new Choice(null, q, new Text("") , new CommentaryText(""),  IsCorrectEnum.FAIL );
			q.add(c);
			return "createtest.jsp";
		}
	},
	submitAddChoice3
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			Question q = createTestBean.getTest().get(2);
			Choice c = new Choice(null, q, new Text("") , new CommentaryText(""),  IsCorrectEnum.FAIL );
			q.add(c);
			return "createtest.jsp";
		}
	},
	submitDelChoice1
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			Question q = createTestBean.getTest().get(0);
			if( q.size() > 1)
				q.remove( q.size()-1);
			return "createtest.jsp";
		}
	},
	submitDelChoice2
	{

		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			Question q = createTestBean.getTest().get(1);
			if( q.size() > 1)
				q.remove( q.size()-1);
			return "createtest.jsp";
		}
	},
	submitDelChoice3
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			Question q = createTestBean.getTest().get(2);
			if( q.size() > 1)
				q.remove( q.size()-1);
			return "createtest.jsp";
		}
	},
	submitReturn
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			return "MenuServlet";
		}
	},
	submitSave
	{
		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			TestDao tDao = new TestDao(con);
			try {
				tDao.save(createTestBean.getTest());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return "createtest.jsp";

		}
	},
	submitRegist
	{

		@Override
		public String doSubmitAction(CreateTestBean createTestBean, Connection con) {
			TestDao tDao = new TestDao(con);
			try {
				tDao.regist(createTestBean.getTest());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return "TestListServlet";
		}
	};

	abstract public  String doSubmitAction(CreateTestBean createTestBean, Connection con);



	public static CreateTestSubmitTypeEnum valueOfMap(Map<String, String[]> parameterMap)
 	{
 		CreateTestSubmitTypeEnum e=null;


		try{

			e = CreateTestSubmitTypeEnum.valueOf(parameterMap.get("submitType")[0]);
		}
		catch(IllegalArgumentException e1)
		{
	 		for( String param : parameterMap.keySet() )
	 		{
	 			try{
	 			e = CreateTestSubmitTypeEnum.valueOf(param);
	 			}
	 			catch(IllegalArgumentException e2)
	 			{
	 				//値がない場合は無視
	 			}

	 			if(  e!= null) break;
	 		}
		}



 		if( e == null ) throw new RuntimeException("該当するサブミットタイプがありません");

 		return e;
 	}
}
