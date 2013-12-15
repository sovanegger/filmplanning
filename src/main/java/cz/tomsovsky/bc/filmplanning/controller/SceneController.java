package cz.tomsovsky.bc.filmplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.tomsovsky.bc.filmplanning.service.SceneService;

/**
 * Controller pro operace s entitou <code>Scene</code>.
 * 
 * @author Martin Tomšovský
 */
@Controller
@RequestMapping(value="/scenes")
public class SceneController {
	private final SceneService sceneService;
	
	@Autowired
	public SceneController(SceneService sceneService) {
		this.sceneService = sceneService;
	}
	
	public SceneService getSceneService() {
		return sceneService;
	}
}
