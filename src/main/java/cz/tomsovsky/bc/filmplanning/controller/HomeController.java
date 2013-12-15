package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pro operace s homepage.
 * 
 * @author Martin Tomšovský
 */
@Controller
public class HomeController {
	@RequestMapping(value={"/", "/index", "/home"})
	public String showHomePage() {
		//(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "redirect:/users/filmprojects";
	}
}