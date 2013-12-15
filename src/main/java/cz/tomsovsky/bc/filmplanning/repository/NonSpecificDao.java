package cz.tomsovsky.bc.filmplanning.repository;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;

/**
 * Obecné DAO rozhraní, které nenáleží žádnému doménovému objektu.
 * 
 * @author Martin Tomšovský
 */
public interface NonSpecificDao {
	public IDomain getResultByFieldValue(Class<? extends IDomain> persistentClass, String fieldName, Object fieldValue);
}
