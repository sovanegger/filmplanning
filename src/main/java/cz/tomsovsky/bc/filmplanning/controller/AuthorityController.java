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

import cz.tomsovsky.bc.filmplanning.dto.Authority;
import cz.tomsovsky.bc.filmplanning.service.AuthorityService;

/**
 * Controller pro operace s entitou <code>Authority</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/admin/authorities")
public class AuthorityController {
	private final AuthorityService authorityService;
	
	@Autowired
	public AuthorityController(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	@RequestMapping(value={"", "/", "/list"})
	public String listAuthorities(Model model) {
		model.addAttribute("authorities", authorityService.getAllAuthorities());
		return "authorities/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new Authority());
		return "authorities/add";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(authorityService.getAuthorityById(id));
		return "authorities/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(authorityService.getAuthorityById(id));
		return "authorities/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAuthority(@Valid Authority authority, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "authorities/add";
		authorityService.saveAuthority(authority);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/admin/authorities/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateAuthority(@Valid Authority authority, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "authorities/edit";
		authorityService.updateAuthority(authority);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/admin/authorities/"+authority.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteAuthority(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		authorityService.deleteAuthority(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/admin/authorities/list";
	}
	
	public AuthorityService getAuthorityService() {
		return authorityService;
	}
}
