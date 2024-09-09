package pages;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dynamic_page")
public class DynamicPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Sevlet initialized : " + Thread.currentThread());
	}
	
	@Override
	public void destroy() {
		System.out.println("Servet destroyed : " + Thread.currentThread());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get current thread : " + Thread.currentThread());
		resp.getWriter().append("Welcome to Servlets : " + LocalDateTime.now());
	}
}
