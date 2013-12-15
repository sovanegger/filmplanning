package cz.tomsovsky.bc.filmplanning.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_crewmembers")
public class CrewMember implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@OneToMany(mappedBy="crewMember", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<SceneAttendance> sceneAttendances;
	
	@OneToMany(mappedBy="crewMember", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<FilmingAttendance> filmingAttendances;
	
	@OneToMany(mappedBy="crewMember", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<CrewJob> crewJobs;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
	
	@OneToMany(mappedBy="crewMember", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Usage> usages;
	
	@Override
	public long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Collection<SceneAttendance> getSceneAttendances() {
		return sceneAttendances;
	}
	public void setSceneAttendances(Collection<SceneAttendance> sceneAttendances) {
		this.sceneAttendances = sceneAttendances;
	}
	
	public Collection<CrewJob> getCrewJobs() {
		return crewJobs;
	}
	public void setCrewJobs(Collection<CrewJob> crewJobs) {
		this.crewJobs = crewJobs;
	}
	
	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}
	
	public Collection<Usage> getUsages() {
		return usages;
	}
	public void setUsages(Collection<Usage> usages) {
		this.usages = usages;
	}
}
