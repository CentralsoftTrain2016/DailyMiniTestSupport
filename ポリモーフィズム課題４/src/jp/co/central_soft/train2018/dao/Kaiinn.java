package jp.co.central_soft.train2018.dao;

import java.util.Date;

//---------------------------------------------
//会員クラス
public	class Kaiinn
{
  private int kaiinNo;
  private String name;
  private Date registDate;

  //コンストラクタ　(new 演算子実行時に呼ばれる)
  public Kaiinn( int kaiinNo, String  name  )
  {
      this.kaiinNo    = kaiinNo;        //会員番号
      this.name       = name;       //名前
      this.registDate = new Date(); //登録日時
  }
  //コンストラクタ　(new 演算子実行時に呼ばれる)
  public Kaiinn( int kaiinNo, String  name, Date d  )
  {
      this.kaiinNo    = kaiinNo;        //会員番号
      this.name       = name;       //名前
      this.registDate = d; //登録日時
  }

  public int getKaiinNo() {
	return kaiinNo;
  }

  public String getName() {
	return name;
  }

  public Date getRegistDate() {
	return registDate;
  }

  //保持しているデータを文字列化して出力する
  public String toString()
  {
      return(
          "会員番号："   + this.kaiinNo
          + ", 氏名："    + this.name
          + ", 登録日時：" + this.registDate.toString()
      );
  }


}