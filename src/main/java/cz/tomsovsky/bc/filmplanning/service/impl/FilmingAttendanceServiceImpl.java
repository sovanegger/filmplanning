package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.FilmingAttendanceDao;
import cz.tomsovsky.bc.filmplanning.service.FilmingAttendanceService;

/**
 * Servisní třída entity <code>FilmingAttendance</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="filmingAttendanceService")
public class FilmingAttendanceServiceImpl implements FilmingAttendanceService {
	@Autowired
	private FilmingAttendanceDao filmingAttendanceDao;
	
	public FilmingAttendanceDao getAttendanceDao() {
		return filmingAttendanceDao;
	}
	public void setAttendanceDao(FilmingAttendanceDao filmingAttendanceDao) {
		this.filmingAttendanceDao = filmingAttendanceDao;
	}
}
