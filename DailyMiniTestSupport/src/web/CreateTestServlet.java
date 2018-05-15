package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.CreateTestService;
import service.Service;
import service.bean.CreateTestBean;

/**
 * Servlet implementation class CreateTestServlet
 */
@WebServlet("/CreateTestServlet")
public class CreateTestServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTestServlet() {
        super();
    }

    public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user)
	{
    	boolean isExistUnrerease = Boolean.parseBoolean( request.getParameter("isExistUnrerease"));
    	CreateTestBean createTestBean =null;


    	CreateTestService createTestService = new CreateTestService();
    	createTestService.start();

    	//作成保存済のテストがある場合
    	if(isExistUnrerease)
    	{
    		createTestBean = createTestService.getUnreleasedTest(user);
    	}
    	else //無い場合
    	{
    		createTestBean = new CreateTestBean();
    		createTestService.getTheme(createTestBean );
    		createTestBean.initForFirstOpen();
    	}


		forward(request,response,"createtest.jsp",createTestBean);
		return createTestService;
	}

}
