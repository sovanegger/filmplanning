package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;
import cz.tomsovsky.bc.filmplanning.repository.NonSpecificDao;

@Repository(value="nonSpecificDao")
public class NonSpecificDaoHibernate extends DaoHibernate implements NonSpecificDao {
	@Override
	public IDomain getResultByFieldValue(Class<? extends IDomain> persistentClass, String fieldName, Object fieldValue) {
		Criteria criteria = currentSession().createCriteria(persistentClass);
		criteria.add(Restrictions.eq(fieldName, fieldValue));
		return (IDomain) criteria.uniqueResult();
	}
}
