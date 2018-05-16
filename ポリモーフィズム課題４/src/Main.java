import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//-----------------------------
public class Main
{

    //------------------------------------
    public static void main( String[] args ) throws IOException
    {
    	Main main = new Main();
    	main.exec();
    }


    //------------------------------------
    private static final MenuItem END          = new EndMenuItem("END");
    private static final MenuItem REGIST       = new RegistMenuItem("REGIST");
    private static final MenuItem LISTOUT      = new ListOutMenuItem("LISTOUT");
    private static final MenuItem SEARCH       = new SearchMenuItem("SEARCH");
    private static final Map<Integer, MenuItem> menuItemMap
                                        = new HashMap<Integer, MenuItem>();
	static {
        //メニュー番号ごとのメニューアイテムを登録する
        menuItemMap.put( 1, END     );
        menuItemMap.put( 2, REGIST  );
        menuItemMap.put( 3, LISTOUT );
        menuItemMap.put( 4, SEARCH  );
    }


    //------------------------------------
    public void exec() throws IOException
    {
        MenuItem selectedMenuIten;
        do
        {
            selectedMenuIten = printMenu();             //メニューを表示する
            selectedMenuIten.excecAction();
        }
        while(selectedMenuIten != END );
    }

    //------------------------------------
    private MenuItem printMenu() throws IOException
    {
        MenuItem menuItem;

        do
        {
        	ConsoleUtil.print("希望のメニュー番号を入力してください。 1:終了, 2:登録, 3:全データリスト表示, 4:検索" );
            int menuNum = ConsoleUtil.inputIntFromConsole();
            menuItem = menuItemMap.get( menuNum );  //入力された番号に該当するメニュアイテムを取得する
            if( menuItem != null )
                break;
        }
        while(true);

        return menuItem;
    }
}






