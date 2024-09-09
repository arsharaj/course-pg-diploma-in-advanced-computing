package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

@WebServlet("/signup")
public class RegisterVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDaoImpl userDao;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inside init block " + getClass());
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Exception in init block " + getClass(), e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (PrintWriter pw = resp.getWriter()) {
			try {			
					resp.setContentType("text/html");
					
					// Get the user details
					String firstName = req.getParameter("fname");
					String lastName = req.getParameter("lname");
					String email = req.getParameter("em");
					String password = req.getParameter("pass");
					Date dob = Date.valueOf(req.getParameter("dob"));
					
					// Validate the age
					Period period = Period.between(dob.toLocalDate(), LocalDate.now());
					if (period.getYears() < 21) {
						pw.print("Voter's age must be greater than 21");
						throw new ServletException("Voter's age must be greater than 21");
					}
					
					String mesg = userDao.registerNewVoter(new User(firstName, lastName, email, password, dob));
					System.out.println(mesg);
					pw.print("<h3> " + mesg + "</h3>");
			} catch (Exception e) {
				pw.print(e.getMessage());
				throw new ServletException(e.getMessage());
			}
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("Inside destroy block " + getClass());
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("Exception in destroy block " + getClass(), e);
		}
	}
}
