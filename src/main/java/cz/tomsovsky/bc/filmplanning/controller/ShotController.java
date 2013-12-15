package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.ShotService;

/**
 * Controller pro operace s entitou <code>Shot</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/shots")
public class ShotController {
	private final ShotService shotService;
	
	@Autowired
	public ShotController(ShotService shotService) {
		this.shotService = shotService;
	}
	
	public ShotService getShotService() {
		return shotService;
	}
}
