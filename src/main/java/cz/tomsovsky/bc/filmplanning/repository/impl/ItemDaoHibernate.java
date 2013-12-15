package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Item;
import cz.tomsovsky.bc.filmplanning.repository.ItemDao;

/**
 * DAO třída pro entitu <code>Item</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="itemDao")
public class ItemDaoHibernate extends DaoHibernate implements ItemDao {
	@Override
	public void save(Item item) {
		currentSession().save(item);
	}

	@Override
	public void update(Item item) {
		currentSession().update(item);
	}

	@Override
	public Item getById(long id) {
		return (Item) currentSession().get(Item.class, id);
	}

	@Override
	public void delete(Item item) {
	    currentSession().delete(item);
	}
}
