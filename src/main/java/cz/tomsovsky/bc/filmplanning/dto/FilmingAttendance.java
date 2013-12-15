package cz.tomsovsky.bc.filmplanning.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_filmingattendances")
public class FilmingAttendance implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="filmingday_id", nullable=false)
	private FilmingDay filmingDay;
	
	@ManyToOne
	@JoinColumn(name="crewmember_id", nullable=false)
	private CrewMember crewMember;

	public FilmingDay getFilmingDay() {
		return filmingDay;
	}
	public void setFilmingDay(FilmingDay filmingDay) {
		this.filmingDay = filmingDay;
	}

	public CrewMember getCrewMember() {
		return crewMember;
	}
	public void setCrewMember(CrewMember crewMember) {
		this.crewMember = crewMember;
	}

	public long getId() {
		return id;
	}
}