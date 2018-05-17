package jp.co.central_soft.train2018.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



//---------------------------------------------
//会員管理
public class KaiinnMgr
{
	public void sample( Kaiinn k )
	{

		try(
				Connection con = Dao.getConnection();
				PreparedStatement	stmt = con.prepareStatement(PUT_SQL);
			)
		{
			//--------------------
		}
		catch( ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	private static final String PUT_SQL =
			"INSERT INTO kaiinn " +
			"( " +
			    "kaiinNo, "+
				"name, " +
				"registDate ) " +
			"VALUES ( ?, ?, ? )";

	private static final String ALLGET_SQL =
		"select "
		+ "kaiinNo, "
		+ "name, "
		+ "registDate "
		+ "from "
		+ " kaiinn";

	private static final String GET_SQL =
			"select "
			+ "name, "
			+ "registDate "
			+ "from "
			+ " kaiinn "
			+ "where "
			+ " kaiinNo = ? ";

	public void put( Kaiinn k ) throws ExistException
	{

		try(
				Connection con = Dao.getConnection();
				PreparedStatement	stmt = con.prepareStatement(PUT_SQL);
			)
		{
			if( this.get(k.getKaiinNo(),con) != null )
				throw new ExistException();

			/* Statementの作成 */
			stmt.setInt(	1, k.getKaiinNo() 	);
			stmt.setString(	2, k.getName()		);
			stmt.setDate(	3, Dao.convertToSqlDate(k.getRegistDate()));

			/* ｓｑｌ実行 */
			int numCount = stmt.executeUpdate();
		}
		catch( ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private Kaiinn get(int kaiinNo, Connection con)
	{
		Kaiinn k = null;
		try
		(
			PreparedStatement	stmt = con.prepareStatement(GET_SQL);
		)
		{
			/* Statementの作成 */
			stmt.setInt(	1, kaiinNo 	);

			/* ｓｑｌ実行 */
			ResultSet rset = stmt.executeQuery();


			while(rset.next())
			{
				k = new Kaiinn(
						kaiinNo,
						rset.getString(1),
						rset.getDate(2)
						);
			}
		}
		catch(SQLException e )
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return k;
	}

	//-------------------------------
	public Kaiinn get( int kaiinNo )
	{
		Kaiinn k =null;
		try(
				Connection con = Dao.getConnection();
			)
		{
			k =this.get( kaiinNo, con );
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return k;
	}

	public Collection<Kaiinn> values()
	{
		List<Kaiinn>  list = new ArrayList<Kaiinn>();

		try(
				Connection con = Dao.getConnection();
				PreparedStatement	stmt = con.prepareStatement(ALLGET_SQL);
			)
		{
			/* ｓｑｌ実行 */
			ResultSet rset = stmt.executeQuery();


			while(rset.next())
			{
				Kaiinn k = new Kaiinn(
						rset.getInt(1),
						rset.getString(2),
						rset.getDate(3)
						);

				list.add(k);
			}
		}
		catch( ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}
}
