package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Reaction;
import cz.tomsovsky.bc.filmplanning.repository.ReactionDao;

/**
 * DAO třída pro entitu <code>Reaction</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="reactionDao")
public class ReactionDaoHibernate extends DaoHibernate implements ReactionDao {
	@Override
	public void save(Reaction reaction) {
		currentSession().save(reaction);
	}

	@Override
	public void update(Reaction reaction) {
		currentSession().update(reaction);
	}

	@Override
	public Reaction getById(long id) {
		return (Reaction) currentSession().get(Reaction.class, id);
	}

	@Override
	public void delete(Reaction reaction) {
		currentSession().delete(reaction);
	}
}
