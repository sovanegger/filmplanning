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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_scenes")
public class Scene implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.scene.name.notempty}")
	@NotNull(message="{error.scene.name.notnull}")
	@Column(nullable=false)
	private String name;
	
	@Digits(fraction = 0, integer = 3, message="{error.scene.order.digits}")
	private int orderInFilm;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="type")
	private SceneType type;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="filmingday_id")
	private FilmingDay filmingDay;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
	
	@OneToMany(mappedBy="scene", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Usage> usages;
	
	@OneToMany(mappedBy="scene", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Shot> shots;
	
	@OneToMany(mappedBy="scene", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<SceneAttendance> attendances;
	
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

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public SceneType getType() {
		return type;
	}
	public void setType(SceneType type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public Collection<Usage> getUsages() {
		return usages;
	}
	public void setUsages(Collection<Usage> usages) {
		this.usages = usages;
	}

	public Collection<Shot> getShots() {
		return shots;
	}
	public void setShots(Collection<Shot> shots) {
		this.shots = shots;
	}
	
	public Collection<SceneAttendance> getAttendances() {
		return attendances;
	}
	public void setAttendances(Collection<SceneAttendance> attendances) {
		this.attendances = attendances;
	}
	
	public FilmingDay getFilmingDay() {
		return filmingDay;
	}
	public void setFilmingDay(FilmingDay filmingDay) {
		this.filmingDay = filmingDay;
	}
	
	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}
	
	public int getOrderInFilm() {
		return orderInFilm;
	}
	public void setOrderInFilm(int orderInFilm) {
		this.orderInFilm = orderInFilm;
	}
}
