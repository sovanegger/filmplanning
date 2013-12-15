package cz.tomsovsky.bc.filmplanning.service.impl;

import cz.tomsovsky.bc.filmplanning.repository.LocationDao;
import cz.tomsovsky.bc.filmplanning.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servisní třída entity <code>Location</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="locationService")
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationDao locationDao;
	
	public LocationDao getLocationDao() {
		return locationDao;
	}
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
}
