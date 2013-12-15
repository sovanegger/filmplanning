package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.CrewJob;
import cz.tomsovsky.bc.filmplanning.repository.CrewJobDao;

/**
 * DAO třída pro entitu <code>CrewJob</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="crewJobDao")
public class CrewJobDaoHibernate extends DaoHibernate implements CrewJobDao {
	@Override
	public void save(CrewJob crewJob) {
		currentSession().save(crewJob);
	}

	@Override
	public void update(CrewJob crewJob) {
		currentSession().update(crewJob);
	}

	@Override
	public CrewJob getById(long id) {
		return (CrewJob) currentSession().get(CrewJob.class, id);
	}

	@Override
	public void delete(CrewJob crewJob) {
		currentSession().delete(crewJob);
	}
}
