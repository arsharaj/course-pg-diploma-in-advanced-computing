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
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet(value = "/add_player")
public class ValidateAddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get session
			HttpSession session = request.getSession();
			// get daos from session scope
			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
			if (teamDao != null) {
				String abbr = request.getParameter("abbrevation");
				// get selected team details
				Team team = teamDao.getTeamDetails(abbr);
				// get player details from req params
				String playerName = request.getParameter("nm");
				String lastName = request.getParameter("lnm");
				String date = request.getParameter("dob");
				LocalDate dob = LocalDate.parse(date);
				double battingAvg = Double.parseDouble(request.getParameter("avg"));
				int wicketsTaken = Integer.parseInt(request.getParameter("wickets"));
				// validate i/ps
				int age = Period.between(dob, LocalDate.now()).getYears();
				if (age < team.getMaxAge() && battingAvg > team.getMinBattingAvg()
						&& wicketsTaken > team.getMinWicketsTaken()) {
					// all valid i/ps , add the player in the team
					// firstName, String lastName, Date dob,
					// double battingAvg, int wicketsTaken
					Player player = new Player(playerName, lastName, Date.valueOf(dob), battingAvg, wicketsTaken);
					// simply call player dao's method , to insert a rec
					pw.print("<h3> Status " + playerDao.addPlayerToTeam(player, team.getTeamId()) + "</h3>");
				} else
					pw.print("<h3 style color='red;'> Can't add player details , Invalid I/ps</h3>");
			} else
				pw.print("<h5> No Cookies !!!!! Can't continue.....</h5>");
		//	session.invalidate();
		} catch (Exception e) {
			throw new ServletException("err in do-get" + getClass(), e);
		}
	}

}
