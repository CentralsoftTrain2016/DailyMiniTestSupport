package jp.co.central_soft.train2018.view;
import java.io.IOException;

import jp.co.central_soft.train2018.dao.Kaiinn;
import jp.co.central_soft.train2018.util.ConsoleUtil;

//-----------------------------
public class SearchMenuItem  extends MenuItem
{

  public SearchMenuItem(String name)
  {
	super( name );
  }

  public void excecAction()
  {
	  ConsoleUtil.print("会員を検索します。IDを入力してください。");
      int id;
      try
      {
		id = ConsoleUtil.inputIntFromConsole();
      }
      catch( IOException e )
      {
		e.printStackTrace();
		throw new RuntimeException(e);
      }

      Kaiinn kaiinn = this.kaiinnMgr.get(id);
      if( kaiinn == null )
      {
    	  ConsoleUtil.print("id:"+ id + "で指定された会員はそんざいしません。" );
      	return;
      }
      ConsoleUtil.print("検索した会員の情報です。:" + kaiinn.toString());
  }
}
