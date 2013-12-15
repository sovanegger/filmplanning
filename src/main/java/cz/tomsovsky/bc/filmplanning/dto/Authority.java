package cz.tomsovsky.bc.filmplanning.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="tb_authorities")
public class Authority implements IDomain, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.authority.name.notempty}")
	@NotNull(message="{error.authority.name.notnull}")
	@Column(nullable=false)
	private String authority;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String description;
	
	@ManyToMany(mappedBy="authorities", cascade=CascadeType.ALL)
	private Collection<User> users;
	
	@Override
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}