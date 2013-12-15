package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.LocationService;

/**
 * Controller pro operace s entitou <code>Location</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/locations")
public class LocationController {
	private final LocationService locationService;
	
	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	public LocationService getLocationService() {
		return locationService;
	}
}
