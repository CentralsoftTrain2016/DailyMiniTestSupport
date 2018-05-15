package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import domain.value.Enum.DeploydEnvironmentEnum;

public class PropertiesUtil {
	public static DeploydEnvironmentEnum isServer()
	{
		DeploydEnvironmentEnum ret=DeploydEnvironmentEnum.CLIENT;
		Properties properties = new Properties();

        String file = "C:/properties/saver.properties";

        InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
            properties.load(inputStream);
            inputStream.close();

            // 値の取得
            System.out.println("serverName:" + properties.getProperty("serverName"));
            String isServerStr = properties.getProperty("isServer");
            System.out.println("isServer:" + isServerStr);

            Boolean isServer = Boolean.valueOf(isServerStr);
            if(isServer)
            	ret = DeploydEnvironmentEnum.SERVER;
            else
            	ret = DeploydEnvironmentEnum.CLIENT;
		}
		catch (IOException e)
		{
			System.out.println("プロパティーがありません（クライアント）");
			//e.printStackTrace();
		}

		return ret;
	}

}
