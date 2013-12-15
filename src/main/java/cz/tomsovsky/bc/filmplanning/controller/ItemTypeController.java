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

import cz.tomsovsky.bc.filmplanning.dto.ItemType;
import cz.tomsovsky.bc.filmplanning.service.ItemTypeService;

/**
 * Controller pro operace s entitou <code>ItemType</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/admin/itemtypes")
public class ItemTypeController {
	private final ItemTypeService itemTypeService;
	
	@Autowired
	public ItemTypeController(ItemTypeService itemTypeService) {
		this.itemTypeService = itemTypeService;
	}
	
	@RequestMapping(value={"", "/", "/list"}, method=RequestMethod.GET)
	public String listItemTypes(Model model) {
		model.addAttribute("itemTypes", itemTypeService.getAllItemTypes());
		return "itemtypes/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddForm(Model model) {
		model.addAttribute(new ItemType());
		return "itemtypes/add";
	}
	
	@RequestMapping(value="/{id}/show", method=RequestMethod.GET)
	public String getShowPage(@PathVariable long id, Model model) {
		model.addAttribute(itemTypeService.getItemTypeById(id));
		return "itemtypes/show";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String getEditForm(@PathVariable long id, Model model) {
		model.addAttribute(itemTypeService.getItemTypeById(id));
		return "itemtypes/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveItemType(@Valid ItemType itemType, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "itemtypes/add";
		itemTypeService.saveItemType(itemType);
		redirectAttributes.addFlashAttribute("successMessage", "success.save");
		return "redirect:/admin/itemtypes/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String updateItemType(@Valid ItemType itemType, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return "itemtypes/edit";
		itemTypeService.updateItemType(itemType);
		redirectAttributes.addFlashAttribute("successMessage", "success.update");
		return "redirect:/admin/itemtypes/"+itemType.getId()+"/show";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	public String deleteItemType(@PathVariable long id, final RedirectAttributes redirectAttributes) {
		itemTypeService.deleteItemType(id);
		redirectAttributes.addFlashAttribute("successMessage", "success.delete");
		return "redirect:/admin/itemtypes/list";
	}
	
	public ItemTypeService getItemTypeService() {
		return itemTypeService;
	}
}
