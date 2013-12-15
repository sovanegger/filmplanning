package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Location;
import cz.tomsovsky.bc.filmplanning.repository.LocationDao;

/**
 * DAO třída pro entitu <code>Location</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="locationDao")
public class LocationDaoHibernate extends DaoHibernate implements LocationDao {
	@Override
	public void save(Location location) {
		currentSession().save(location);
	}

	@Override
	public void update(Location location) {
		currentSession().update(location);
	}

	@Override
	public Location getById(long id) {
		return (Location) currentSession().get(Location.class, id);
	}

	@Override
	public void delete(Location location) {
		currentSession().delete(location);
	}
}
