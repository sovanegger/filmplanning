package cz.tomsovsky.bc.filmplanning.repository;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.ShotType;

/**
 * DAO rozhraní pro entitu <code>ShotType</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface ShotTypeDao extends DomainDao<ShotType> {
	public List<ShotType> list();
}
