package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.value.Message;
import service.MenuService;
import service.Service;
import service.bean.MenuBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
    }

    public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user) {

    	MenuService menuService = new MenuService();
    	MenuBean menuBean = new MenuBean();
    	// サービススタート
    	menuService.start();



    	// テストが作成中かどうか判断する
    	boolean isExist = menuService.isExistUnreleasedTest(user);

    	// テストが作成中だったら
    	if(isExist){
    		menuBean.setMessage(new Message("保存済みのテストがあります"));
    	}

    	menuBean.setIsExistUnRease(isExist);
    	menuBean.setUser(user);

    	// メニュー画面に遷移
    	forward(request,response,"menu.jsp",menuBean);
    	return null;
    }

}
