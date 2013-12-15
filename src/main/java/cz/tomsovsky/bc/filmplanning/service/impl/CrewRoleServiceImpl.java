package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.CrewRole;
import cz.tomsovsky.bc.filmplanning.repository.CrewRoleDao;
import cz.tomsovsky.bc.filmplanning.service.CrewRoleService;

/**
 * Servisní třída entity <code>CrewRole</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="crewRoleService")
public class CrewRoleServiceImpl implements CrewRoleService {
	@Autowired
	private CrewRoleDao crewRoleDao;
	
	@Override
	@Transactional
	public List<CrewRole> getAllCrewRoles() {
		return crewRoleDao.list();
	}

	@Override
	@Transactional
	public void saveCrewRole(CrewRole crewRole) {
		crewRoleDao.save(crewRole);
	}

	@Override
	@Transactional
	public void updateCrewRole(CrewRole crewRole) {
		crewRoleDao.update(crewRole);
	}

	@Override
	@Transactional
	public CrewRole getCrewRoleById(long id) {
		return crewRoleDao.getById(id);
	}

	@Override
	@Transactional
	public void deleteCrewRole(long id) {
		CrewRole crewRole = crewRoleDao.getById(id);
		crewRoleDao.delete(crewRole);
	}

	@Override
	@Transactional
	public void deleteCrewRole(CrewRole crewRole) {
		crewRoleDao.delete(crewRole);
	}
	
	public CrewRoleDao getCrewRoleDao() {
		return crewRoleDao;
	}
	public void setCrewRoleDao(CrewRoleDao crewRoleDao) {
		this.crewRoleDao = crewRoleDao;
	}
}
