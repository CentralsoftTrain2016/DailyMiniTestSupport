package jp.co.central_soft.train2018.view;
import jp.co.central_soft.train2018.dao.Kaiinn;
import jp.co.central_soft.train2018.util.ConsoleUtil;

//-----------------------------
public	class ListOutMenuItem  extends MenuItem
{
  public ListOutMenuItem( String name )
  {
		super( name );
  }

  public void excecAction()
  {
	  ConsoleUtil.print("会員の全リストを出力します。");
	  for( Kaiinn k: this.kaiinnMgr.values() )
	  {
	     ConsoleUtil.print( k.toString() );
	  }
  }
}
