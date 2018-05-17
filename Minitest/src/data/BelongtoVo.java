package data;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 24 14:33:37 JST 2017
 */
import java.io.Serializable;

/**
 * BelongtoVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2017/05/24	e.hayashi		Generated.
 */
public class BelongtoVo implements Serializable{

	public static final String TABLE = "BELONGTO";

	/**
	 * BelongID:int(10) <Primary Key>
	 */
	private int belongid;

	/**
	 * StartDate:date(0)
	 */
	private java.sql.Date startdate;

	/**
	 * EndDate:date(0)
	 */
	private java.sql.Date enddate;

	/**
	 * DepartmentID:int(10)
	 */
	private int departmentid;

	/**
	 * EmployeeID:int(10)
	 */
	private int employeeid;

	/**
	 * departments_DepartmentID:int(10) <Primary Key>
	 */
	private int departmentsDepartmentid;

	/**
	 * employees_EmployeeID:int(10) <Primary Key>
	 */
	private int employeesEmployeeid;

	/**
	* Constractor
	*/
	public BelongtoVo(){}

	/**
	* Constractor
	* @param <code>belongid</code>
	* @param <code>departmentsDepartmentid</code>
	* @param <code>employeesEmployeeid</code>
	*/
	public BelongtoVo(int belongid, int departmentsDepartmentid, int employeesEmployeeid){
		this.belongid = belongid;
		this.departmentsDepartmentid = departmentsDepartmentid;
		this.employeesEmployeeid = employeesEmployeeid;
	}

	public int getBelongid(){ return this.belongid; }

	public void setBelongid(int belongid){ this.belongid = belongid; }

	public java.sql.Date getStartdate(){ return this.startdate; }

	public void setStartdate(java.sql.Date startdate){ this.startdate = startdate; }

	public java.sql.Date getEnddate(){ return this.enddate; }

	public void setEnddate(java.sql.Date enddate){ this.enddate = enddate; }

	public int getDepartmentid(){ return this.departmentid; }

	public void setDepartmentid(int departmentid){ this.departmentid = departmentid; }

	public int getEmployeeid(){ return this.employeeid; }

	public void setEmployeeid(int employeeid){ this.employeeid = employeeid; }

	public int getDepartmentsDepartmentid(){ return this.departmentsDepartmentid; }

	public void setDepartmentsDepartmentid(int departmentsDepartmentid){ this.departmentsDepartmentid = departmentsDepartmentid; }

	public int getEmployeesEmployeeid(){ return this.employeesEmployeeid; }

	public void setEmployeesEmployeeid(int employeesEmployeeid){ this.employeesEmployeeid = employeesEmployeeid; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[BelongtoVo:");
		buffer.append(" belongid: ");
		buffer.append(belongid);
		buffer.append(" startdate: ");
		buffer.append(startdate);
		buffer.append(" enddate: ");
		buffer.append(enddate);
		buffer.append(" departmentid: ");
		buffer.append(departmentid);
		buffer.append(" employeeid: ");
		buffer.append(employeeid);
		buffer.append(" departmentsDepartmentid: ");
		buffer.append(departmentsDepartmentid);
		buffer.append(" employeesEmployeeid: ");
		buffer.append(employeesEmployeeid);
		buffer.append("]");
		return buffer.toString();
	}

}
