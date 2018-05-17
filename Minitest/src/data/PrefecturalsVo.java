package data;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 16 14:04:41 JST 2018
 */
import java.io.Serializable;

/**
 * PrefecturalsVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/05/16	e.hayashi		Generated.
 */
public class PrefecturalsVo implements Serializable{

	public String getPrefecturalname() {
		return prefecturalname;
	}

	public void setPrefecturalname(String prefecturalname) {
		this.prefecturalname = prefecturalname;
	}

	public void setPrefecturalid(int prefecturalid) {
		this.prefecturalid = prefecturalid;
	}

	public static final String TABLE = "PREFECTURALS";

	/**
	 * PrefecturalID:int(10) <Primary Key>
	 */
	private int prefecturalid;

	/**
	 * PrefecturalName:varchar(100)
	 */
	private String prefecturalname;

	private int customerCount;

	public int getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	/**
	* Constractor
	*/
	public PrefecturalsVo(){}

	/**
	* Constractor
	* @param <code>prefecturalid</code>
	*/
	public PrefecturalsVo(int prefecturalid){
		this.prefecturalid = prefecturalid;
	}

	@Override
	public String toString() {
		return "PrefecturalsVo [prefecturalid=" + prefecturalid + ", prefecturalname=" + prefecturalname
				+ ", customerCount=" + customerCount + "]\n";
	}



}
