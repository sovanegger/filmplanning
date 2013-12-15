package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Shot;
import cz.tomsovsky.bc.filmplanning.repository.ShotDao;

/**
 * DAO třída pro entitu <code>Shot</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="shotDao")
public class ShotDaoHibernate extends DaoHibernate implements ShotDao {
	@Override
	public void save(Shot shot) {
		currentSession().save(shot);
	}

	@Override
	public void update(Shot shot) {
		currentSession().update(shot);
	}

	@Override
	public Shot getById(long id) {
		return (Shot) currentSession().get(Shot.class, id);
	}

	@Override
	public void delete(Shot shot) {
		currentSession().delete(shot);
	}
}
