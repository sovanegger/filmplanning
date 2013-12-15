package cz.tomsovsky.bc.filmplanning.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_filmingdays")
public class FilmingDay implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
		
	@OneToMany(mappedBy="filmingDay", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<FilmingAttendance> filmingAttendances;
	
	@OneToMany(mappedBy="filmingDay", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Scene> scenes;
	
	@Override
	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}

	public Collection<FilmingAttendance> getFilmingAttendances() {
		return filmingAttendances;
	}
	public void setFilmingAttendances(
			Collection<FilmingAttendance> filmingAttendances) {
		this.filmingAttendances = filmingAttendances;
	}

	public Collection<Scene> getScenes() {
		return scenes;
	}
	public void setScenes(Collection<Scene> scenes) {
		this.scenes = scenes;
	}
}