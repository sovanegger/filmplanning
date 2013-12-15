package cz.tomsovsky.bc.filmplanning.repository;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.CrewRole;

/**
 * DAO rozhraní pro entitu <code>CrewRole</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface CrewRoleDao extends DomainDao<CrewRole> {
	public List<CrewRole> list();
}
