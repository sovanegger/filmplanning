package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.CrewMember;
import cz.tomsovsky.bc.filmplanning.repository.CrewMemberDao;

/**
 * DAO třída pro entitu <code>CrewMember</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="crewMember")
public class CrewMemberDaoHibernate extends DaoHibernate implements CrewMemberDao {
	@Override
	public void save(CrewMember crewMember) {
		currentSession().save(crewMember);
	}

	@Override
	public void update(CrewMember crewMember) {
		currentSession().update(crewMember);
	}

	@Override
	public CrewMember getById(long id) {
		return (CrewMember) currentSession().get(CrewMember.class, id);
	}

	@Override
	public void delete(CrewMember crewMember) {
		currentSession().delete(crewMember);
	}
}
