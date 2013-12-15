package cz.tomsovsky.bc.filmplanning.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_crewroles")
public class CrewRole implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.crewrole.name.notempty}")
	@NotNull(message="{error.crewrole.name.notnull}")
	@Column(nullable=false)
	private String name;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String description;
	
	@OneToMany(mappedBy="crewRole", cascade=CascadeType.ALL , fetch=FetchType.LAZY)
	private Collection<CrewJob> crewJobs;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<CrewJob> getCrewJobs() {
		return crewJobs;
	}
	public void setCrewJobs(Collection<CrewJob> crewJobs) {
		this.crewJobs = crewJobs;
	}
}
