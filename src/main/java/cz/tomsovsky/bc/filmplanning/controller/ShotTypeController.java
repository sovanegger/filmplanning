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

import cz.tomsovsky.bc.filmplanning.dto.ShotType;
import cz.tomsovsky.bc.filmplanning.service.ShotTypeService;

/**
 * Controller pro operace s entitou <code>ShotType</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/admin/shottypes")
public class ShotTypeController {
	private final ShotTypeService shotTypeService;
	
	@Autowired
	public ShotTypeController(ShotTypeService shotTypeService) {
		this.shotTypeService = shotTypeService;
	}
	
	@RequestMapping(value={"", "/", "/list"})
	public String listShotTypes(Model model) {
		model.addAttribute("shotTypes", shotTypeService.getAllShotTypes());
		return "shottypes/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new ShotType());
		return "shottypes/add";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(shotTypeService.getShotTypeById(id));
		return "shottypes/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(shotTypeService.getShotTypeById(id));
		return "shottypes/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveShotType(@Valid ShotType shotType, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "shottypes/add";
		shotTypeService.saveShotType(shotType);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/admin/shottypes/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateShotType(@Valid ShotType shotType, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "shottypes/edit";
		shotTypeService.updateShotType(shotType);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/admin/shottypes/"+shotType.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteShotType(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		shotTypeService.deleteShotType(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/admin/shottypes/list";
	}
	
	public ShotTypeService getShotTypeService() {
		return shotTypeService;
	}
}
