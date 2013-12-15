package cz.tomsovsky.bc.filmplanning.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_items")
public class Item implements IDomain {
	@Id @GeneratedValue
	private long id;
	
	@NotEmpty(message="{error.item.name.notempty}")
	@NotNull(message="{error.item.name.notnull}")
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="item", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Usage> usages;
	
	@ManyToOne
	@JoinColumn(name="filmproject_id", nullable=false)
	private FilmProject filmProject;
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private ItemType type;
	
	@Override
	public long getId() {
		return id;
	}
	
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
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
