package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.ReactionService;

/**
 * Controller pro operace s entitou <code>Reaction</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/reactions")
public class ReactionController {
	private final ReactionService reactionService;
	
	@Autowired
	public ReactionController(ReactionService reactionService) {
		this.reactionService = reactionService;
	}
	
	public ReactionService getReactionService() {
		return reactionService;
	}
}
