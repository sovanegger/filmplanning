package cz.tomsovsky.bc.filmplanning.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_crewjobs")
public class CrewJob implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="crewmember_id", nullable=false)
	private CrewMember crewMember;
	
	@ManyToOne
	@JoinColumn(name="crewrole_id", nullable=false)
	private CrewRole crewRole;
	
	@Override
	public long getId() {
		return id;
	}
	
	public CrewMember getCrewMember() {
		return crewMember;
	}
	public void setCrewMember(CrewMember crewMember) {
		this.crewMember = crewMember;
	}
	
	public CrewRole getCrewRole() {
		return crewRole;
	}
	public void setCrewRole(CrewRole crewRole) {
		this.crewRole = crewRole;
	}
}
