package domain.value;

import util.AesEncryptUtil;

public class Password extends Value{

	private String password;	// パスワード

	/* コンストラクタ */
	public Password(String password){
		super();
		this.password = password;
	}

	/* getメソッド */
	public String getPassword(){
		return password;
	}

	/* ハッシュ化 */
	public String getHash(){
		return AesEncryptUtil.getHash(password);
	}

	/* 比較 */
	public boolean equals(String hash){
		return AesEncryptUtil.getHash(password).equals(hash);
	}

	/* toStringメソッド */
	@Override
	public String toString(){
		return password;
	}

}
