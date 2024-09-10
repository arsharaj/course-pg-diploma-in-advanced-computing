package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	// doGet
	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in candidate list page ");
		// 1. set resp cont type
		rs.setContentType("text/html");
		// 2. get PW : to send resp from servlet ---> web clnt
		try (PrintWriter pw = rs.getWriter()) {
			// generate dyn cont (add dyn contents to buffer of PW
			pw.print("<h5>Welcome Voter </h5>");
			// send validated user details retrieved from HttpSession
			// 1. get HttpSession from WC
			HttpSession session = rq.getSession();
			// debug/understanding
			System.out.println("From list page : Session is new " + session.isNew());// f => cookies are enabled , t =>
			// cookies are blocked
			System.out.println("Session ID " + session.getId());// same : enabled cookies or different : blocked
			// 2. get user details from session scope
			User validUser = (User) session.getAttribute("clnt_details");
			if (validUser != null)
				pw.print("<h4> User details via HttpSession " + validUser + "</h4>");
			else
				pw.print("<h4> Session Tracking failed !!!!!!! No cookies.....</h4>");

		}
	}

}
