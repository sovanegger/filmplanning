package cz.tomsovsky.bc.filmplanning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.tomsovsky.bc.filmplanning.dto.FilmProject;
import cz.tomsovsky.bc.filmplanning.security.FilmProjectContext;
import cz.tomsovsky.bc.filmplanning.service.FilmProjectService;

/**
 * Controller pro operace s entitou <code>FilmProject</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/filmprojects")
public class FilmProjectController {
	private final FilmProjectService filmProjectService;
	
	@Autowired
	public FilmProjectController(FilmProjectService filmProjectService) {
		this.filmProjectService = filmProjectService;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new FilmProject());
		return "filmprojects/add";
	}
	
	@RequestMapping(value={"/{id}/screenplay"}, method=RequestMethod.GET)
	public String getScreenplayForm(@PathVariable long id, Model model) {
		FilmProject filmProject = filmProjectService.getFilmProjectById(id);
		FilmProjectContext.setCurrentFilmProject(filmProject);
		model.addAttribute(filmProject);
		model.addAttribute("settings", filmProjectService.configScreenplayEditor());
		return "filmprojects/screenplay";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(filmProjectService.getFilmProjectById(id));
		return "filmprojects/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(filmProjectService.getFilmProjectById(id));
		return "filmprojects/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveFilmProject(@Valid FilmProject filmProject, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "filmprojects/add";
		filmProjectService.saveFilmProject(filmProject);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/users/filmprojects";
	}
	
	@RequestMapping(value="/updatescreenplay", method={RequestMethod.PUT})
	public String updateFilmProjectScreenplay(@ModelAttribute("id") long id, @ModelAttribute("screenplay") String screenplay) {
		filmProjectService.updateScreenplay(id, screenplay);
		return "redirect:/filmprojects/"+ id +"/screenplay";
	}
	
	@RequestMapping(value="/updatescreenplay", method={RequestMethod.PUT}, consumes="application/json")
	public @ResponseBody void updateFilmProjectScreenplay(@RequestBody FilmProject filmProject) {
		filmProjectService.updateScreenplay(filmProject.getId(), filmProject.getScreenplay());
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateFilmProject(@Valid FilmProject filmProject, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "filmprojects/edit";
		filmProjectService.updateFilmProject(filmProject);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/users/filmprojects/"+filmProject.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteFilmProject(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		filmProjectService.deleteFilmProject(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/users/filmprojects/";
	}

	public FilmProjectService getFilmProjectService() {
		return filmProjectService;
	}
}