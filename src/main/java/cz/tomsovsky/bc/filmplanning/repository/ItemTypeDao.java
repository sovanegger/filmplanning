package cz.tomsovsky.bc.filmplanning.repository;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.ItemType;

/**
 * DAO rozhraní pro entitu <code>ItemType</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface ItemTypeDao extends DomainDao<ItemType> {
	public List<ItemType> list();
}
