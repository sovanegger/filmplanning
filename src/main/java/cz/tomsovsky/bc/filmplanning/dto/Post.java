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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_posts")
public class Post implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.post.text.notempty}")
	@NotNull(message="{error.post.text.notnull}")
	@Lob
	@Type(type="org.hibernate.type.TextType")
	@Column(nullable=false)
	private String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dateTime;
	
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Reaction> reactions;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
	
	@Override
	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public Collection<Reaction> getReactions() {
		return reactions;
	}
	public void setReactions(Collection<Reaction> reactions) {
		this.reactions = reactions;
	}
	
	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}
}
