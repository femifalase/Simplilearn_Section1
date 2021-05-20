package ap18.hibernate.studentPhoneNumbers.bidirectional;

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
import ap.commons.hibernate.entities.PhoneNumbersBidirectional;
import ap.commons.hibernate.entities.StudentBidirectional;

/**
 * Servlet implementation class StudentPhoneNumbers
 */
@WebServlet("/PersistStudentServletBidirectional")
public class StudentPhoneNumbersBiDirectionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentPhoneNumbersBiDirectionalServlet() {
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
			Set<PhoneNumbersBidirectional> phoneNumbers = new HashSet<PhoneNumbersBidirectional>();
			PhoneNumbersBidirectional pb = new PhoneNumbersBidirectional("house", "32354353");
			phoneNumbers.add(pb);
			
			String fname = "Dhruvik" + Math.random();
			StudentBidirectional student = new StudentBidirectional(fname, "Parikh", "test@gmail.com", phoneNumbers);
			
			
			pb.setStudent(student);
			
			session.save(pb);
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
