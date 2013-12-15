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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cz.tomsovsky.bc.filmplanning.validation.Field;
import cz.tomsovsky.bc.filmplanning.validation.FieldMatch;
import cz.tomsovsky.bc.filmplanning.validation.FieldUniqueness;

@Entity
@Table(name="tb_users")
@FieldUniqueness(fields=@Field(fieldName="username", errorMessage="{error.user.username.notunique}"))
@FieldMatch.List({
	@FieldMatch(first = "password" , second = "passwordConfirm", message = "{error.user.password.notequal}")
})
public class User implements UserDetails, IDomain {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="{error.user.username.notempty}")
	@NotNull(message="{error.user.username.notnull}")
	@Size(min=3, max=20, message="{error.user.username.length}")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="{error.user.username.alphanumeric}")
	@Column(nullable=false, unique=true)
	private String username;
	
	@NotEmpty(message="{error.user.password.notempty}")
	@NotNull(message="{error.user.password.notnull}")
	@Size(min=6, message="{error.user.password.length}")
	@Column(nullable=false)
	private String password;
	
	@NotEmpty(message="{error.user.email.notempty}")
	@NotNull(message="{error.user.email.notnull}")
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="{error.user.email.invalid}")
	@Column(nullable=false)
	private String email;

	@NotEmpty(message="{error.user.phonenumber.notempty}")
	@NotNull(message="{error.user.phonenumber.notnull}")
	@Pattern(regexp="\\+?[0-9]+", message="{error.user.phonenumber.invalid}")
	@Size(max=30, message="{error.user.phonenumber.length}")
	@Column(nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	private String firstname;
	private String surname;
	private boolean enabled=true;
	
	// TODO tohle je pres ruku
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Collection<CrewMember> crewMembers;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="tb_users_authorities", 
		joinColumns=@JoinColumn(name="user_id"), 
		inverseJoinColumns=@JoinColumn(name="authority_id"))
	private Collection<Authority> authorities;
	
	@Transient
	private String passwordConfirm;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public Collection<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	public void setCrewMembers(Collection<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
}