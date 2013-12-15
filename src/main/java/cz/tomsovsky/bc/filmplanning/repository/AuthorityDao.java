package cz.tomsovsky.bc.filmplanning.repository;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.Authority;

/**
 * DAO rozhraní pro entitu <code>Authority</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface AuthorityDao extends DomainDao<Authority> {
	public List<Authority> list();
	public Authority getAuthorityByName(String authority);
}
