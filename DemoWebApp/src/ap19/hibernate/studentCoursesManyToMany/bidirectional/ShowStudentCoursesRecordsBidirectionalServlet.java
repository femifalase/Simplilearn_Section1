package ap19.hibernate.studentCoursesManyToMany.bidirectional;

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
import ap.commons.hibernate.entities.StudentManyBiDirectional;

/**
 * Servlet implementation class StudentPhoneNumbers
 */
@WebServlet("/ShowStudentCoursesServlet")
public class ShowStudentCoursesRecordsBidirectionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudentCoursesRecordsBidirectionalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>" + "<style>" + "table, th, td {" + "  border: 1px solid black;" + "}"
				+ "</style>" + "</head>" + "<body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		try {

			List<StudentManyBiDirectional> list = session.createQuery("from StudentManyBiDirectional").list();

			if (list != null && list.size() > 0) {
				out.println("<table style=\"width:100%\">");
				out.println("<tr>" + "    <th>StudentId</th>" + "    <th>Firstname</th>" + "    <th>Lastname</th>"
						+ "    <th>EmailId</th>" + "    <th>StudentPhoneNumbers</th>" + "  </tr>");
				for (StudentManyBiDirectional s : list) {
					out.println("<tr>");
					out.println("<td>" + s.getStudentId() + "</td>");
					out.println("<td>" + s.getFname() + "</td>");
					out.println("<td>" + s.getLname() + "</td>");
					out.println("<td>" + s.getEmailId() + "</td>");
					out.println("<td>" + s.getCourses() + "</td>");
					out.println("</tr>");
				}
			}
			out.println("</body></html>");
		} catch (Exception ex) {
			throw ex;
		} finally {
			session.close();
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
