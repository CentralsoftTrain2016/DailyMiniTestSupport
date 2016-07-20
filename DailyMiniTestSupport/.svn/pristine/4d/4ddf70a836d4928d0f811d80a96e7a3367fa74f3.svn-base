package domain.value;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;



public abstract class Value
{
	public static <T> T getInstanceWithMaintain(String url, Class<T>  c)
	{
		T ret = null;
		try
		{
			if(url == null )
				url ="";
			else
				url = reduceMojibake(url );

			ret = c.getConstructor(String.class).newInstance(url);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return ret;
	}

	protected static String reduceMojibake( String in )
	{
		try {
			return new String(in.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
