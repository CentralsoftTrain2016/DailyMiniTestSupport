package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;
import domain.value.AverageScore;
import domain.value.LoginUserName;
import domain.value.Password;
import domain.value.TestCount;
import domain.value.UserName;
import domain.value.Enum.LoginRoleEnum;
import domain.value.id.UserID;
import service.bean.ScoreListBean;

public class UserDao extends Dao{

	public UserDao(Connection con) {
		super(con);
	}

	public void userCreate(User user){

		PreparedStatement stmt = null;

		try{
			/* Statementの作成 */
			stmt = con.prepareStatement(
					  "insert "
				    + "   into USERS "
					+ "("
					+ "    	 USERID "
					+ "    	,USERNAME "
					+ "   	,PASSWORD "
					+ "   	,AVERAGESCORE "
					+ "   	,LOGINNAME "
					+ "   	,LOGINROLE "
					+ "   	,TESTCOUNT "
					+ ")"
					+ "values "
					+ "("
					+ " 	 USERID_seq.nextval"
					+ " 	,?"
					+ " 	,?"
					+ "		,0.0"
					+ "		,?"
					+ "		,?"
					+ "		,?"
					+ ")"
					);

			//SQL文に代入
			stmt.setString(1, user.getUsername().toString());
			stmt.setString(2, user.getPassword().getHash());
			stmt.setString(3, user.getLoginusername().toString());
			stmt.setString(4, LoginRoleEnum.NORMAL.name());
			stmt.setInt(5, 0);

			/* ｓｑｌ実行 */
			int lineCount = stmt.executeUpdate();
			if (lineCount != 1) {
				throw new SQLException("登録できません. ID:" + user.getLoginusername().toString());
			}

		} catch (SQLException e) {
			e.getErrorCode();
			//`systemout e
			try {
				throw e;
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				stmt = null;
			}
		}
	}


	private static final String SELECT_USERBYLOGINBYUSERNAMEANDPASSWORD_SQL =
			  "SELECT "
			+ "  USERID "
			+ ", USERNAME "
			+ ", PASSWORD "
			+ ", AVERAGESCORE "
			+ ", LOGINNAME "
			+ ", LOGINROLE "
			+ ", TESTCOUNT "
			+ "FROM "
			+ "  USERS "
			+ "WHERE"
			+"   PASSWORD = ? "
			+ "AND "
			+ "  LOGINNAME = ? ";

	public User getUserByLoginUserNameAndPassword(LoginUserName loginUserName, Password password) throws SQLException{

		 PreparedStatement stmt = null;
		 ResultSet rset = null;
		 User user = null;

		  try{
			stmt = con.prepareStatement(SELECT_USERBYLOGINBYUSERNAMEANDPASSWORD_SQL);
//			stmt.setString(1, password.getHash());
			stmt.setString(1, password.toString());
			stmt.setString(2, loginUserName.toString());

			rset = stmt.executeQuery();

			while (rset.next())
				{
					user = new User();
					user.setUserid(new UserID(rset.getString(1)));
					user.setUsername(new UserName(rset.getString(2)));
					user.setPassword(new Password(rset.getString(3)));
					user.setAveragescore(new AverageScore(rset.getInt(4)));
					user.setLoginusername(new LoginUserName(rset.getString(5)));
					user.setLoginRoleEnum(LoginRoleEnum.valueOf(rset.getString(6)));
					user.setTestCount(new TestCount(rset.getInt(7)));
				}
		}

		finally{

			if(stmt != null){
			  try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			  stmt = null;
			}
			if(rset != null){
			  try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			  rset = null;
			}
		}

		return user;
	}


	private static final String SELECT_USER_LIST =
			  "SELECT "
			+ "  USERID "
			+ ", USERNAME "
			+ "FROM "
			+ "  USERS "
			;

	public List<User> getUserList() throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;
		User user = null;
		ScoreListBean scoreListBean = new ScoreListBean();

		List<User> userList = new ArrayList<User>();

		try{
			stmt = con.prepareStatement(SELECT_USER_LIST);

			rset = stmt.executeQuery();

			while (rset.next())
				{
					user = new User();
					user.setUserid(new UserID(rset.getString(1)));
					user.setUsername(new UserName(rset.getString(2)));
					userList.add(user);
					scoreListBean.setUserList(userList);
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
		return userList;
	}

	private static final String SELECT_USER_SQL =
			  "SELECT "
			+ "  USERID "
			+ ", USERNAME "
			+ ", PASSWORD "
			+ ", AVERAGESCORE "
			+ ", LOGINNAME "
			+ ", LOGINROLE "
			+ ", TESTCOUNT "
			+ "FROM "
			+ "  USERS "
			+ "WHERE"
			+"   USERID = ? ";

	public User getUserByID(UserID userid) throws SQLException{

		 PreparedStatement stmt = null;
		 ResultSet rset = null;
		 User user = null;

		  try{
			stmt = con.prepareStatement(SELECT_USER_SQL);
			stmt.setString(1, userid.toString());

			rset = stmt.executeQuery();

			while (rset.next())
				{
					user = new User();
					user.setUserid(new UserID(rset.getString(1)));
					user.setUsername(new UserName(rset.getString(2)));
					user.setPassword(new Password(rset.getString(3)));
					user.setAveragescore(new AverageScore(rset.getInt(4)));
					user.setLoginusername(new LoginUserName(rset.getString(5)));
					user.setLoginRoleEnum(LoginRoleEnum.valueOf(rset.getString(6)));
					user.setTestCount(new TestCount(rset.getInt(7)));
				}
		}

		finally{

			if(stmt != null){
			  try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			  stmt = null;
			}
			if(rset != null){
			  try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			  rset = null;
			}
		}

		return user;
	}

}
