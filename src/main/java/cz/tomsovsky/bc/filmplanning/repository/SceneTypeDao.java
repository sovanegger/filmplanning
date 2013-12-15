package cz.tomsovsky.bc.filmplanning.repository;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.SceneType;

/**
 * DAO rozhraní pro entitu <code>SceneType</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface SceneTypeDao extends DomainDao<SceneType> {
	public List<SceneType> list();
}