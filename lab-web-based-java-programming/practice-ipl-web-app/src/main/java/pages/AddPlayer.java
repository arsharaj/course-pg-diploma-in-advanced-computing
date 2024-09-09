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

@WebServlet("/add_player")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");

			if (teamDao != null) {
				// first_name | last_name | dob | batting_avg | wickets_taken | team_id
				String abbr = request.getParameter("abbr");
				String firstName = request.getParameter("fn");
				String lastName = request.getParameter("ln");
				Date dob = Date.valueOf(request.getParameter("dob"));
				double batAvg = Double.parseDouble(request.getParameter("bat_avg"));
				int wktTaken = Integer.parseInt(request.getParameter("wkt"));
				Team team = teamDao.getTeamDetails(abbr);
				

				int teamId = team.getTeamId();
					System.out.println(team);
								
				Period period = Period.between(dob.toLocalDate(), LocalDate.now());
				if ((period.getYears() <= team.getMaxAge()) && (batAvg >= team.getMinBattingAvg()) && (wktTaken >= team.getMinWicketsTaken())) {
					playerDao.addPlayerToTeam(new Player(firstName, lastName, dob, batAvg, wktTaken, teamId), teamId);
					pw.write("Player added successfully to the team.");
				} else {
					pw.write("Player does not meet the teams requirement" + team.getName());
				}	
			} else {
				pw.write("<h3> Team not found </h3>");
			}
			
		} catch (Exception e) {
			throw new ServletException("Could not add the player to the team.", e);
		}

	}

}
