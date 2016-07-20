package web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.ScoreListService;
import service.Service;
import service.bean.ScoreListBean;

/**
 * Servlet implementation class ScoreListServlet
 */
@WebServlet("/ScoreListServlet")
public class ScoreListServlet extends ServletBase{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreListServlet() {
        super();
    }

	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response, User user) {

		ScoreListService scoreListService = new ScoreListService();
		ScoreListBean scoreListBean = new ScoreListBean();
		int nowPage = 0;
		int flg = 1;
		// サービススタート
		scoreListService.start();

    	// 読込時のみ最初のページは1ページ目
		if(request.getParameter("linkParameter") == null){
			nowPage = 1;
		}else{
			nowPage = Integer.parseInt(request.getParameter("linkParameter"));
		}

		// 並び替え
		String sort = request.getParameter("sort");
		request.setAttribute("sort", sort);

		// 並び替えボタンを押されていたら
		if(sort != null){

			// 日付の降順の場合
			if(sort.equals("dateSortDesc")){
				flg = 1;
			// 日付の昇順
			}else if(sort.equals("dateSortAsc")){
				flg = 2;

			// 名前の降順
			}else if(sort.equals("nameSortDesc")){
				flg = 3;

			// 名前の昇順
			}else if(sort.equals("nameSortAsc")){
				flg = 4;
			}
		}

    	// 点数リストを取得する
		List<User> users = scoreListService.getUserList();

		scoreListBean = scoreListService.getScoreList(nowPage, flg);
		scoreListBean.setUserList(users);

		// 点数一覧画面に遷移
    	forward(request,response,"ScoreList.jsp",scoreListBean);
		return scoreListService;
	}
}
