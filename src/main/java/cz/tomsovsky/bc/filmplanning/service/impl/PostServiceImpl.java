package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.PostDao;
import cz.tomsovsky.bc.filmplanning.service.PostService;

/**
 * Servisní třída entity <code>Post</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="postService")
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao postDao;
	
	public PostDao getPostDao() {
		return postDao;
	}
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
}
