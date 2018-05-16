import java.io.IOException;

//-----------------------------
public class EndMenuItem extends MenuItem
{
  public EndMenuItem(String name) {
		super(name);
	}

	public void excecAction() throws IOException
  {
		ConsoleUtil.print("終了します。");
  }

}
