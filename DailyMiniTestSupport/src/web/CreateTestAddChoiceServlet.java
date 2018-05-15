package web;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.value.Enum.CreateTestSubmitTypeEnum;
import service.CreateTestService;
import service.Service;
import service.bean.CreateTestBean;

/**
 * Servlet implementation class CreateTestAddChoiceServlet
 */
@WebServlet("/CreateTestAddChoiceServlet")
public class CreateTestAddChoiceServlet extends ServletBase implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see ServletBase#ServletBase()
     */
    public CreateTestAddChoiceServlet() {
        super();
    }


	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user )
	{
    	CreateTestService createTestService = new CreateTestService();
    	createTestService.start();

		CreateTestBean createTestBean = new CreateTestBean();
		createTestService.getTheme(createTestBean);
		createTestBean.setFromPrameter(request.getParameterMap(),user);

		//どのサブミットが押されたかを取得
		CreateTestSubmitTypeEnum submitType =  CreateTestSubmitTypeEnum.valueOfMap(request.getParameterMap());

		//ボタンによる処理の分岐
		String url = createTestService.doSubmitAction(submitType, createTestBean, user);


		forward(request,response,url,createTestBean);
		return createTestService;
	}

}
