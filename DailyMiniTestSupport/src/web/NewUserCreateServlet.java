package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.value.LoginUserName;
import domain.value.Message;
import domain.value.Password;
import domain.value.UserName;
import service.LoginService;
import service.Service;
import service.bean.LoginBean;
import service.bean.NewUserBean;

/**
 * Servlet implementation class NewUserCreateServlet
 */
@WebServlet("/NewUserCreateServlet")
public class NewUserCreateServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewUserCreateServlet(){
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User suser){


		User user = new User();
		user.setLoginusername(new LoginUserName(request.getParameter(LoginUserName.class.getName())));
		user.setUsername(new UserName(request.getParameter(UserName.class.getName())));
		user.setPassword(new Password(request.getParameter(Password.class.getName())));

		//String userID = request.getParameter("userID");
		//String userName = request.getParameter("userName");
		//String password = request.getParameter("password");

		LoginService loginService = new LoginService();
		NewUserBean newUserBean = new NewUserBean();
		LoginBean loginBean = new LoginBean();

		loginService.start();


		// 名前の入力がない場合は、同じ画面に戻る
		if (user.getLoginusername().toString() == null || user.getLoginusername().toString().equals("")) {
			newUserBean.setIDErrorMessage(new Message("IDを入力してください"));
			forward(request,response,"newuser.jsp",newUserBean);
		}
		if (user.getUsername().toString() == null || user.getUsername().toString().equals("")) {
			newUserBean.setNameErrorMessage(new Message("nameを入力してください"));
			forward(request,response,"newuser.jsp",newUserBean);
		}
		if (user.getPassword().toString() == null || user.getPassword().toString().equals("")) {
			newUserBean.setPasswordErrorMessage(new Message("PASSWORDを入力してください"));
			forward(request,response,"newuser.jsp",newUserBean);
		}

		loginService.createUser(user);

		newUserBean.setUser(user); //User


		forward(request,response,"login.jsp",loginBean);

		return loginService;
	}


}
