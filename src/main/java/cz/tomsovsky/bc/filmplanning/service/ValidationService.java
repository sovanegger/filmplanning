package cz.tomsovsky.bc.filmplanning.service;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;

/**
 * Servisní rozhraní, které slouží k validaci entit
 * 
 * @author Martin Tomšovský
 */
public interface ValidationService {
	public boolean isFieldValueUnique(Class<? extends IDomain> persistentClass, String fieldName, Object fieldValue);
}
