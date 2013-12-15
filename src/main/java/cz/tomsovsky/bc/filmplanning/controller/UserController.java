package cz.tomsovsky.bc.filmplanning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.tomsovsky.bc.filmplanning.dto.User;
import cz.tomsovsky.bc.filmplanning.security.FilmProjectContext;
import cz.tomsovsky.bc.filmplanning.service.UserService;

/**
 * Controller pro operace s entitou <code>User</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/users")
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "redirect:/users/j_spring_security_logout";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, @RequestParam(value="login_error", required=false) String loginError) {
		if (loginError != null && !loginError.equals(""))
			model.addAttribute("errorMessage", "error.login.user");
		return "users/login";
	}
	
	@RequestMapping(value="/save")
	public String saveUser(@Valid User user, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors())
			return "users/add";
		
		userService.saveUser(user);
		redirectAttributes.addFlashAttribute("successMessage", "success.add.user");
		return "redirect:/users/login";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new User());
		return "users/add";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String getShowPage(@PathVariable String username, Model model) {
		model.addAttribute(userService.getUserByUsername(username));
		return "users/show";
	}

	public UserService getUserService() {
		return userService;
	}
	
	@RequestMapping(value="/filmprojects", method=RequestMethod.GET)
	public String listFilmProjects(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("filmProjects", userService.getUsersFilmProjects(user.getId()));
		FilmProjectContext.setCurrentFilmProject(null);
		return "users/filmprojects";
	}
	
	/* MOCK metody */
	@RequestMapping(value="/addauths")
	public String addAuthorities() {
		userService.addAuthorities();
		return "redirect::/users/login";
	}
}