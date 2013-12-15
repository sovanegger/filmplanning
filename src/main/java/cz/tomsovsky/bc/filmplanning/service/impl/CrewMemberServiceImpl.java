package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.CrewMember;
import cz.tomsovsky.bc.filmplanning.repository.CrewMemberDao;
import cz.tomsovsky.bc.filmplanning.service.CrewMemberService;

/**
 * Servisní třída entity <code>CrewMember</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="crewMemberService")
public class CrewMemberServiceImpl implements CrewMemberService {
	@Autowired
	private CrewMemberDao crewMemberDao;

	@Override
	@Transactional
	public void saveCrewMember(CrewMember crewMember) {
		crewMemberDao.save(crewMember);
	}

	@Override
	@Transactional
	public void updateCrewMember(CrewMember crewMember) {
		crewMemberDao.update(crewMember);
	}

	@Override
	@Transactional
	public CrewMember getCrewMemberById(long id) {
		return crewMemberDao.getById(id);
	}

	@Override
	@Transactional
	public void deleteCrewMember(long id) {
		CrewMember crewMember = crewMemberDao.getById(id);
		crewMemberDao.delete(crewMember);
	}

	@Override
	@Transactional
	public void deleteCrewMember(CrewMember crewMember) {
		crewMemberDao.delete(crewMember);
	}
	
	public CrewMemberDao getCrewMemberDao() {
		return crewMemberDao;
	}
	public void setCrewMemberDao(CrewMemberDao crewMemberDao) {
		this.crewMemberDao = crewMemberDao;
	}
}
