package cz.tomsovsky.bc.filmplanning.service;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.SceneType;

/**
 * Servisní rozhraní pro entitu <code>SceneType</code>
 * 
 * @author Martin Tomšovský
 */
public interface SceneTypeService {
	public List<SceneType> getAllSceneTypes();
	public void saveSceneType(SceneType sceneType);
	public void updateSceneType(SceneType sceneType);
	public SceneType getSceneTypeById(long id);
	public void deleteSceneType(long id);
	public void deleteSceneType(SceneType sceneType);
}
