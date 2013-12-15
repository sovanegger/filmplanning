package cz.tomsovsky.bc.filmplanning.service;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.Authority;

/**
 * Servisní rozhraní pro entitu <code>Authority</code>
 * 
 * @author Martin Tomšovský
 */
public interface AuthorityService {
	public List<Authority> getAllAuthorities();
	public void saveAuthority(Authority authority);
	public void updateAuthority(Authority authority);
	public Authority getAuthorityById(long id);
	public void deleteAuthority(long id);
	public void deleteAuthority(Authority authority);
}
