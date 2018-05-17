package db;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 16 13:55:47 JST 2018
 */
import java.io.Serializable;

/**
 * SalaryVo.
 * @author e.hayashi
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2018/05/16	e.hayashi		Generated.
 */
public class SalaryVo implements Serializable{

	public static final String TABLE = "SALARY";

	/**
	 * SalaryID:int(10) <Primary Key>
	 */
	private int salaryid;

	/**
	 * PayDate:date(0)
	 */
	private java.sql.Date paydate;

	/**
	 * Amount:decimal(10)
	 */
	private java.math.BigDecimal amount;

	/**
	 * EmployeeID:int(10)
	 */
	private int employeeid;

	/**
	* Constractor
	*/
	public SalaryVo(){}

	/**
	* Constractor
	* @param <code>salaryid</code>
	*/
	public SalaryVo(int salaryid){
		this.salaryid = salaryid;
	}

	public int getSalaryid(){ return this.salaryid; }

	public void setSalaryid(int salaryid){ this.salaryid = salaryid; }

	public java.sql.Date getPaydate(){ return this.paydate; }

	public void setPaydate(java.sql.Date paydate){ this.paydate = paydate; }

	public java.math.BigDecimal getAmount(){ return this.amount; }

	public void setAmount(java.math.BigDecimal amount){ this.amount = amount; }

	public int getEmployeeid(){ return this.employeeid; }

	public void setEmployeeid(int employeeid){ this.employeeid = employeeid; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[SalaryVo:");
		buffer.append(" salaryid: ");
		buffer.append(salaryid);
		buffer.append(" paydate: ");
		buffer.append(paydate);
		buffer.append(" amount: ");
		buffer.append(amount);
		buffer.append(" employeeid: ");
		buffer.append(employeeid);
		buffer.append("]");
		return buffer.toString();
	}

}
