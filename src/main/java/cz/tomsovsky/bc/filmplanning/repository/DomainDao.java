package cz.tomsovsky.bc.filmplanning.repository;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;

/**
 * Základní rozhraní repository vrstvy, od kterého dědí všechna ostatní DAO rozhraní,
 * jež jsou implementována konkrétními DAO třídami.
 * <p>
 * DAO třídy komunikují databází. 
 * 
 * @author Martin Tomšovský
 *
 * @param <E> jakýkoliv objekt, který implementuje rozhraní IDomain
 */
public interface DomainDao<E extends IDomain> {
	public void save(E domain);
	public void update(E domain);
	public E getById(long id);
	public void delete(E domain);
}
