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

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_filmprojects")
@DynamicUpdate
public class FilmProject implements IAclDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.filmproject.title.notempty}")
	@NotNull(message="{error.filmproject.title.notnull}")
	@Column(nullable=false)
	private String title;
	
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<CrewMember> crewMembers;
	
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Character> characters;
	
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Post> posts;
	
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<FilmingDay> filmingDays;
	
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Item> items;
	
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Scene> scenes;
	
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Location> locations;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String screenplay;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Collection<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	public void setCrewMembers(Collection<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	
	public Collection<Character> getCharacters() {
		return characters;
	}
	public void setCharacters(Collection<Character> characters) {
		this.characters = characters;
	}
	
	public Collection<Post> getPosts() {
		return posts;
	}
	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}
	
	public Collection<FilmingDay> getFilmingDays() {
		return filmingDays;
	}
	public void setFilmingDays(Collection<FilmingDay> filmingDays) {
		this.filmingDays = filmingDays;
	}
	
	public Collection<Item> getItems() {
		return items;
	}
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
	
	public Collection<Scene> getScenes() {
		return scenes;
	}
	public void setScenes(Collection<Scene> scenes) {
		this.scenes = scenes;
	}
	
	public Collection<Location> getLocations() {
		return locations;
	}
	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}
	
	public String getScreenplay() {
		return screenplay;
	}
	public void setScreenplay(String screenplay) {
		this.screenplay = screenplay;
	}
}
