package pojos;

public class Candidate {
	private int candidateId;
	private String candidateName;
	private String candidateParty;
	private int votesCount;

	public Candidate(int candidateId, String candidateName, String candidateParty, int votesCount) {
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateParty = candidateParty;
		this.votesCount = votesCount;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateParty() {
		return candidateParty;
	}

	public void setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}

	public int getVotesCount() {
		return votesCount;
	}

	public void setVotesCount(int votesCount) {
		this.votesCount = votesCount;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidateParty="
				+ candidateParty + ", votesCount=" + votesCount + "]";
	}
}
