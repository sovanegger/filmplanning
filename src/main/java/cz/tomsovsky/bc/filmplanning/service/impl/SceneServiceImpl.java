package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.SceneDao;
import cz.tomsovsky.bc.filmplanning.service.SceneService;

/**
 * Servisní třída entity <code>Scene</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="sceneService")
public class SceneServiceImpl implements SceneService {
	@Autowired
	private SceneDao sceneDao;

	public SceneDao getSceneDao() {
		return sceneDao;
	}
	public void setSceneDao(SceneDao sceneDao) {
		this.sceneDao = sceneDao;
	}
}
