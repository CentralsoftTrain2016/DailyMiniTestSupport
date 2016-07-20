package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Theme;
import domain.ThemePeriod;
import domain.value.Text;
import domain.value.date.EndDate;
import domain.value.date.StartDate;
import domain.value.id.CreateUserID;
import domain.value.id.ThemeID;
import domain.value.id.ThemePeriodID;
import domain.value.id.UserID;

public class ThemeDao extends Dao{
	public ThemeDao(Connection con) {
		super(con);
	}


	private static final String SELECT_THEME_SQL =
			  "SELECT "
			+ "  THEMEID "
			+ ", TEXT "
			+ "FROM "
			+ "  THEME "
			+ "WHERE "
			+ "  THEMEPERIODID IN(SELECT THEMEPERIODID "
			+ "          	FROM "
			+ "					THEMEPERIOD "
			+ "          	WHERE "
			+ "					to_char(sysdate,'yyyy-mm-dd') "
			+ "          		BETWEEN STARTDATE AND ENDDATE) ";

	public ThemePeriod getTheme() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		ThemePeriod themePeriod = new ThemePeriod(null, null, null, null);

		stmt = con.prepareStatement(SELECT_THEME_SQL);
		rset = stmt.executeQuery();

		while (rset.next())
			{
				Theme theme = new Theme();

				theme.setThemeID(new ThemeID(rset.getString(1)));
				theme.setText(new Text(rset.getString(2)));

				themePeriod.add(theme);
			}
		if(themePeriod.size() == 0)
		{
			themePeriod.add( new Theme());
			themePeriod.add( new Theme());
			themePeriod.add( new Theme());
		}

		//現在の日付が開始日以降かつ終了日以内のTHEMEPERIODID
		//THEMEPERIODが一致するTHEMEIDとTEXTを取得 それをTHEMEに入れる*３つ
		return themePeriod;//テーマリストを入れて返す
	}

	private static final String SELECT_THEME_BY_PID_SQL =
			    "SELECT "
			  + "	THEMEID, "
			  + "	TEXT, "
			  + "	THEMEPERIODID "
			  + "FROM "
			  + "	THEME  "
			  + "WHERE "
			  + "  THEMEPERIODID = ? "
	;

	public void getTheme( ThemePeriod themePeriod) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rset = null;

		stmt = con.prepareStatement(SELECT_THEME_BY_PID_SQL);
		stmt.setString(1, themePeriod.getThemePeriodID().toString());
		rset = stmt.executeQuery();

		while (rset.next())
			{
				Theme theme = new Theme();

				theme.setThemeID(new ThemeID(rset.getString(1)));
				theme.setText(new Text(rset.getString(2)));
				themePeriod.add(theme);
			}
		if(themePeriod.size() == 0)
		{
			themePeriod.add( new Theme());
			themePeriod.add( new Theme());
			themePeriod.add( new Theme());
		}
	}


	private static final String SELECT_THEMEPERIODID_SQL =
			"SELECT "
			+ "	THEMEPERIODID, "
			+ "	CREATEUSERID, "
			+ "	STARTDATE, "
			+ "	ENDDATE "
			+ "FROM "
			+ "	THEMEPERIOD "
			+ "WHERE "
			+ "	to_char(sysdate,'yyyy-mm-dd') "
			+ "	BETWEEN STARTDATE AND ENDDATE ";

	public ThemePeriod getThemepriod() throws SQLException {
		UserDao userDao = new UserDao(con);
		PreparedStatement stmt = null;
		ResultSet rset = null;
		ThemePeriod themePeriod =null;

		stmt = con.prepareStatement(SELECT_THEMEPERIODID_SQL);
		rset = stmt.executeQuery();

		while (rset.next())
		{
			themePeriod = new ThemePeriod(
					new ThemePeriodID( rset.getString(1)),
					new CreateUserID(rset.getString(2)),
					new StartDate(rset.getString(3)) ,
					new EndDate(rset.getString(4))
					);
			getTheme(themePeriod);
		}

		return themePeriod;
	}


	private static final String SELECT_ALL_THEME_SQL =
			  "SELECT "
			+ "  DISTINCT "
			+ "  TEXT "
			+ "FROM "
			+ "  THEME ";


	public ThemePeriod getAllTheme() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		ThemePeriod themePeriod = new ThemePeriod(null, null, null, null);

		stmt = con.prepareStatement(SELECT_ALL_THEME_SQL);
		rset = stmt.executeQuery();

		while (rset.next())
			{
				Theme theme = new Theme();

				theme.setText(new Text(rset.getString(1)));

				themePeriod.add(theme);
			}
		if(themePeriod.size() == 0)
		{
			themePeriod.add( new Theme());
		}

		//テーマテーブルに登録されているTEXTを重複なしでリスト化する
		return themePeriod;//重複のないすべてのテーマリストを入れて返す
	}

	private static final String INSERT_THEMEPERIOD_SQL =
			  "INSERT "
			+ "  INTO THEMEPERIOD "
			+ " ( "
			+ "   THEMEPERIODID "
			+ "  ,CREATEUSERID "
			+ "  ,STARTDATE "
			+ "  ,ENDDATE "
			+ " ) "
			+ " VALUES "
			+ " ( "
			+ "  , THEMEPERIODID_SEQ.nextval"
			+ "  ,? "
			+ "  ,? "
			+ "  ,? "
			+ " ) ";

	public ThemePeriodID createThemePeriod(UserID userId, StartDate startDate, EndDate endDate) throws SQLException{

		PreparedStatement stmt = null;
		ThemePeriodID themePeriodId = null;

			/* Statementの作成 */
			stmt = con.prepareStatement(INSERT_THEMEPERIOD_SQL, new String[] {"THEMEPERIODID"});

			//SQL文に代入
			stmt.setString(1, userId.toString());
			stmt.setString(2, startDate.toString());
			stmt.setString(3, endDate.toString());

			/* ｓｑｌ実行 */
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()){
				themePeriodId = new ThemePeriodID(rs.getString(1));
			}
			//今回自動取得したテーマピリオドIDを返す（テーマ登録で使用します）
			return themePeriodId;
	}

	private static final String INSERT_THEME_SQL =
			  "INSERT "
			+ "  INTO THEME "
			+ " ( "
			+ "   THEMEID "
			+ "   THEMEPERIODID "
			+ "  ,TEXT "
			+ " ) "
			+ " VALUES "
			+ " ( "
			+ "  , THEMEID_SEQ.nextval"
			+ "  ,? "
			+ "  ,? "
			+ " ) ";

	/*一度のSQL文で複数回nextvalしても１つしか数字が進まないみたいなので
	 * シーケンスの動作の仕方を考慮して、テーマ登録ごとに呼んでください（3回）
	 */
	public void createTheme(ThemePeriodID themePeriodId, Text text) throws SQLException{

		PreparedStatement stmt = null;

			/* Statementの作成 */
			stmt = con.prepareStatement(INSERT_THEME_SQL);

			//SQL文に代入
			stmt.setString(1, themePeriodId.toString());
			stmt.setString(2, text.toString());

			/* ｓｑｌ実行 */
			stmt.executeUpdate();
	}

}
