package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.EmployeesVo;

public class EmployeeDao extends Dao
{
	public void addEmployee(EmployeesVo e) throws  SQLException
	{

		  PreparedStatement stmt = null;
		  ResultSet rset = null;
		  try{

			/* Statementの作成 */
			stmt = con.prepareStatement(
						  "insert into EMPLOYEES ("
						//+ "   EMPLOYEEID"
						+ "  EMPLOYEENAME"
						+ "  ,HEIGHT"
						+ "  ,EMAIL"
						+ "  ,WEIGHT"
						+ "  ,HIREFISCALYEAR"
						+ "  ,BIRTHDAY"
						+ "  ,BLOODTYPE"
						+ ")"
						+ " values ( "
						+ "  ?,?,?,?,?,?,? )");

			//stmt.setInt(1,e.getEmployeeid() );
			stmt.setString(1, e.getEmployeename());
			stmt.setBigDecimal(2,e.getHeight());
			stmt.setString(3, e.getEmail());
			stmt.setBigDecimal(4, e.getWeight());
			stmt.setInt(5, e.getHirefiscalyear());
			stmt.setDate(6, e.getBirthday());
			stmt.setString(7, e.getBloodtype());


			/* ｓｑｌ実行 */
			//rset = stmt.executeQuery();
			int numCount = stmt.executeUpdate();
		}
		catch (SQLException ex) {
			throw ex;
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


	public EmployeeDao(Connection con) {
		super(con);
	}

	public EmployeesVo getEmployeeByKey(int i) throws  SQLException
	{

		  PreparedStatement stmt = null;
		  ResultSet rset = null;
		  EmployeesVo em = new EmployeesVo();

		  try{

			/* Statementの作成 */
			stmt = con.prepareStatement(
						  "select "
						+ "   EMPLOYEEID"
						+ "  ,EMPLOYEENAME"
						+ "  ,HEIGHT"
						+ "  ,EMAIL"
						+ "  ,WEIGHT"
						+ "  ,HIREFISCALYEAR"
						+ "  ,BIRTHDAY"
						+ "  ,BLOODTYPE"
						+ " from "
						+ "   EMPLOYEES "
						+ "where "
						//+ "  EMPLOYEEID =" + i ); //これはつかわない　SQLインジェクション対策、高速化対策

						+ "  EMPLOYEEID =? ");

			stmt.setInt(1, i);

			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			/* 取得したデータを表示します。 */
			while (rset.next())
				{

					//em.setEmployeeid(		rset.getInt("EMPLOYEEID") );
					em.setEmployeeid(		rset.getInt(1) );
					em.setEmployeename( 	rset.getString(2));
					em.setHeight( 			rset.getBigDecimal(3));
					em.setEmail(			rset.getString(4));
					em.setWeight(			rset.getBigDecimal(5));
					em.setHirefiscalyear(	rset.getInt(6));
					em.setBirthday(			rset.getDate(7));
					em.setBloodtype(		rset.getString(4));
					//System.out.println(rset.getString(1));
				}
		  }

		catch (SQLException e) {
			throw e;
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

		return em;
	}

	//--------------------------------------------------------
	public List<EmployeesVo> getAllEmployee() throws  SQLException
	{


		  PreparedStatement stmt = null;
		  ResultSet rset = null;

		  List<EmployeesVo>  list = new ArrayList<EmployeesVo> ();

		  try{

			/* Statementの作成 */
			stmt = con.prepareStatement(
						  "select "
						+ "   EMPLOYEEID"
						+ "  ,EMPLOYEENAME"
						+ "  ,HEIGHT"
						+ "  ,EMAIL"
						+ "  ,WEIGHT"
						+ "  ,HIREFISCALYEAR"
						+ "  ,BIRTHDAY"
						+ "  ,BLOODTYPE"
						+ " from "
						+ "   EMPLOYEES "
						);


			/* ｓｑｌ実行 */
			rset = stmt.executeQuery();

			/* 取得したデータを表示します。 */
			while (rset.next())
				{
					EmployeesVo em = new EmployeesVo();
					em.setEmployeeid(		rset.getInt(1) );
					em.setEmployeename( 	rset.getString(2));
					em.setHeight( 			rset.getBigDecimal(3));
					em.setEmail(			rset.getString(4));
					em.setWeight(			rset.getBigDecimal(5));
					em.setHirefiscalyear(	rset.getInt(6));
					em.setBirthday(			rset.getDate(7));
					em.setBloodtype(		rset.getString(8));
					list.add(em);

					//System.out.println(rset.getString(1));
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