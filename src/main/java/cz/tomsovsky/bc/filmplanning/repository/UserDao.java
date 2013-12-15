package cz.tomsovsky.bc.filmplanning.repository;

import org.springframework.security.core.userdetails.UserDetailsService;

import cz.tomsovsky.bc.filmplanning.dto.User;

/**
 * DAO rozhraní pro entitu <code>User</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface UserDao extends DomainDao<User>, UserDetailsService {
}
