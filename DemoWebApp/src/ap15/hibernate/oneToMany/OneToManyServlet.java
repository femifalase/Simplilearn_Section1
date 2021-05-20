package ap15.hibernate.oneToMany;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ap.commons.hibernate.HibernateUtil;
import ap.commons.hibernate.entities.EProductAnnotated;

/**
 * Servlet implementation class OneToManyServlet
 */
@WebServlet("/OneToManyServlet")
public class OneToManyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OneToManyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			out.println("Hibernate Session opened.<br>");

			List<EProductAnnotated> list = session.createQuery("from EProductAnnotated").list();

			out.println("Hibernate Session closed.<br>");
			out.println("<b>Product Listing</b><br>");
			for (EProductAnnotated p : list) {
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() + ", Price: "
						+ String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString()
						+ "Colors available:" + p.getColors() + "<br>");
			}

			out.println("</body></html>");
			session.close();

		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
