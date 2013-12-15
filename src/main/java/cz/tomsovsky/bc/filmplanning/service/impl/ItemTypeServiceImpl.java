package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.ItemType;
import cz.tomsovsky.bc.filmplanning.repository.ItemTypeDao;
import cz.tomsovsky.bc.filmplanning.service.ItemTypeService;

/**
 * Servisní třída entity <code>ItemType</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="itemTypeService")
public class ItemTypeServiceImpl implements ItemTypeService {
	@Autowired
	private ItemTypeDao itemTypeDao;
	
	public ItemTypeDao getItemTypeDao() {
		return itemTypeDao;
	}
	public void setItemTypeDao(ItemTypeDao itemTypeDao) {
		this.itemTypeDao = itemTypeDao;
	}
	
	@Override
	@Transactional
	public List<ItemType> getAllItemTypes() {
		return itemTypeDao.list();
	}
	
	@Override
	@Transactional
	public void saveItemType(ItemType itemType) {
		itemTypeDao.save(itemType);
	}
	
	@Override
	@Transactional
	public void updateItemType(ItemType itemType) {
		itemTypeDao.update(itemType);
	}
	
	@Override
	@Transactional
	public void deleteItemType(long id) {
		ItemType itemType = itemTypeDao.getById(id);
		itemTypeDao.delete(itemType);
	}
	@Override
	@Transactional
	public void deleteItemType(ItemType itemType) {
		itemTypeDao.delete(itemType);
	}
	
	@Override
	@Transactional
	public ItemType getItemTypeById(long id) {
		return itemTypeDao.getById(id);
	}
}
