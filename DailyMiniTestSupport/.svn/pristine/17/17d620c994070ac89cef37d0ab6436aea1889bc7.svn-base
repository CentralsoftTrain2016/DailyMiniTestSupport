package service.bean;

import java.util.ArrayList;
import java.util.List;

public class PagingBean extends Bean{

//	String servletURL = "";
//	int nowPage = 1;			// 最初だけ1ページ目
//	int allPage = 2;

	// コンストラクタ
	public PagingBean(){
		super();
	}

	// 現在のページの前のページを取得
	// [前へ] 1 2 3 4 5 6 7 8 9 10 次へ
	public String getBeforePage(int nowPage, String servletURL){

		// 現在のページが1ページの場合
		if(nowPage == 1){

			// 前へを押せなくする処理
			return "前へ&nbsp;";

		// 現在のページの前にページが存在する場合
		}else{
			return "<a href = \"" + servletURL + "?linkParameter=" + (nowPage - 1) + "\">前へ&nbsp;</a>";
		}
	}

	// 現在のページの次のページを取得
	// 前へ 1 2 3 4 5 6 7 8 9 10 [次へ]
	public String getNextPage(int nowPage, int allPage, String servletURL){

		// 現在のページが最後のページの場合
		if(nowPage == allPage){

			// 次へを押せなくする処理
			return "&nbsp;次へ";

		// 現在のページの次にページが存在する場合
		}else{
			return "<a href = \"" + servletURL + "?linkParameter=" + (nowPage + 1) + "\">&nbsp;次へ</a>";
		}
	}

	// 選択したページを取得
	// 前へ 1 2 3 4 5 [6] 7 8 9 10 次へ
	public String getSelectPage(int nowPage, int allPage, String servletURL){

		StringBuffer sb = new StringBuffer();
		List<Integer> numberRangeList = getPageShowRange(nowPage, allPage);

		String linking;

		// リストの数字にリンクを作成する
		for(int number : numberRangeList){
			if(number != nowPage){
				sb.append("<a href = \"").append(servletURL).append("?linkParameter=")
										.append(number).append("\">&nbsp;").append(number).append("&nbsp;</a>");
			}else{
				sb.append(number);
			}
		}
		linking = sb.toString();
		return linking;
	}

	// 現在のページから指定したページ分を取得
	// 2 3 4 5 6 [7] 8 9 10 11 12
	public List<Integer> getPageShowRange(int nowPage, int allPage){

		int pageFrontRange = 5;	// 前範囲
		int pageBackRange = 4;	// 後範囲

		// 表示する数字のリスト
		List<Integer> numberRangeList = new ArrayList<Integer>();

//		// 全ページ数が10ページ以下の場合
//		if(allPage <= pageNumber){
//			for(int i = 1;i <= allPage;i++){
//				numberRangeList.add(i);
//			}
//
//		// 現在のページから最後のページまでの範囲が後範囲
//		}else if(nowPage + pageBackRange >= allPage){
//
//			// 全ページの-9から前ページ
//			for(int i = allPage - (pageNumber - 1);i <= allPage;i++){
//				numberRangeList.add(i);
//			}
//		}

		// 最後
		int end = nowPage + pageBackRange;

		// 最初
		int start = nowPage - pageFrontRange;

		if(end > allPage){
			end = allPage;
		}

		if(start < 1){
			start = 1;
		}

		for(int i = start;i <= end;i++){
			numberRangeList.add(i);
		}
		return numberRangeList;
	}

//	// ナンバーリストを作成
//	// 1 2 3 4 5 6 7 8 9 10
//	public List<Integer> createNumberList(){
//
//		List<Integer> numberList = new ArrayList<Integer>();
//
//		// 1から全ページ数の数値をリストに追加
//		for(int i = 1;i <= allPage;i++){
//			numberList.add(i);
//		}
//		return numberList;
//	}
}
