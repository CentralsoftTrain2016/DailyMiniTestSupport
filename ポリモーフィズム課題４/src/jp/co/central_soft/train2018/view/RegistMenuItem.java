package jp.co.central_soft.train2018.view;
import java.io.IOException;

import jp.co.central_soft.train2018.dao.ExistException;
import jp.co.central_soft.train2018.dao.Kaiinn;
import jp.co.central_soft.train2018.util.ConsoleUtil;

//-----------------------------
public class RegistMenuItem extends MenuItem
{

  public RegistMenuItem( String name )
  {
	super(name);
  }

  public void excecAction()
  {
	int id = 0;
	try
	{
		ConsoleUtil.print("会員を登録します。IDを入力してください。");
		id = ConsoleUtil.inputIntFromConsole();

		ConsoleUtil.print("名前を入力してください。");
		String name = ConsoleUtil.inputStringFromConsole();

		Kaiinn k = new Kaiinn(id, name );

		this.kaiinnMgr.put(k);
		ConsoleUtil.print("登録が完了しました。:" + k.toString());
	}
	catch( ExistException e )
	{
		ConsoleUtil.print("ご指定のID:" + id + "はすでに使われています。");
	} catch( IOException e )
	{
		e.printStackTrace();
		throw new RuntimeException( e );
	}
  }
}
