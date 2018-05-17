package jp.co.central_soft.train2018.view;
import jp.co.central_soft.train2018.util.ConsoleUtil;

//-----------------------------
public class EndMenuItem extends MenuItem
{
  public EndMenuItem(String name)
  {
	super(name);
  }

  public void excecAction()
  {
	ConsoleUtil.print("終了します。");
  }
}
