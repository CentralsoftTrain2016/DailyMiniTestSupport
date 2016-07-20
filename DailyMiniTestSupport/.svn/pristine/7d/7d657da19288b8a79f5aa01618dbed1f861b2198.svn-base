package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.value.LoginUserName;
import domain.value.Message;
import domain.value.Password;
import service.LoginService;
import service.Service;
import service.bean.LoginBean;

/**
 * Servlet implementation class LoginLoginServlet
 */
@WebServlet("/LoginLoginServlet")
public class LoginLoginServlet extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLoginServlet() {
        super();
    }

	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user) {

		LoginService loginService = new LoginService();
		LoginBean loginBean = new LoginBean();
		// サービススタート
		loginService.start();

		// Login.jspで入力されたuserIDとpasswordを受け取る
		LoginUserName loginUserName = new LoginUserName(request.getParameter(LoginUserName.class.getName()));
		Password password = new Password(request.getParameter(Password.class.getName()));

		// ログインユーザ名未入力のとき
		if (loginUserName.toString() == null || loginUserName.toString().equals(""))
		{
			loginBean.setMessage(new Message("ログインユーザ名が未入力です"));
			forward(request,response,"login.jsp",loginBean);
			return loginService ;
		//パスワードが未入力のとき
		}
		else if (password.toString() == null || password.toString().equals(""))
		{
			loginBean.setMessage(new Message("パスワードが未入力です"));
			forward(request,response,"login.jsp",loginBean);
			return loginService ;
		}

		loginBean = loginService.getUserByLoginUserNameAndPassword(loginUserName, password);

		if(loginBean.getUser() == null)
		{
			loginBean.setMessage(new Message("パスワードが間違っています"));
			forward(request,response,"login.jsp",loginBean);
			return loginService ;
		}

		request.getSession().setAttribute(User.class.getName(), loginBean.getUser());
		// セッションに入れて、メニューサーブレットに遷移
		forward(request,response,"MenuServlet",loginBean);

		return loginService;
	}

}
