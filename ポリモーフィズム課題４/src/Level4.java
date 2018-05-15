
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


	//-----------------------------
	public class Level4
	{

	    //------------------------------------
	    public static void main( String[] args ) throws IOException
	    {
	        Level4 l4 = new Level4();
	        l4.exec();
	    }

	    //------------------------------------
	    private final MenuItem END          = new EndMenuItem("END");
	    private final MenuItem REGIST       = new RegistMenuItem("REGIST");
	    private final MenuItem LISTOUT      = new ListOutMenuItem("LISTOUT");
	    private final MenuItem SEARCH       = new SearchMenuItem("SEARCH");
	    private final HashMap<Integer, MenuItem> menuItemMap
	                                        = new HashMap<Integer, MenuItem>();
	    private HashMap<Integer, Kaiinn> kaiinDB
	                                        = new HashMap<Integer, Kaiinn>();;

	    //------------------------------------
	    public Level4()
	    {
	        //メニュー番号ごとのメニューアイテムを登録する
	        menuItemMap.put( 1, END     );
	        menuItemMap.put( 2, REGIST  );
	        menuItemMap.put( 3, LISTOUT );
	        menuItemMap.put( 4, SEARCH  );
	    }

	    //------------------------------------
	    public HashMap<Integer, Kaiinn>  getKaiinDB()
	    {
	        return kaiinDB;
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

	//-----------------------------
	class ConsoleUtil
	{
	    //------------------------------------
	    protected static void print( String str )
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

	//-----------------------------
	abstract class MenuItem
	{
	  private String name;
	  protected KaiinnMgr kaiinnMgr= new KaiinnMgr();

	  public MenuItem( String name )
	  {
	      super();
	      this.name = name;
	  }
	  public String getName() {
	      return name;
	  }

	  abstract public void excecAction() throws IOException;
	}

	//-----------------------------
	class EndMenuItem extends MenuItem
	{
	  public EndMenuItem(String name) {
			super(name);
		}

		public void excecAction() throws IOException
	  {
			ConsoleUtil.print("終了します。");
	  }

	}

	//-----------------------------
	class RegistMenuItem extends MenuItem
	{

	  public RegistMenuItem( String name )
	  {
		super(name);
	  }

	  public void excecAction() throws IOException
	  {
		  ConsoleUtil.print("会員を登録します。IDを入力してください。");
	      int id = ConsoleUtil.inputIntFromConsole();

	      ConsoleUtil.print("名前を入力してください。");
	      String name = ConsoleUtil.inputStringFromConsole();

	      Kaiinn k = new Kaiinn(id, name );
	      this.kaiinnMgr.put(k);
	      ConsoleUtil.print("登録が完了しました。:" + k.toString());
	  }
	}

	//-----------------------------
	class ListOutMenuItem  extends MenuItem
	{
	  public ListOutMenuItem( String name )
	  {
			super( name );
	  }

	  public void excecAction() throws IOException
	  {
		  ConsoleUtil.print("会員の全リストを出力します。");
		  for( Kaiinn k: this.kaiinnMgr.values() )
		  {
		     ConsoleUtil.print( k.toString() );
		  }
	  }
	}
	//-----------------------------
	class SearchMenuItem  extends MenuItem
	{

	  public SearchMenuItem(String name)
	  {
		super( name );
	  }

	  public void excecAction() throws IOException
	  {
		  ConsoleUtil.print("会員を検索します。IDを入力してください。");
	      int id = ConsoleUtil.inputIntFromConsole();

	      Kaiinn kaiinn = this.kaiinnMgr.get(id);
	      if( kaiinn == null )
	      {
	    	  ConsoleUtil.print("id:"+ id + "で指定された会員はそんざいしません。" );
	      	return;
	      }
	      ConsoleUtil.print("検索した会員の情報です。:" + kaiinn.toString());
	  }
	}
	//---------------------------------------------
	//会員管理
	class KaiinnMgr
	{
		private static Map<Integer, Kaiinn > kaiinDB
			= new HashMap<Integer, Kaiinn >();

		public void put( Kaiinn k )
		{
			kaiinDB.put(k.getKaiinNo(), k);
		}

		public Kaiinn get( int kaiinNo )
		{
			return kaiinDB.get(kaiinNo);
		}

		public Collection<Kaiinn> values()
		{
			return kaiinDB.values();
		}
	}

	//---------------------------------------------
	//会員クラス
	class Kaiinn
	{
	  private int kaiinNo;
	  private String name;
	  private Date registDate;

	  //コンストラクタ　(new 演算子実行時に呼ばれる)
	  public Kaiinn( int kaiinNo, String  name  )
	  {
	      this.kaiinNo    = kaiinNo;        //会員番号
	      this.name       = name;       //名前
	      this.registDate = new Date(); //登録日時
	  }

	  public int getKaiinNo() {
		return kaiinNo;
	  }

	  public String getName() {
		return name;
	  }

	  public Date getRegistDate() {
		return registDate;
	  }

	  //保持しているデータを文字列化して出力する
	  public String toString()
	  {
	      return(
	          "会員番号："   + this.kaiinNo
	          + ", 氏名："    + this.name
	          + ", 登録日時：" + this.registDate.toString()
	      );
	  }
	}