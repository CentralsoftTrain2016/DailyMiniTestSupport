package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.PrefecturalsVo;

public class PrefecturalsDao extends Dao
{

	public PrefecturalsDao(Connection con) {
		super(con);

	}
	private static final String PREFECTURALLIST_SQL
		="SELECT " +
			"    Customers.PrefecturalID," +
			"    Prefecturals.PrefecturalName," +
			"    COUNT(*) " +
			"FROM customers" +
			"		join" +
			"	 Prefecturals" +
			"		on Prefecturals.PrefecturalID = Prefecturals.PrefecturalID " +
			"GROUP BY" +
			"  customers.PrefecturalID";

	public List<PrefecturalsVo> getAllPrefecturals() throws SQLException
	{
		  PreparedStatement stmt = null;
		  ResultSet rset = null;

		  List<PrefecturalsVo>  list = new ArrayList<PrefecturalsVo> ();

		  try{

			/* Statementの作成 */
			stmt = con.prepareStatement( PREFECTURALLIST_SQL );

			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			/* 取得したデータを表示します。 */
			while (rset.next())
				{
					PrefecturalsVo pf = new PrefecturalsVo( rset.getInt(1));
					pf.setPrefecturalname(rset.getString(2));
					pf.setCustomerCount( rset.getInt(3));
					list.add(pf);

				}
		  }

		catch (SQLException e) {
			throw e;
		}
		finally{
			/* クローズ処理 */
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return list;
	}

}
