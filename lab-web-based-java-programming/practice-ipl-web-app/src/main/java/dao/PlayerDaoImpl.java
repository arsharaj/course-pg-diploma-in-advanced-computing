package dao;

import static utils.DBUtils.getCn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {
	private Connection connection;
	private PreparedStatement pst;

	
	
	public PlayerDaoImpl() throws SQLException {
		super();
		connection = getCn();
		//	 player_id | first_name | last_name | dob  | batting_avg | wickets_taken | team_id |	
		pst = connection.prepareStatement(" insert into players values (default, ?, ?, ?, ?, ?, ?)");
		System.out.println("In Player Dao constructor");
	}



	@Override
	public String addPlayerToTeam(Player newPlayer, int teamId) throws SQLException {
		pst.setString(1, newPlayer.getFirstName());
		pst.setString(2, newPlayer.getLastName());
		pst.setDate(3, newPlayer.getDob());
		pst.setDouble(4, newPlayer.getBattingAvg());
		pst.setInt(5, newPlayer.getWicketsTaken());
		pst.setInt(6, teamId);
		int rowCount = pst.executeUpdate();
		if (rowCount == 1) {
			return "Player added to the specified team";
		} else {
			return "Player does not match the requirements.";
		}
	}
	
	public void cleanUp() throws SQLException {
		if (pst != null) {
			pst.close();
		}
		System.out.println("Player Dao cleaned up.");
	}

}
