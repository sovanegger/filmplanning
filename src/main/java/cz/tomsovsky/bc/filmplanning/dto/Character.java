package cz.tomsovsky.bc.filmplanning.dto;

import java.util.Collection;

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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_characters")
public class Character implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.character.name.notempty}")
	@NotNull(message="{error.character.name.notnull}")
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="character", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<SceneAttendance> attendances;
	
	@OneToMany(mappedBy="character", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Usage> usages;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
	
	@Override
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Collection<SceneAttendance> getAttendances() {
		return attendances;
	}
	public void setAttendances(Collection<SceneAttendance> attendances) {
		this.attendances = attendances;
	}
	
	public Collection<Usage> getUsages() {
		return usages;
	}
	public void setUsages(Collection<Usage> usages) {
		this.usages = usages;
	}
	
	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}
}
