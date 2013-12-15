package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Character;
import cz.tomsovsky.bc.filmplanning.repository.CharacterDao;

/**
 * DAO třída pro entitu <code>Character</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="characterDao")
public class CharacterDaoHibernate extends DaoHibernate implements CharacterDao {
	@Override
	public void save(Character character) {
		currentSession().save(character);
	}

	@Override
	public void update(Character character) {
		currentSession().save(character);
	}

	@Override
	public Character getById(long id) {
		return (Character) currentSession().get(Character.class, id);
	}

	@Override
	public void delete(Character character) {
		currentSession().delete(character);
	}
}
