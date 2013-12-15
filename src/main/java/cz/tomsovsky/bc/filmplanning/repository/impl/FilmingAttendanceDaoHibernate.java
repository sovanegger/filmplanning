package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.FilmingAttendance;
import cz.tomsovsky.bc.filmplanning.repository.FilmingAttendanceDao;

/**
 * DAO třída pro entitu <code>FilmingAttendance</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="filmingAttendanceDao")
public class FilmingAttendanceDaoHibernate extends DaoHibernate implements FilmingAttendanceDao {

	@Override
	public void save(FilmingAttendance filmingAttendance) {
		currentSession().save(filmingAttendance);
	}

	@Override
	public void update(FilmingAttendance filmingAttendance) {
		currentSession().update(filmingAttendance);
	}

	@Override
	public FilmingAttendance getById(long id) {
		return (FilmingAttendance) currentSession().get(FilmingAttendance.class, id);
	}

	@Override
	public void delete(FilmingAttendance filmingAttendance) {
		currentSession().delete(filmingAttendance);
	}
}
