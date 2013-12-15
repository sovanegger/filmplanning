package cz.tomsovsky.bc.filmplanning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_scenetypes")
public class SceneType implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.scenetype.abbrevation.notempty}")
	@NotNull(message="{error.scenetype.abbrevation.notnull}")
	@Column(nullable=false)
	private String abbrevation;
	
	@NotEmpty(message="{error.scenetype.name.notempty}")
	@NotNull(message="{error.scenetype.name.notnull}")
	@Column(nullable=false)
	private String name;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String description;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getAbbrevation() {
		return abbrevation;
	}
	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
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
}
