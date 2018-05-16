import java.io.IOException;

//-----------------------------
public abstract class MenuItem
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
