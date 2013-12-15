package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.ItemDao;
import cz.tomsovsky.bc.filmplanning.service.ItemService;

/**
 * Servisní třída entity <code>Item</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="itemService")
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public ItemDao getItemDao() {
		return itemDao;
	}
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}
