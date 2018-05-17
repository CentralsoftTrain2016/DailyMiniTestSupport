package jp.co.central_soft.train2018.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//-----------------------------
public class ConsoleUtil
{
    //------------------------------------
    public static void print( String str )
    {
        System.out.println(str);
    }

    //------------------------------------
    public static int inputIntFromConsole() throws IOException
    {
        String str ="";
        int ret;
        do
        {
            try
            {
            	str = inputStringFromConsole();
                ret = Integer.parseInt(str);
                //throw new Exception("業務エラーが発生しました。");
                break;
            }
            catch( NumberFormatException e )
            {
            	//e.printStackTrace();
                print(str + "が入力されました。数値を入力してください。");
            }
        }
        while(true);

        return ret;

    }
    //------------------------------------
    public static String inputStringFromConsole() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String buf = br.readLine();
        return buf;
    }
}
