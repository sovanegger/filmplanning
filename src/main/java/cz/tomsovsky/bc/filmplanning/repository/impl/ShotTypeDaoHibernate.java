package cz.tomsovsky.bc.filmplanning.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.ShotType;
import cz.tomsovsky.bc.filmplanning.repository.ShotTypeDao;

/**
 * DAO třída pro entitu <code>ShotType</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="shotTypeDao")
public class ShotTypeDaoHibernate extends DaoHibernate implements ShotTypeDao {
	@Override
	public void save(ShotType shotType) {
		currentSession().save(shotType);
	}

	@Override
	public void update(ShotType shotType) {
		currentSession().update(shotType);
	}

	@Override
	public ShotType getById(long id) {
		return (ShotType) currentSession().get(ShotType.class, id);
	}

	// TODO jinak nez @SuppressWarnings
	@SuppressWarnings("unchecked")
	@Override
	public List<ShotType> list() {
		return (List<ShotType>) currentSession().createCriteria(ShotType.class).list();
	}

	@Override
	public void delete(ShotType shotType) {
		currentSession().delete(shotType);
	}
}
