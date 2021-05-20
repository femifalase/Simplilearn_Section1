package ap17.hibernate.studentPhoneNumbers.unidirectional;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ap.commons.hibernate.HibernateUtil;
import ap.commons.hibernate.entities.PhoneNumbersUniDirectional;
import ap.commons.hibernate.entities.StudentUniDirectional;

/**
 * Servlet implementation class StudentPhoneNumbers
 */
@WebServlet("/PersistStudentServletUnidirectional")
public class StudentPhoneNumbersUniDirectionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentPhoneNumbersUniDirectionalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Set<PhoneNumbersUniDirectional> phoneNumbers = new HashSet<PhoneNumbersUniDirectional>();
			phoneNumbers.add(new PhoneNumbersUniDirectional("house", "32354353"));
			
			String fname = "Dhruvik" + Math.random();
			StudentUniDirectional student = new StudentUniDirectional(fname, "Parikh", "test@gmail.com", phoneNumbers);

			session.save(student);
			transaction.commit();
			out.println("Record with name : " + fname + " Saved successfully.");

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
