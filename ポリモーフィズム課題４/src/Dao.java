
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao
{
	 protected Connection con;

	 public Dao(Connection con) {
		super();
		this.con = con;
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

		//com.mysql.jdbc.Driver d= new com.mysql.jdbc.Driver();
		//com.mysql.jdbc.JDBC4Connection c = new com.mysql.jdbc.JDBC4Connection();

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
