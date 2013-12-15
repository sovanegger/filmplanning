package cz.tomsovsky.bc.filmplanning.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Authority;
import cz.tomsovsky.bc.filmplanning.repository.AuthorityDao;

/**
 * DAO třída pro entitu <code>Authority</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="authorityDao")
public class AuthorityDaoHibernate extends DaoHibernate implements AuthorityDao {
	@Override
	public void save(Authority authority) {
		currentSession().save(authority);
	}
	@Override
	public void update(Authority authority) {
		currentSession().update(authority);
	}
	@Override
	public Authority getById(long id) {
		return (Authority) currentSession().get(Authority.class, id);
	}
	@Override
	public Authority getAuthorityByName(String authorityName) {
		Criteria criteria = currentSession().createCriteria(Authority.class);
		criteria.add(Restrictions.eq("authority", authorityName));
		Authority result = (Authority) criteria.uniqueResult();
		return result;
	}
	
	// TODO jinak nez @SuppressWarnings
	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> list() {
		return (List<Authority>) currentSession().createCriteria(Authority.class).list();
	}
	
	@Override
	public void delete(Authority authority) {
	   currentSession().delete(authority);
	}
}