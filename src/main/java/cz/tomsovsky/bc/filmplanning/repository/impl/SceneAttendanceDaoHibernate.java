package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.SceneAttendance;
import cz.tomsovsky.bc.filmplanning.repository.SceneAttendanceDao;

/**
 * DAO třída pro entitu <code>SceneAttendance</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="sceneAttendanceDao")
public class SceneAttendanceDaoHibernate extends DaoHibernate implements SceneAttendanceDao {
	@Override
	public void save(SceneAttendance attendance) {
		currentSession().save(attendance);
	}

	@Override
	public void update(SceneAttendance attendance) {
		currentSession().update(attendance);
	}

	@Override
	public SceneAttendance getById(long id) {
		return (SceneAttendance) currentSession().get(SceneAttendance.class, id);
	}

	@Override
	public void delete(SceneAttendance attendance) {
		currentSession().delete(attendance);
	}
}
