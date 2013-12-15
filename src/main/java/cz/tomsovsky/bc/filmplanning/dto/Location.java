package cz.tomsovsky.bc.filmplanning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_locations")
public class Location implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.location.name.notempty}")
	@NotNull(message="{error.location.name.notnull}")
	@Column(nullable=false)
	private String name;
	
	private String city;
	private String region;
	private String country;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String description;
	
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

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}
}
