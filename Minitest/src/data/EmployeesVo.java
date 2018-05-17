package data;
/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Thu May 18 17:00:22 JST 2017
 */
import java.io.Serializable;

/**
 * EmployeesVo.
 * @author e.hayashi
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2017/05/18	e.hayashi		Generated.
 */
public class EmployeesVo implements Serializable{

	public static final String TABLE = "EMPLOYEES";

	/**
	 * EmployeeID:int(10) <Primary Key>
	 */
	private int employeeid;

	/**
	 * EmployeeName:varchar(100)
	 */
	private String employeename;

	/**
	 * Height:decimal(10)
	 */
	private java.math.BigDecimal height;

	/**
	 * EMail:varchar(100)
	 */
	private String email;

	/**
	 * Weight:decimal(10)
	 */
	private java.math.BigDecimal weight;

	/**
	 * HireFiscalYear:int(10)
	 */
	private int hirefiscalyear;

	/**
	 * Birthday:date(0)
	 */
	private java.sql.Date birthday;

	/**
	 * BloodType:varchar(2)
	 */
	private String bloodtype;

	/**
	* Constractor
	*/
	public EmployeesVo(){}

	/**
	* Constractor
	* @param <code>employeeid</code>
	*/
	public EmployeesVo(int employeeid){
		this.employeeid = employeeid;
	}

	public int getEmployeeid(){ return this.employeeid; }

	public void setEmployeeid(int employeeid){ this.employeeid = employeeid; }

	public String getEmployeename(){ return this.employeename; }

	public void setEmployeename(String employeename){ this.employeename = employeename; }

	public java.math.BigDecimal getHeight(){ return this.height; }

	public void setHeight(java.math.BigDecimal height){ this.height = height; }

	public String getEmail(){ return this.email; }

	public void setEmail(String email){ this.email = email; }

	public java.math.BigDecimal getWeight(){ return this.weight; }

	public void setWeight(java.math.BigDecimal weight){ this.weight = weight; }

	public int getHirefiscalyear(){ return this.hirefiscalyear; }

	public void setHirefiscalyear(int hirefiscalyear){ this.hirefiscalyear = hirefiscalyear; }

	public java.sql.Date getBirthday(){ return this.birthday; }

	public void setBirthday(java.sql.Date birthday){ this.birthday = birthday; }

	public String getBloodtype(){ return this.bloodtype; }

	public void setBloodtype(String bloodtype){ this.bloodtype = bloodtype; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[EmployeesVo:");
		buffer.append(" employeeid: ");
		buffer.append(employeeid);
		buffer.append(" employeename: ");
		buffer.append(employeename);
		buffer.append(" height: ");
		buffer.append(height);
		buffer.append(" email: ");
		buffer.append(email);
		buffer.append(" weight: ");
		buffer.append(weight);
		buffer.append(" hirefiscalyear: ");
		buffer.append(hirefiscalyear);
		buffer.append(" birthday: ");
		buffer.append(birthday);
		buffer.append(" bloodtype: ");
		buffer.append(bloodtype);
		buffer.append("]");
		return buffer.toString();
	}

}
