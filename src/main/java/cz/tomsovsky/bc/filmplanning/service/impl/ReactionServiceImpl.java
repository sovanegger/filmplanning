package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.ReactionDao;
import cz.tomsovsky.bc.filmplanning.service.ReactionService;

/**
 * Servisní třída entity <code>Reaction</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="reactionService")
public class ReactionServiceImpl implements ReactionService {
	@Autowired
	private ReactionDao reactionDao;
	
	public ReactionDao getReactionDao() {
		return reactionDao;
	}
	public void setReactionDao(ReactionDao reactionDao) {
		this.reactionDao = reactionDao;
	}
}
