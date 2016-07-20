package web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.value.Message;
import service.SampleService;
import service.Service;
import service.bean.SampleBean;

@WebServlet("/SampleServlet")
public class SampleServlet extends ServletBase {

	@Override
	public Service myDoGet(HttpServletRequest request, HttpServletResponse response,User user)
	{
		String messageStr = request.getParameter(Message.class.getName());
		Message message=null;
		if(messageStr !=null )
			message= Message.getInstanceWithMaintain(
					messageStr,
					Message.class
					);

		System.out.println(message);

		SampleService sampleService= new SampleService();
		sampleService.start();

		SampleBean sampleBean= sampleService.doSometing();

		forward(request,response,"Sample.jsp",sampleBean);
		return sampleService;
	}

}
