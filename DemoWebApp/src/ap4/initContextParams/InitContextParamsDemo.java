package ap4.initContextParams;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitContextParamsDemo
 */
@WebServlet(name = "/InitContextParamsDemo", urlPatterns = {
		"/initContextParams" }, initParams = @WebInitParam(name = "location", value = "D:/Uploads"))
public class InitContextParamsDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String location = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitContextParamsDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Initializing Only One Time");
		this.location = config.getInitParameter("location");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servicing Servlet - GET method");
		response.getWriter().append("Location From Init Param is :").append(location);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
