package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Post;
import cz.tomsovsky.bc.filmplanning.repository.PostDao;

/**
 * DAO třída pro entitu <code>Post</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="postDao")
public class PostDaoHibernate extends DaoHibernate implements PostDao {
	@Override
	public void save(Post post) {
		currentSession().save(post);
	}

	@Override
	public void update(Post post) {
		currentSession().update(post);
	}

	@Override
	public Post getById(long id) {
		return (Post) currentSession().get(Post.class, id);
	}

	@Override
	public void delete(Post post) {
	    currentSession().delete(post);
	}
}
