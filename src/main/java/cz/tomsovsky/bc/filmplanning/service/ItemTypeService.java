package cz.tomsovsky.bc.filmplanning.service;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.ItemType;

/**
 * Servisní rozhraní pro entitu <code>ItemType</code>
 * 
 * @author Martin Tomšovský
 */
public interface ItemTypeService {
	public List<ItemType> getAllItemTypes();
	public void saveItemType(ItemType itemType);
	public void updateItemType(ItemType itemType);
	public ItemType getItemTypeById(long id);
	public void deleteItemType(long id);
	public void deleteItemType(ItemType itemType);
}
