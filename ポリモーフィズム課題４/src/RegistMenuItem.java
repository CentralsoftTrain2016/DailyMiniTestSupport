import java.io.IOException;

//-----------------------------
public class RegistMenuItem extends MenuItem
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
    try
    {
		this.kaiinnMgr.put(k);
	     ConsoleUtil.print("登録が完了しました。:" + k.toString());
	}
    catch (ExistException e)
    {
    	ConsoleUtil.print("ご指定のID:" + id + "はすでに使われています。");
    }

  }
}
