package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.PostService;

/**
 * Controller pro operace s entitou <code>Post</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/posts")
public class PostController {
	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	public PostService getPostService() {
		return postService;
	}
}
