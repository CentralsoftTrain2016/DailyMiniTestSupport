package data;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 16 14:05:15 JST 2018
 */
import java.io.Serializable;

/**
 * CustomersVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/05/16	e.hayashi		Generated.
 */
public class CustomersVo implements Serializable{

	public static final String TABLE = "CUSTOMERS";

	/**
	 * CustomerID:int(10) <Primary Key>
	 */
	private int customerid;

	/**
	 * CustomerCode:int(10)
	 */
	private int customercode;

	/**
	 * CustomerName:varchar(100)
	 */
	private String customername;

	/**
	 * Address:varchar(100)
	 */
	private String address;

	/**
	 * CustomerClassID:int(10)
	 */
	private int customerclassid;

	/**
	 * PrefecturalID:int(10)
	 */
	private int prefecturalid;

	public String getPrefecturalName() {
		return prefecturalName;
	}

	public void setPrefecturalName(String prefecturalName) {
		this.prefecturalName = prefecturalName;
	}

	private String prefecturalName;

	/**
	* Constractor
	*/
	public CustomersVo(){}

	/**
	* Constractor
	* @param <code>customerid</code>
	*/
	public CustomersVo(int customerid){
		this.customerid = customerid;
	}

	public int getCustomerid(){ return this.customerid; }

	public void setCustomerid(int customerid){ this.customerid = customerid; }

	public int getCustomercode(){ return this.customercode; }

	public void setCustomercode(int customercode){ this.customercode = customercode; }

	public String getCustomername(){ return this.customername; }

	public void setCustomername(String customername){ this.customername = customername; }

	public String getAddress(){ return this.address; }

	public void setAddress(String address){ this.address = address; }

	public int getCustomerclassid(){ return this.customerclassid; }

	public void setCustomerclassid(int customerclassid){ this.customerclassid = customerclassid; }

	public int getPrefecturalid(){ return this.prefecturalid; }

	public void setPrefecturalid(int prefecturalid){ this.prefecturalid = prefecturalid; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[CustomersVo:");
		buffer.append(" customerid: ");
		buffer.append(customerid);
		buffer.append(" customercode: ");
		buffer.append(customercode);
		buffer.append(" customername: ");
		buffer.append(customername);
		buffer.append(" address: ");
		buffer.append(address);
		buffer.append(" customerclassid: ");
		buffer.append(customerclassid);
		buffer.append(" prefecturalid: ");
		buffer.append(prefecturalid);
		buffer.append("]");
		return buffer.toString();
	}

}
