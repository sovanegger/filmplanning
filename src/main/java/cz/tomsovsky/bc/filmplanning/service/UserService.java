package cz.tomsovsky.bc.filmplanning.service;

import java.util.Collection;

import cz.tomsovsky.bc.filmplanning.dto.FilmProject;
import cz.tomsovsky.bc.filmplanning.dto.User;

/**
 * Servisní rozhraní pro entitu <code>User</code>
 * 
 * @author Martin Tomšovský
 */
public interface UserService {
	public User getUserByUsername(String username);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(long id);
	public Collection<FilmProject> getUsersFilmProjects(long userId);
	public Collection<FilmProject> getUsersFilmProjects(User user);
	
	/* MOCK metody */
	public void addAuthorities();
}
