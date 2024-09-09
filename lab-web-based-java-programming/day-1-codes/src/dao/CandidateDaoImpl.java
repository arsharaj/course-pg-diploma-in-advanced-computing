package dao;

import static utils.DBUtils.openConnection;
import static utils.DBUtils.closeConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection connection;
	private PreparedStatement firstPst;

	public CandidateDaoImpl() throws SQLException {
		connection = openConnection();
		firstPst = connection.prepareStatement("select * from candidates");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> allCandidates = new ArrayList<>();
		try (ResultSet rst = firstPst.executeQuery()) {
			while (rst.next()) {
				allCandidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return allCandidates;
	}

	public void cleanUp() throws SQLException {
		if (firstPst != null) {
			firstPst.close();
		}
		closeConnection();
	}
}
