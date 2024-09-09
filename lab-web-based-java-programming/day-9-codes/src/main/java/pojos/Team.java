package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams_tbl")
public class Team {
	// team_id | name | abbrevation | owner | max_age | batting_avg | wickets_taken
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Integer teamId;
	private String name;
	private String abbrevation;
	private String owner;
	@Column(name = "max_age")
	private Integer maxAge;
	@Column(name = "batting_avg")
	private Double battingAvg;
	@Column(name = "wickets_taken")
	private Integer wicketsTaken;

	public Team() {

	}

	public Team(String name, String abbrevation, String owner, Integer maxAge, Double battingAvg,
			Integer wicketsTaken) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public Team(Integer teamId, String abbrevation, String owner, Integer wicketsTaken) {
		super();
		this.teamId = teamId;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.wicketsTaken = wicketsTaken;
	}

	public Team(String name, String owner, Integer wicketsTaken) {
		super();
		this.abbrevation = name;
		this.owner = owner;
		this.wicketsTaken = wicketsTaken;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(Double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public Integer getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}

}
