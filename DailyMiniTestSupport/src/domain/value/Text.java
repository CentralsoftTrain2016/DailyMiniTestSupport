package domain.value;

public class Text extends Value{

	private String text;	// 文字列

	/* コンストラクタ */
	public Text(String text){
		super();
		this.text = text;
	}

	/* getメソッド */
	public String getText(){
		return text;
	}

	/* toStringメソッド */
	@Override
	public String toString(){
		return text;
	}

}
