package cz.tomsovsky.bc.filmplanning.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.CrewRole;
import cz.tomsovsky.bc.filmplanning.repository.CrewRoleDao;

/**
 * DAO třída pro entitu <code>CrewRole</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="crewRole")
public class CrewRoleDaoHibernate extends DaoHibernate implements CrewRoleDao {
	@Override
	public void save(CrewRole crewRole) {
		currentSession().save(crewRole);
	}

	@Override
	public void update(CrewRole crewRole) {
		currentSession().update(crewRole);
	}

	@Override
	public CrewRole getById(long id) {
		return (CrewRole) currentSession().get(CrewRole.class, id);
	}

	// TODO jinak nez @SuppressWarnings
	@SuppressWarnings("unchecked")
	@Override
	public List<CrewRole> list() {
		return (List<CrewRole>) currentSession().createCriteria(CrewRole.class).list();
	}

	@Override
	public void delete(CrewRole crewRole) {
		currentSession().delete(crewRole);
	}
}
