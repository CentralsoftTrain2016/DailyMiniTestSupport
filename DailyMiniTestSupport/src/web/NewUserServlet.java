package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Service;
import service.bean.NewUserBean;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet  extends ServletBase {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user) {
		NewUserBean newUserBean = new NewUserBean();
		forward(request,response,"newuser.jsp",newUserBean);
		return null;
	}

}
