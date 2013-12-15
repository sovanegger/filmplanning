package cz.tomsovsky.bc.filmplanning.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.ItemType;
import cz.tomsovsky.bc.filmplanning.repository.ItemTypeDao;

/**
 * DAO třída pro entitu <code>ItemType</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="itemType")
public class ItemTypeDaoHibernate extends DaoHibernate implements ItemTypeDao {
	@Override
	public void save(ItemType itemType) {
		currentSession().save(itemType);
	}

	@Override
	public void update(ItemType itemType) {
		currentSession().update(itemType);
	}

	@Override
	public ItemType getById(long id) {
		return (ItemType) currentSession().get(ItemType.class, id);
	}

	// TODO jinak nez @SuppressWarnings
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemType> list() {
		return (List<ItemType>) currentSession().createCriteria(ItemType.class).list();
	}

	@Override
	public void delete(ItemType itemType) {
		currentSession().delete(itemType);
	}
}
