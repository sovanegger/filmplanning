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
@Table(name="tb_reactions")
public class Reaction implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.reaction.text.notempty}")
	@NotNull(message="{error.reaction.text.notnull}")
	@Lob
	@Type(type="org.hibernate.type.TextType")
	@Column(nullable=false)
	private String text;
	
	@ManyToOne
	@JoinColumn(name="post_id", nullable=false)
	private Post post;
	
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
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
