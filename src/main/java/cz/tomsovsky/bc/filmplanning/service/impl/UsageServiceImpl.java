package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.UsageDao;
import cz.tomsovsky.bc.filmplanning.service.UsageService;

/**
 * Servisní třída entity <code>Usage</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="usageService")
public class UsageServiceImpl implements UsageService {
	@Autowired
	private UsageDao usageDao;
	
	public UsageDao getUsageDao() {
		return usageDao;
	}
	public void setUsageDao(UsageDao usageDao) {
		this.usageDao = usageDao;
	}
}
