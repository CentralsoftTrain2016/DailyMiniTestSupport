package db;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.PropertiesUtil;

public abstract class Dao
{
	 protected Connection con;

	 public Dao(Connection con) {
		super();
		this.con = con;
	}

	public static Connection getConnection() throws SQLException
	{
		 InitialContext context;
		 DataSource ds =null;
		try
		{
			//デプロイされた場所を取得
			String resourceName = PropertiesUtil.isServer().getJndiResourceName();

			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/" + resourceName);
		} catch (NamingException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

		 Connection con = ds.getConnection();

		return con;
	 }

}
