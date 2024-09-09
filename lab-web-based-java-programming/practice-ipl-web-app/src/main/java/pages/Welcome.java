package pages;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;


@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamDaoImpl teamDao;
	private PlayerDaoImpl playerDao;

	public void init() throws ServletException {
		try {
			openConnection();
			teamDao = new TeamDaoImpl();
			playerDao = new PlayerDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Cannot open connection.", e);
		}
	}

	public void destroy() {
		try {
			if (playerDao != null) {
				playerDao.cleanUp();
			}
			if (teamDao != null) {
				teamDao.cleanUp();
			}
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("Cannot open connection.", e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()) {
			List<String> teams = teamDao.getTeamsAbbreviations();
			
			HttpSession session = request.getSession();
			session.setAttribute("team_dao", teamDao);
			session.setAttribute("player_dao", playerDao);
			
			if (teamDao != null) {
				pw.write("<h2>Welcome Page</h2>");
				pw.write("<form action='add_player' method='get'> <br>");
				pw.write("Team : <select name='abbr'>");
				for (String team : teams) {
					System.out.println(team);
					pw.write("<option value='"+ team +"'>" + team + "</option>");
				}
				pw.write("</select><br>");
				pw.write("First Name : <input type='text' name='fn'><br>");
				pw.write("Last Name : <input type='text' name='ln'><br>");
				pw.write("DOB : <input type='date' name='dob'><br>");
				pw.write("Batting Average : <input type='text' name='bat_avg'><br>");
				pw.write("Wicket Taken : <input type='number' name='wkt'><br>");
				pw.write("<input type='submit' value='Add Player'><br>");
				pw.write("</form><br>");
			} else {
				pw.write("<h1>Cookies disabled.</h1>");
			}
		}  catch (Exception e) {
			throw new RuntimeException("Cannot open connection.", e);
		}
	}

}
