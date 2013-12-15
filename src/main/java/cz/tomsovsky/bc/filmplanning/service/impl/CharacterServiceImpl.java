package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.CharacterDao;
import cz.tomsovsky.bc.filmplanning.service.CharacterService;

/**
 * Servisní třída entity <code>Character</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="characterService")
public class CharacterServiceImpl implements CharacterService {
	@Autowired
	private CharacterDao characterDao;
	
	public CharacterDao getCharacterDao() {
		return characterDao;
	}
	public void setCharacterDao(CharacterDao characterDao) {
		this.characterDao = characterDao;
	}
}
