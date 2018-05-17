package data;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 16 16:31:41 JST 2018
 */
import java.io.Serializable;

/**
 * KaiinnVo.
 * @author e.hayashi
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2018/05/16	e.hayashi		Generated.
 */
public class KaiinnVo implements Serializable{

	public static final String TABLE = "KAIINN";

	/**
	 * kaiinNo:int(10) <Primary Key>
	 */
	private int kaiinno;

	/**
	 * name:varchar(200)
	 */
	private String name;

	/**
	 * registDate:date(0)
	 */
	private java.sql.Date registdate;

	/**
	* Constractor
	*/
	public KaiinnVo(){}

	/**
	* Constractor
	* @param <code>kaiinno</code>
	*/
	public KaiinnVo(int kaiinno){
		this.kaiinno = kaiinno;
	}

	public int getKaiinno(){ return this.kaiinno; }

	public void setKaiinno(int kaiinno){ this.kaiinno = kaiinno; }

	public String getName(){ return this.name; }

	public void setName(String name){ this.name = name; }

	public java.sql.Date getRegistdate(){ return this.registdate; }

	public void setRegistdate(java.sql.Date registdate){ this.registdate = registdate; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[KaiinnVo:");
		buffer.append(" kaiinno: ");
		buffer.append(kaiinno);
		buffer.append(" name: ");
		buffer.append(name);
		buffer.append(" registdate: ");
		buffer.append(registdate);
		buffer.append("]");
		return buffer.toString();
	}

}
