package service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import data.EmployeesVo;
import data.PrefecturalsVo;
import db.Dao;
import db.EmployeeDao;
import db.PrefecturalsDao;

public class Main {
	public static void main(String[] args)
	{

		Connection con = null;
		try {
			con = Dao.getConnection();

			EmployeeDao  edao = new EmployeeDao(con);
			PrefecturalsDao  pdao = new PrefecturalsDao(con);

			//selectTest1( edao );
			//selectTest2( edao );
			selectTest3( pdao );

			//insertTest( edao );

		}
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			try {
				con.rollback();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //DBとの接続は１回だけ
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private static void selectTest3(PrefecturalsDao cdao) throws SQLException
	{
		List<PrefecturalsVo> list = cdao.getAllPrefecturals();
		System.out.println( list.toString() );
	}

	static private void  selectTest1(EmployeeDao dao) throws SQLException
	{
		EmployeesVo e = dao.getEmployeeByKey( 1);
		System.out.println( e.toString() );
	}

	static private void  selectTest2(EmployeeDao dao) throws SQLException
	{

		List<EmployeesVo> employeeList;
		employeeList = dao.getAllEmployee();

		for( EmployeesVo e2: employeeList )
		{
			System.out.println( e2.toString() );
		}
	}

	static private void  insertTest(EmployeeDao dao) throws SQLException
	{
		EmployeesVo evo = new EmployeesVo(100);

		//evo.setEmployeeid(100);
		evo.setEmployeename("林栄一");
		evo.setHeight(	new BigDecimal(169));
		evo.setEmail(	"e.hayashi@central-soft.co.jp");
		evo.setWeight(	new BigDecimal(80));
		evo.setHirefiscalyear(1995);
		evo.setBirthday(
				Date.valueOf(LocalDate.of(1962, 7, 29)));
		evo.setBloodtype("B");

		dao.addEmployee(evo);
	}

}
