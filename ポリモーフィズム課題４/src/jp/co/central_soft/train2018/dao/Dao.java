package jp.co.central_soft.train2018.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public abstract class Dao
{
	public static java.sql.Date convertToSqlDate( java.util.Date d1 )
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime( d1 );
		cal.set( Calendar.HOUR_OF_DAY, 0 );
		cal.set( Calendar.MINUTE, 0 );
		cal.set( Calendar.SECOND, 0 );
		cal.set( Calendar.MILLISECOND, 0 );
		java.sql.Date d2 = new java.sql.Date( cal.getTimeInMillis() );

		return d2;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	 {
		//接続文字列の構築
		/* ユーザ名 */
		String user = "e.hayashi";
		/* パスワード */
		String pass = "e.hayashi";

		/* サーバ名 */
		String servername = "localhost:3306";
		/* DB名 */
		String dbname = "new_schema";

		// ドライバーのロード
		Class.forName("com.mysql.jdbc.Driver");

		//接続の実行とコネクションオブジェクトの取得
		Connection c = DriverManager.getConnection(
					"jdbc:mysql://"
					+ servername
					+ "/"
					+ dbname,
					user,
					pass);

		//取得したコネクションの返却
		return c;
	 }

}
