package cz.tomsovsky.bc.filmplanning.service.impl;

import cz.tomsovsky.bc.filmplanning.repository.CrewJobDao;
import cz.tomsovsky.bc.filmplanning.service.CrewJobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servisní třída entity <code>CrewJob</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="crewJobService")
public class CrewJobServiceImpl implements CrewJobService {
	@Autowired
	private CrewJobDao crewJobDao;
	
	public CrewJobDao getCrewJobDao() {
		return crewJobDao;
	}
	public void setCrewJobDao(CrewJobDao crewJobDao) {
		this.crewJobDao = crewJobDao;
	}
}
