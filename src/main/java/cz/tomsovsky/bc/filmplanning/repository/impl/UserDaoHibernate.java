package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.User;
import cz.tomsovsky.bc.filmplanning.repository.UserDao;

/**
 * DAO třída pro entitu <code>CrewJob</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="userDao")
public class UserDaoHibernate extends DaoHibernate implements UserDao {
	@Override
	public void save(User user) {
		currentSession().save(user);
	}

	@Override
	public void update(User user) {
		currentSession().update(user);
	}

	@Override
	public User getById(long id) {
		return (User) currentSession().get(User.class, id);
	}

	
	/**
	 * Vrací objekt uživatele podle předloženého uživatelského jména.
	 * 
	 * @param username uživatelské jméno
	 * @return user objekt uživatele, kterému náleží uživatelské jméno
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Criteria criteria = currentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public void delete(User user) {
		currentSession().delete(user);
	}
}