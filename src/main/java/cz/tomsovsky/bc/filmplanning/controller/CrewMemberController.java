package cz.tomsovsky.bc.filmplanning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.tomsovsky.bc.filmplanning.dto.CrewMember;
import cz.tomsovsky.bc.filmplanning.dto.FilmProject;
import cz.tomsovsky.bc.filmplanning.security.FilmProjectContext;
import cz.tomsovsky.bc.filmplanning.service.CrewMemberService;
import cz.tomsovsky.bc.filmplanning.service.FilmProjectService;

/**
 * Controller pro operace s entitou <code>CrewMember</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="filmprojects/{filmProjectId}/crewmembers")
public class CrewMemberController {
	private final CrewMemberService crewMemberService;
	private final FilmProjectService filmProjectService;
	
	@Autowired
	public CrewMemberController(CrewMemberService crewMemberService, FilmProjectService filmProjectService) {
		this.crewMemberService = crewMemberService;
		this.filmProjectService = filmProjectService;
	}
	
	@RequestMapping(value={"/","/list"}, method=RequestMethod.GET)
	public String listCrewMembers(@PathVariable long id, Model model) {
		FilmProject filmProject = filmProjectService.getFilmProjectById(id);
		model.addAttribute("crewMembers", filmProjectService.getFilmProjectsCrewMembers(filmProject));
		model.addAttribute(filmProject);
		return "filmprojects/crewmembers";
	}
	
	@RequestMapping(value="/sendmembershiprequest")
	public String sendCrewMembershipRequest() {
		return "crewmembers/add";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(crewMemberService.getCrewMemberById(id));
		return "crewmembers/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(crewMemberService.getCrewMemberById(id));
		return "crewmembers/edit";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET) 
	public String getAddCrewMemberForm(Model model) {
		return "crewmembers/add";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCrewMember(@Valid CrewMember crewMember, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "crewmembers/add";
		crewMemberService.saveCrewMember(crewMember);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/filmprojects/"+crewMember.getFilmProject().getId()+"/crewmembers/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateCrewMember(@Valid CrewMember crewMember, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "crewmembers/edit";
		crewMemberService.updateCrewMember(crewMember);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/filmprojects/"+crewMember.getFilmProject().getId()+"/crewmembers/"+crewMember.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteCrewMember(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		crewMemberService.deleteCrewMember(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/filmprojects/"+FilmProjectContext.getCurrentFilmProject()+"/crewmembers/list";
	}
	
	public CrewMemberService getCrewMemberService() {
		return crewMemberService;
	}
}