package jp.co.central_soft.train2018.view;
import java.util.HashMap;
import java.util.Map;

import jp.co.central_soft.train2018.dao.KaiinnMgr;

//-----------------------------
public abstract class MenuItem
{
    //------------------------------------
	public static final MenuItem END          = new EndMenuItem("END");
	public static final MenuItem REGIST       = new RegistMenuItem("REGIST");
	public static final MenuItem LISTOUT      = new ListOutMenuItem("LISTOUT");
	public static final MenuItem SEARCH       = new SearchMenuItem("SEARCH");
    public static final Map<Integer, MenuItem> menuItemMap
                                        = new HashMap<Integer, MenuItem>();
	static {
        //メニュー番号ごとのメニューアイテムを登録する
        menuItemMap.put( 1, END     );
        menuItemMap.put( 2, REGIST  );
        menuItemMap.put( 3, LISTOUT );
        menuItemMap.put( 4, SEARCH  );
    }

  private String name;
  protected KaiinnMgr kaiinnMgr= new KaiinnMgr();

  public MenuItem( String name )
  {
      super();
      this.name = name;
  }
  public String getName()
  {
      return name;
  }

  abstract public void excecAction() ;
}
