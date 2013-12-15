package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.ShotDao;
import cz.tomsovsky.bc.filmplanning.service.ShotService;

/**
 * Servisní třída entity <code>Shot</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="shotService")
public class ShotServiceImpl implements ShotService {
	@Autowired
	private ShotDao shotDao;
	
	public ShotDao getShotDao() {
		return shotDao;
	}
	public void setShotDao(ShotDao shotDao) {
		this.shotDao = shotDao;
	}
}
