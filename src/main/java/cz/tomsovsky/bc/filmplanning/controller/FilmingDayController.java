package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.FilmingDayService;

/**
 * Controller pro operace s entitou <code>FilmingDay</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/filmingdays")
public class FilmingDayController {
	private final FilmingDayService filmingDayService;
	
	@Autowired
	public FilmingDayController(FilmingDayService filmingDayService) {
		this.filmingDayService = filmingDayService;
	}
	
	public FilmingDayService getFilmingDayService() {
		return filmingDayService;
	}
}
