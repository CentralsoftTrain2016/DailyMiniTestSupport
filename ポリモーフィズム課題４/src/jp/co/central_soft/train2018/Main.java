package jp.co.central_soft.train2018;
import java.io.IOException;

import jp.co.central_soft.train2018.util.ConsoleUtil;
import jp.co.central_soft.train2018.view.MenuItem;

//-----------------------------
public class Main
{
    //------------------------------------
    public static void main( String[] args )
    {
    	Main main = new Main();
    	main.exec();
    }

    //------------------------------------
    public void exec()
    {
        MenuItem selectedMenuIten;
        do
        {
            selectedMenuIten = printMenu();             //メニューを表示する
            selectedMenuIten.excecAction();
        }
        while( selectedMenuIten != MenuItem.END );
    }

    //------------------------------------
    private MenuItem printMenu()
    {
        MenuItem menuItem;

        do
        {
        	ConsoleUtil.print(
        			"希望のメニュー番号を入力してください。 "
        			+ "1:終了, 2:登録, 3:全データリスト表示, 4:検索"
        			);

        	int menuNum;
			try
			{
				menuNum = ConsoleUtil.inputIntFromConsole();
			}
			catch( IOException e )
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			//入力された番号に該当するメニュアイテムを取得する
            menuItem = MenuItem.menuItemMap.get( menuNum );
            if( menuItem != null )
                break;
        }
        while( true );

        return menuItem;
    }
}






