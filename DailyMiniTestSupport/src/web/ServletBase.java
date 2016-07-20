package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Service;
import service.bean.Bean;

/**
 * Servlet implementation class RegistUserServlet
 */
//@WebServlet("/RegistUserServlet")
public abstract class ServletBase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBase() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected final void doGet(
    				HttpServletRequest request,
    				HttpServletResponse response)
    			throws ServletException, IOException
    {
    	Service service = null;
    	User user = (User) request.getSession().getAttribute(User.class.getName());

		try{
			service = myDoGet(request, response, user);
		}
		catch( Throwable t )
		{
			if(service != null)
				service.rollebackEnd();
			throw t;
		}
		finally
		{
			if(service != null){
				service.end();
			}
		}
	}

	public abstract Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user );

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private static final String BEAN_KEY= "bean";
	protected void forward(
			HttpServletRequest request,
			HttpServletResponse response,
			String destination, Bean bean )
	{
		try {
			RequestDispatcher disp = request.getRequestDispatcher(destination);
			request.setAttribute(BEAN_KEY, bean);
			disp.forward(request, response);
		} catch (ServletException  | IOException e) {
			e.printStackTrace();
			throw new RuntimeException( e);
		}
	}

}
