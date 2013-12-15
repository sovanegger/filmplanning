package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Třída, která uchovává odkaz na instanci typu <code>SessionFactory</code>,
 * a poskutuje jej, dalším třídem, které tuto třídu rozšiřují.
 * 
 * @author Martin Tomšovský
 */
@Repository
public class DaoHibernate {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
