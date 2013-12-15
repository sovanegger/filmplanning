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

import cz.tomsovsky.bc.filmplanning.dto.CrewRole;
import cz.tomsovsky.bc.filmplanning.service.CrewRoleService;

/**
 * Controller pro operace s entitou <code>CrewRole</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/admin/crewroles")
public class CrewRoleController {
	private final CrewRoleService crewRoleService;
	
	@Autowired
	public CrewRoleController(CrewRoleService crewRoleService) {
		this.crewRoleService = crewRoleService;
	}
	
	@RequestMapping(value={"", "/", "/list"})
	public String listCrewRoles(Model model) {
		model.addAttribute("crewRoles", crewRoleService.getAllCrewRoles());
		return "crewroles/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new CrewRole());
		return "crewroles/add";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(crewRoleService.getCrewRoleById(id));
		return "crewroles/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(crewRoleService.getCrewRoleById(id));
		return "crewroles/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCrewRole(@Valid CrewRole crewRole, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "crewroles/add";
		crewRoleService.saveCrewRole(crewRole);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/admin/crewroles/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateCrewRole(@Valid CrewRole crewRole, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "crewroles/edit";
		crewRoleService.updateCrewRole(crewRole);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/admin/crewroles/"+crewRole.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteCrewRole(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		crewRoleService.deleteCrewRole(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/admin/crewroles/list";
	}
	
	public CrewRoleService getCrewRoleService() {
		return crewRoleService;
	}
}
