package data;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 24 14:30:03 JST 2017
 */
import java.io.Serializable;

/**
 * CategoriesVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2017/05/24	e.hayashi		Generated.
 */
public class CategoriesVo implements Serializable{

	public static final String TABLE = "CATEGORIES";

	/**
	 * CategoryID:int(10) <Primary Key>
	 */
	private int categoryid;

	/**
	 * CategoryName:varchar(100)
	 */
	private String categoryname;

	/**
	* Constractor
	*/
	public CategoriesVo(){}

	/**
	* Constractor
	* @param <code>categoryid</code>
	*/
	public CategoriesVo(int categoryid){
		this.categoryid = categoryid;
	}

	public int getCategoryid(){ return this.categoryid; }

	public void setCategoryid(int categoryid){ this.categoryid = categoryid; }

	public String getCategoryname(){ return this.categoryname; }

	public void setCategoryname(String categoryname){ this.categoryname = categoryname; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[CategoriesVo:");
		buffer.append(" categoryid: ");
		buffer.append(categoryid);
		buffer.append(" categoryname: ");
		buffer.append(categoryname);
		buffer.append("]");
		return buffer.toString();
	}

}
