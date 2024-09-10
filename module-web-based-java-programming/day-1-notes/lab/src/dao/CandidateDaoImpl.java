package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import static utils.DBUtils.*;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1;

	public CandidateDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// pst1 : to get all candidates
		pst1 = cn.prepareStatement("select * from candidates");
		System.out.println("candidate dao created....");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		// create empty List
		List<Candidate> candidates = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("candidate dao cleaned up....");
	}

}
