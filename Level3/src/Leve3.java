import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
//------------------
function disp( s, target )
{
    document.getElementById(target).textContent
      = document.getElementById(target).textContent + s + "\n";
}
//------------------
class Gogyo
{
    constructor( kanjia, hiraganaa )
    {
        this.kanji      = kanjia;
        this.hiragana   = hiraganaa;
    }

    toString()
    {

        return "漢字:" + this.kanji + "ひらがな:" + this.hiragana;
    }
}
//------------------
class Eto
{
    constructor( kanjia, hiraganaa )
    {
        this.kanji      = kanjia;
        this.hiragana   = hiraganaa;
    }

    toString()
    {
        return "漢字:" + this.kanji + "ひらがな:" + this.hiragana;
    }
}
//------------------
function getJikkan( seinen )
{
    const gogyos =
        [
            new Gogyo("庚", "かのえ" ),
            new Gogyo("辛", "かのと" ),
            new Gogyo("壬", "みずのと" ),
            new Gogyo("癸", "みずのと" ),
            new Gogyo("甲", "きのえ" ),
            new Gogyo("乙", "きのと" ),
            new Gogyo("丙", "ひのえ" ),
            new Gogyo("丁", "ひのと" ),
            new Gogyo("戊", "つちのえ" ),
            new Gogyo("己", "つちのと" )
        ];

    return gogyos[seinen % 10] ;
}

function getJunishi( seinen )
{
    const etos =
    [
        new Eto("申", "さる" ),
        new Eto("酉", "とり" ),
        new Eto("戌", "いぬ" ),
        new Eto("亥", "い" ),
        new Eto("子", "ね" ),
        new Eto("丑", "うし" ),
        new Eto("寅", "とら" ),
        new Eto("卯", "う" ),
        new Eto("辰", "たつ" ),
        new Eto("巳", "み" ),
        new Eto("午", "うま" ),
        new Eto("未", "ひつじ" )
    ];
    return etos[ seinen % 12 ]
}

function main()
{
    let text1   = document.enshuForm3.textInput1.value;
    let seinen  = Number( text1 ) ;
    let jikkan  = getJikkan( seinen );
    let junishi = getJunishi( seinen );

    let etoStr =  seinen + "年の干支は" + jikkan.kanji + junishi.kanji
        + "(" + jikkan.hiragana + junishi.hiragana + ")";
    disp( etoStr, "str3" );
}
*/
public class Leve3
{
	private static final Gogyo gogyos[] =
		{
            new Gogyo("庚", "かのえ" ),
            new Gogyo("辛", "かのと" ),
            new Gogyo("壬", "みずのと" ),
            new Gogyo("癸", "みずのと" ),
            new Gogyo("甲", "きのえ" ),
            new Gogyo("乙", "きのと" ),
            new Gogyo("丙", "ひのえ" ),
            new Gogyo("丁", "ひのと" ),
            new Gogyo("戊", "つちのえ" ),
            new Gogyo("己", "つちのと" )
		};
	private static final Eto etos[]=
		{
		    new Eto("申", "さる" ),
		    new Eto("酉", "とり" ),
		    new Eto("戌", "いぬ" ),
		    new Eto("亥", "い" ),
		    new Eto("子", "ね" ),
		    new Eto("丑", "うし" ),
		    new Eto("寅", "とら" ),
		    new Eto("卯", "う" ),
		    new Eto("辰", "たつ" ),
		    new Eto("巳", "み" ),
		    new Eto("午", "うま" ),
		    new Eto("未", "ひつじ" )
		};
	//------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		Leve3 l3 = new Leve3();
		l3.exec();
	}

	//------------------------------------------------------
	private void exec() throws IOException
	{
		print("年号を数値で入力してください。");
		int seinen = inputFromConsole();
		Gogyo jikkan  = getJikkan( seinen );
	    Eto junishi = getJunishi( seinen );

	    String etoStr =  seinen + "年の干支は"
	    		+ jikkan.getKanji() + junishi.getKanji()
	        + "(" + jikkan.getHiragana() + junishi.getHiragana() + ")";
	    print( etoStr );
	}

	//------------------------------------------------------
	private Eto getJunishi(int seinen) {
	    return etos[ seinen % 12 ];
	}

	//------------------------------------------------------
	private Gogyo getJikkan(int seinen) {
	    return gogyos[seinen % 10] ;

	}

	//-----------------------------
	//	コンソールから数値を入力する
	private int inputFromConsole() throws IOException
	{
		InputStreamReader id = new InputStreamReader( System.in );
		BufferedReader br = new BufferedReader( id );
		String buf = null;
		int ret =0;

		boolean isOK =false;
		do
		{
			try
			{
				buf = br.readLine();
				ret = Integer.parseInt(buf);
				isOK =true;
			}
			catch(NumberFormatException e)
			{
				print("数値エラーです。年号を数値で入力してください。");
			}
		}
		while(!isOK);



		return ret;

	}
	//-----------------------------
	private void print(String str)
	{
		System.out.println(str);

	}
}

class Gogyo
{
    //constructor( kanjia, hiraganaa )
	public Gogyo( String kanjia, String hiraganaa )
	{
        this.kanji      = kanjia;
        this.hiragana   = hiraganaa;
    }
	private String kanji;
	private String hiragana;


	public String getKanji() {
		return kanji;
	}

	public void setKanji(String kanji)
	{
		this.kanji = kanji;
	}

	public String getHiragana() {
		return hiragana;
	}

	public void setHiragana(String hiragana) {
		this.hiragana = hiragana;
	}

	public String toString()
    {

        return "漢字:" + this.kanji + "ひらがな:" + this.hiragana;
    }
}
//------------------
class Eto
{
	public Eto( String kanjia,  String hiraganaa )
	{
		this.kanji      = kanjia;
		this.hiragana   = hiraganaa;
	}
	private String kanji;
	private String hiragana;


	public String getKanji() {
		return kanji;
	}

	public void setKanji(String kanji)
	{
		this.kanji = kanji;
	}

	public String getHiragana() {
		return hiragana;
	}

	public void setHiragana(String hiragana) {
		this.hiragana = hiragana;
	}


  public String toString()
  {
      return "漢字:" + this.kanji + "ひらがな:" + this.hiragana;
  }
}
