package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.FilmingDay;
import cz.tomsovsky.bc.filmplanning.repository.FilmingDayDao;

/**
 * DAO třída pro entitu <code>FilmingDay</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="filmingDayDao")
public class FilmingDayDaoHibernate extends DaoHibernate implements FilmingDayDao {
	@Override
	public void save(FilmingDay filmingDay) {
		currentSession().save(filmingDay);
	}

	@Override
	public void update(FilmingDay filmingDay) {
		currentSession().update(filmingDay);
	}

	@Override
	public FilmingDay getById(long id) {
		return (FilmingDay) currentSession().get(FilmingDay.class, id);
	}

	@Override
	public void delete(FilmingDay filmingDay) {
	    currentSession().delete(filmingDay);
	}
}
