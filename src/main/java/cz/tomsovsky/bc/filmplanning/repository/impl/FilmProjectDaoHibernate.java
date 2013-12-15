package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.FilmProject;
import cz.tomsovsky.bc.filmplanning.repository.FilmProjectDao;

/**
 * DAO třída pro entitu <code>FilmProject</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="filmProjectDao")
public class FilmProjectDaoHibernate extends DaoHibernate implements FilmProjectDao {
	@Override
	public void save(FilmProject filmProject) {
		currentSession().save(filmProject);
	}
	
	@Override
	public void update(FilmProject filmProject) {
		currentSession().update(filmProject);
	}

	@Override
	public FilmProject getById(long id) {
		return (FilmProject) currentSession().get(FilmProject.class, id);
	}

	@Override
	public void delete(FilmProject filmProject) {
		currentSession().delete(filmProject);
	}

	@Override
	public void updateScreenplay(long id, String screenplay) {
		FilmProject filmProject = (FilmProject) currentSession().get(FilmProject.class, id);
		filmProject.setScreenplay(screenplay);
		currentSession().update(filmProject);
	}
}
