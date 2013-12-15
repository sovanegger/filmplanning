package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Usage;
import cz.tomsovsky.bc.filmplanning.repository.UsageDao;

/**
 * DAO třída pro entitu <code>Usage</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="usageDao")
public class UsageDaoHibernate extends DaoHibernate implements UsageDao {
	@Override
	public void save(Usage usage) {
		currentSession().save(usage);
	}

	@Override
	public void update(Usage usage) {
		currentSession().update(usage);
	}

	@Override
	public Usage getById(long id) {
		return (Usage) currentSession().get(Usage.class, id);
	}

	@Override
	public void delete(Usage usage) {
		currentSession().delete(usage);
	}
}
