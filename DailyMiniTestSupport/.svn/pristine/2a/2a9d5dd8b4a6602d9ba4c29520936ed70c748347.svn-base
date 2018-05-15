package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Service;
import service.TestService;
import service.bean.TestBean;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	public Service myDoGet(HttpServletRequest request, HttpServletResponse response, User user) {

		TestService testService = new TestService();
		TestBean testBean = new TestBean();
		// サービススタート
		testService.start();

		// テストリスト画面に遷移
    	forward(request,response,"Test.jsp",testBean);
		return testService;
	}

}
