package util;

import java.util.ArrayList;
import java.util.List;

public class WordWrapper {


	public static void main( String[] args)
	{
		System.out.println( wordWrapp( "a234567890", 13 ));
		System.out.println( wordWrapp( "b2345678901234567890", 13 ));
		System.out.println( wordWrapp( "c23456789012345678901234567890", 13 ));
		System.out.println( wordWrapp( "あいうえおかきくけこさしすせそ", 13 ));
	}

	public static String wordWrapp( String in, int max)
	{

		if(in == null){
			String str = " ";
			return str;
		}
		String lf = "\r\n";
		boolean bchar = false;

		String str = in;
		int len = str.length();
		int spos = 0;
		int linelen = 0;
		StringBuilder buf = new StringBuilder();
		for (int i=0; i<len; i++) {
			char c = str.charAt(i);
			if (c == '\r' || c == '\n') {
				buf.append(str.substring(spos, i+1));
				spos = i+1;
				linelen = 0;
			} else {
				int clen = bchar || c < 0x7F ? 1 : 2;
				linelen += clen;
				if (linelen >= max) {
					buf.append(str.substring(spos, i));
					buf.append(lf);
					spos = i;
					i--;
					linelen = 0;
				}
			}
		}
		if (spos < len) {
			buf.append(str.substring(spos));
		}
		return buf.toString();
	}

	public static String[] getLins(String in, int max) {

		List<String> ret = _getLins(in, max);
		return   ret.toArray( new String[ret.size()]);
	}


	private static List<String> _getLins(String in, int max) {
		List<String> ret = new ArrayList<String>();

		String lf = "\r\n";
		boolean bchar = false;

		String str = in;
		int len = str.length();
		int spos = 0;
		int linelen = 0;

		for (int i=0; i<len; i++) {
			char c = str.charAt(i);
			if (c == '\r' || c == '\n') {
				ret.add( str.substring(spos, i+1) );
				spos = i+1;
				linelen = 0;
			} else {
				int clen = bchar || c < 0x7F ? 1 : 2;
				linelen += clen;
				if (linelen >= max) {
					ret.add(str.substring(spos, i) + lf);
					spos = i;
					i--;
					linelen = 0;
				}
			}
		}
		if (spos < len) {
			ret.add(str.substring(spos));
		}

		return ret;
	}
}
