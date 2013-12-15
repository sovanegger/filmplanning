package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.Authority;
import cz.tomsovsky.bc.filmplanning.dto.CrewMember;
import cz.tomsovsky.bc.filmplanning.dto.FilmProject;
import cz.tomsovsky.bc.filmplanning.dto.User;
import cz.tomsovsky.bc.filmplanning.repository.AuthorityDao;
import cz.tomsovsky.bc.filmplanning.repository.UserDao;
import cz.tomsovsky.bc.filmplanning.service.UserService;

/**
 * Servisní třída entity <code>User</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User getUserByUsername(String username) {
		return (User) userDao.loadUserByUsername(username);		
	}
	
	@Override
	@Transactional
	public void saveUser(User user) {
		user = prepareUser(user);
		userDao.save(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDao.update(user);
	}
	
	@Override
	@Transactional
	public void deleteUser(long id) {
		User user = userDao.getById(id);
		userDao.delete(user);
	}
	
	/**
	 * Vrací všechny filmové projekty, na kterých se podílí daný uživatel
	 * 
	 * @param userId identifikátor uživatele, jehož filmové projekty se zjišťují
	 * @return filmProjects všechny uživatelovy filmové projekty
	 */
	@Override
	@Transactional(readOnly=true)
	public Collection<FilmProject> getUsersFilmProjects(long userId) {
		User user = userDao.getById(userId);
		return prepareUsersFilmProjects(user);
	}
	
	@Override
	@Transactional
	public Collection<FilmProject> getUsersFilmProjects(User user) {
		return prepareUsersFilmProjects(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	private User prepareUser(User user) {
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(authorityDao.getAuthorityByName("ROLE_USER"));
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getUsername()));
		user.setPasswordConfirm(user.getPassword());
		user.setAuthorities(authorities);
		user.setRegistrationDate(new Date());
		return user;
	}
	
	private Collection<FilmProject> prepareUsersFilmProjects(User user) {
		Collection<CrewMember> crewMembers = user.getCrewMembers();
		Collection<FilmProject> filmProjects = new ArrayList<FilmProject>();
		for (CrewMember crewMember : crewMembers) {
			filmProjects.add(crewMember.getFilmProject());
		}
		return filmProjects;
	}
	
	/* MOCK metoda pro pridani admina */
	@Transactional
	public void addAuthorities() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin5187");
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getUsername()));
		user.setPasswordConfirm(user.getPassword());
		user.setEmail("martin.tomsovsky@seznam.cz");
		user.setPhoneNumber("777777777");
		user.setRegistrationDate(new Date());
		Authority a1 = authorityDao.getAuthorityByName("ROLE_USER");
		Authority a2 = authorityDao.getAuthorityByName("ROLE_ADMIN");
		Collection<Authority> auths = new ArrayList<Authority>();
		auths.add(a1);
		auths.add(a2);
		user.setAuthorities(auths);
		userDao.save(user);
	}
}