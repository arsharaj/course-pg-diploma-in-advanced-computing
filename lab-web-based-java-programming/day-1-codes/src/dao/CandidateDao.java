package dao;

import java.util.List;
import java.sql.SQLException;

import pojos.Candidate;

public interface CandidateDao {
	List<Candidate> getAllCandidates() throws SQLException;
}
