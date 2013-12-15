package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pro admin rozhraní.
 * <p>
 * Obsahuje pouze tři základní metody pro přihlášení, odhlášení a zobrazení úvodní stránky.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@RequestMapping(value={"", "/", "/home"})
	public String getAdminHomePage() {
		return "admin/home";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "redirect:/admin/j_spring_security_logout";
	}
}
