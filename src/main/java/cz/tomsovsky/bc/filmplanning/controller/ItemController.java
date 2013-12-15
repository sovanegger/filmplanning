package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.ItemService;

/**
 * Controller pro operace s entitou <code>Item</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/items")
public class ItemController {
	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public ItemService getItemService() {
		return itemService;
	}
}
