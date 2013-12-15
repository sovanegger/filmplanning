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

import cz.tomsovsky.bc.filmplanning.dto.SceneType;
import cz.tomsovsky.bc.filmplanning.service.SceneTypeService;

/**
 * Controller pro operace s entitou <code>SceneType</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/admin/scenetypes")
public class SceneTypeController {
	private final SceneTypeService sceneTypeService;
	
	@Autowired
	public SceneTypeController(SceneTypeService sceneTypeService) {
		this.sceneTypeService = sceneTypeService;
	}
	
	@RequestMapping(value={"", "/", "/list"})
	public String listSceneTypes(Model model) {
		model.addAttribute("sceneTypes", sceneTypeService.getAllSceneTypes());
		return "scenetypes/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new SceneType());
		return "scenetypes/add";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(sceneTypeService.getSceneTypeById(id));
		return "scenetypes/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(sceneTypeService.getSceneTypeById(id));
		return "scenetypes/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveSceneType(@Valid SceneType sceneType, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "scenetypes/add";
		sceneTypeService.saveSceneType(sceneType);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/admin/scenetypes/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateSceneType(@Valid SceneType sceneType, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "scenetypes/edit";
		sceneTypeService.updateSceneType(sceneType);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/admin/scenetypes/"+sceneType.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteSceneType(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		sceneTypeService.deleteSceneType(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/admin/scenetypes/list";
	}
	
	public SceneTypeService getSceneTypeService() {
		return sceneTypeService;
	}
}