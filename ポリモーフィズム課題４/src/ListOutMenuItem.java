import java.io.IOException;

//-----------------------------
public	class ListOutMenuItem  extends MenuItem
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
