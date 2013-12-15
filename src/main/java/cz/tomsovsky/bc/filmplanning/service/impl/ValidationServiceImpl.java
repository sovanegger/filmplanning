package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;
import cz.tomsovsky.bc.filmplanning.repository.NonSpecificDao;
import cz.tomsovsky.bc.filmplanning.service.ValidationService;

/**
 * Servisní třída, jejíž metody slouží k validaci doménových objektů.
 * 
 * @author Martin Tomšovský
 */
@Service(value="validationService")
public class ValidationServiceImpl implements ValidationService {
	@Autowired
	private NonSpecificDao nonSpecificDao;
	
	/**
	 * Zjišťuje prostřednictvím instanční proměnné typu <code>NonSpecificDao</code>,
	 * je-li hodnota atributu (pole) unikátní.
	 * 
	 * @param domainClass konkrétní doménová (modelová) třída
	 * @param fieldName název atributu
	 * @param fieldValue hodnota atributu (pole)
	 * @return vrací true, pokud hodnota je unikátní, false, pokud není
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean isFieldValueUnique(Class<? extends IDomain> domainClass, String fieldName, Object fieldValue) {
		if (nonSpecificDao.getResultByFieldValue(domainClass, fieldName, fieldValue) != null)
			return false;
		return true;
	}

	public NonSpecificDao getDao() {
		return nonSpecificDao;
	}
	public void setDao(NonSpecificDao nonSpecificDao) {
		this.nonSpecificDao = nonSpecificDao;
	}
}
