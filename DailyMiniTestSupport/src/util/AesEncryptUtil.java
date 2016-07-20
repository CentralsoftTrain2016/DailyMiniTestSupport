package util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class AesEncryptUtil {
	private static final String ENCRYPT_KEY = "train2016!train2";
	private static final String ENCRYPT_IV = "centraltrain2016";
	private static final String ENCRYPT_TRANSFOMATION= "AES/CBC/PKCS5Padding";

	/**
	 * メインメソッド
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String in = "1234567890hayashieiiti1234567890hayashieiiti1234567890hayashieiiti1234567890hayashieiiti";

		// 暗号化メソッド呼出
		System.out.println(encrypt(in));

		// 復号化メソッド呼出
		System.out.println(decrypt(encrypt(in)));

	     //MD5でハッシュ
        System.out.println("MD5     = " + DigestUtils.md5Hex(in));

        //SHAでハッシュ
        //System.out.println("SHA-1   = " + DigestUtils.shaHex(data));

        //SHA256でハッシュ
        System.out.println("SHA-256 = " + DigestUtils.sha256Hex(in));

	}

	public static String getHash(String text) {
		return DigestUtils.md5Hex(text);
	}


	public static String encrypt(String text) {
		// 変数初期化
		String strResult = null;

		try
		{
			// 文字列をバイト配列へ変換
			byte[] byteText = text.getBytes("UTF-8");

			// 暗号化キーと初期化ベクトルをバイト配列へ変換
			byte[] byteKey = ENCRYPT_KEY.getBytes("UTF-8");
			byte[] byteIv = ENCRYPT_IV.getBytes("UTF-8");

			// 暗号化キーと初期化ベクトルのオブジェクト生成
			SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(byteIv);

			// Cipherオブジェクト生成
			Cipher cipher = Cipher.getInstance(ENCRYPT_TRANSFOMATION);

			// Cipherオブジェクトの初期化
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);

			// 暗号化の結果格納
			byte[] byteResult = cipher.doFinal(byteText);

			// Base64へエンコード
			strResult = Base64.encodeBase64String(byteResult);


		}
		catch (InvalidAlgorithmParameterException
				| UnsupportedEncodingException
				| NoSuchAlgorithmException
				| NoSuchPaddingException
				| InvalidKeyException
				| IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();

			throw new RuntimeException(e);
		}

		// 暗号化文字列を返却
		return strResult;
	}

	public static String decrypt(String text) {
		// 変数初期化
		String strResult = null;

		try
		{
			// Base64をデコード
			byte[] byteText = Base64.decodeBase64(text);

			// 暗号化キーと初期化ベクトルをバイト配列へ変換
			byte[] byteKey = ENCRYPT_KEY.getBytes("UTF-8");
			byte[] byteIv = ENCRYPT_IV.getBytes("UTF-8");

			// 復号化キーと初期化ベクトルのオブジェクト生成
			SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(byteIv);

			// Cipherオブジェクト生成
			Cipher cipher = Cipher.getInstance(ENCRYPT_TRANSFOMATION);

			// Cipherオブジェクトの初期化
			cipher.init(Cipher.DECRYPT_MODE, key, iv);

			// 復号化の結果格納
			byte[] byteResult = cipher.doFinal(byteText);

			// バイト配列を文字列へ変換
			strResult = new String(byteResult, "UTF-8");

		}
		catch (InvalidAlgorithmParameterException
				| UnsupportedEncodingException
				| NoSuchAlgorithmException
				| NoSuchPaddingException
				| InvalidKeyException
				| IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		// 復号化文字列を返却
		return strResult;
	}
}
