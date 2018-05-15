package web;

import java.util.ArrayList;
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
 * Servlet implementation class ScoreListSerchServlet
 */
@WebServlet("/ScoreListSerchServlet")
public class ScoreListSerchServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreListSerchServlet() {
        super();
    }

	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response, User user) {

		ScoreListService scoreListService = new ScoreListService();
		ScoreListBean scoreListBean = new ScoreListBean();
		// サービススタート
		scoreListService.start();

		int nowPage1 = Integer.parseInt(request.getParameter("nowpage"));

		// 読込時のみ最初のページは1ページ目
		if(request.getParameter("linkParameter") == null){
			nowPage1 = 1;
		}else{
			nowPage1 = Integer.parseInt(request.getParameter("linkParameter"));
		}

		// パラメータ取得
		String userid = (String)request.getParameter("name");

		List<User> userList = new ArrayList<User>();

		// 選択されたのが全てなら
		if(userid.equals("全て")){
			scoreListBean = scoreListService.getScoreList(nowPage1, 1);

		// 選択されたのが特定のユーザ名なら
		}else{

			// ユーザリストを検索
			for(User users : userList){

				// パラメータと同じユーザ名があれば
				if(users.getUserid().equals(userid)){
					scoreListBean = scoreListService.getScoreList2(nowPage1, users);
					break;
				}
			}
		}

		// 点数一覧画面に遷移
    	forward(request,response,"ScoreList.jsp",scoreListBean);
		return scoreListService;
	}
}
