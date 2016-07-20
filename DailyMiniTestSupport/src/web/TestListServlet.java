package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Service;
import service.TestListService;
import service.bean.TestListBean;

/**
 * Servlet implementation class TestListServlet
 */
@WebServlet("/TestListServlet")
public class TestListServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestListServlet() {
        super();
    }

    public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user ) {

    	TestListService testListService = new TestListService();
    	TestListBean testListBean = new TestListBean();
    	int nowPage = 0;

    	// サービススタート
    	testListService.start();

    	// 読込時のみ最初のページは1ページ目
    	if(request.getParameter("linkParameter") == null){
    		nowPage = 1;
    	}else{
    		nowPage = Integer.parseInt(request.getParameter("linkParameter"));
    	}

    	// テストリストを取得する
    	testListBean = testListService.getTestList(nowPage);

    	// テストリスト画面に遷移
    	forward(request,response,"TestList.jsp",testListBean);
		return testListService;
    }
}
