package ap11.jdbc.productInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ap.commons.jdbc.DBConnection;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet(name = "ProductDetailsServlet", urlPatterns = "/listProducts")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");

			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props = new Properties();
			props.load(in);

			DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"),
					props.getProperty("password"));

			Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			/*PreparedStatement preparedStatement = conn.getConnection()
					.prepareStatement("insert into eproduct (name, price, date_added) values (?, ?, now())");
			preparedStatement.setString(1, "Product_From_PreparedStatement");
			preparedStatement.setBigDecimal(2, new BigDecimal(1500.50));
			preparedStatement.executeUpdate();*/

			/*
			 * stmt.executeUpdate(
			 * "insert into eproduct (name, price, date_added) values ('Dell ABC', 17800.00, now())"
			 * );
			 */

			ResultSet resultSet = stmt.executeQuery("select * from eproduct");

			while (resultSet.next()) {
				out.println(resultSet.getInt("ID") + ", " + resultSet.getString("name") + " "
						+ resultSet.getDate("date_added") + "<Br>");
			}

			stmt.close();

			out.println("</body></html>");
			conn.closeConnection();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
