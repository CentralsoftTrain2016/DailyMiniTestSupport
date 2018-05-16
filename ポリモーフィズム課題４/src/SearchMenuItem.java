import java.io.IOException;

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
