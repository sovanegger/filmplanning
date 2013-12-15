package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.CharacterService;

/**
 * Controller pro operace s entitou <code>Character</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/characters")
public class CharacterController {
	private final CharacterService characterService;
	
	@Autowired
	public CharacterController(CharacterService characterService) {
		this.characterService = characterService;
	}
	
	public CharacterService getCharacterService() {
		return characterService;
	}
}
