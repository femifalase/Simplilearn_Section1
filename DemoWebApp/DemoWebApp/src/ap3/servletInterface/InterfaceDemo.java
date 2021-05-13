package ap3.servletInterface;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class InterfaceDemo
 */
@WebServlet(name = "InterfaceDemo", urlPatterns = {"/servletInterfaceDemo"})
public class InterfaceDemo implements Servlet {

	ServletConfig config = null;

	public void init(ServletConfig config) {
		this.config = config;
		System.out.println("Initialization complete");
	}

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		System.out.println("Servicing servlet");
		res.setContentType("text/html");
		PrintWriter pwriter = res.getWriter();
		pwriter.print("<html>");
		pwriter.print("<body>");
		pwriter.print("In the service() method<br>");
		pwriter.print("</body>");
		
		
		pwriter.print("</html>");
	}

	public void destroy() {
		System.out.println("In destroy() method");
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		return "This is a sample servlet info";
	}
}
