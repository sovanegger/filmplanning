package cz.tomsovsky.bc.filmplanning.service.impl;

import cz.tomsovsky.bc.filmplanning.repository.FilmingDayDao;
import cz.tomsovsky.bc.filmplanning.service.FilmingDayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servisní třída entity <code>FilmingDay</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="filmingDayService")
public class FilmingDayServiceImpl implements FilmingDayService {
	@Autowired
	private FilmingDayDao filmingDayDao;
	
	public FilmingDayDao getFilmingDayDao() {
		return filmingDayDao;
	}
	public void setFilmingDayDao(FilmingDayDao filmingDayDao) {
		this.filmingDayDao = filmingDayDao;
	}
}
