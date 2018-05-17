package data;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 24 14:29:32 JST 2017
 */
import java.io.Serializable;

/**
 * ItemsVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2017/05/24	e.hayashi		Generated.
 */
public class ItemsVo implements Serializable{

	public static final String TABLE = "ITEMS";

	/**
	 * name:varchar(100) <Primary Key>
	 */
	private String name;

	/**
	 * price:int(10)
	 */
	private int price;

	/**
	 * weight:int(10)
	 */
	private int weight;

	/**
	* Constractor
	*/
	public ItemsVo(){}

	/**
	* Constractor
	* @param <code>name</code>
	*/
	public ItemsVo(String name){
		this.name = name;
	}

	public String getName(){ return this.name; }

	public void setName(String name){ this.name = name; }

	public int getPrice(){ return this.price; }

	public void setPrice(int price){ this.price = price; }

	public int getWeight(){ return this.weight; }

	public void setWeight(int weight){ this.weight = weight; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ItemsVo:");
		buffer.append(" name: ");
		buffer.append(name);
		buffer.append(" price: ");
		buffer.append(price);
		buffer.append(" weight: ");
		buffer.append(weight);
		buffer.append("]");
		return buffer.toString();
	}

}
