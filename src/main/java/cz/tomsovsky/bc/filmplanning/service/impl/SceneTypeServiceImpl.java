package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.SceneType;
import cz.tomsovsky.bc.filmplanning.repository.SceneTypeDao;
import cz.tomsovsky.bc.filmplanning.service.SceneTypeService;

/**
 * Servisní třída entity <code>SceneType</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="sceneTypeService")
public class SceneTypeServiceImpl implements SceneTypeService {
	@Autowired
	private SceneTypeDao sceneTypeDao;
	
	public SceneTypeDao getSceneTypeDao() {
		return sceneTypeDao;
	}
	public void setSceneTypeDao(SceneTypeDao sceneTypeDao) {
		this.sceneTypeDao = sceneTypeDao;
	}
	
	@Override
	@Transactional
	public List<SceneType> getAllSceneTypes() {
		return sceneTypeDao.list();
	}
	
	@Override
	@Transactional
	public void saveSceneType(SceneType sceneType) {
		sceneTypeDao.save(sceneType);
	}
	
	@Override
	@Transactional
	public void updateSceneType(SceneType sceneType) {
		sceneTypeDao.update(sceneType);
	}
	
	@Override
	@Transactional
	public SceneType getSceneTypeById(long id) {
		return sceneTypeDao.getById(id);
	}
	
	@Override
	@Transactional
	public void deleteSceneType(long id) {
		SceneType sceneType = sceneTypeDao.getById(id);
		sceneTypeDao.delete(sceneType);
	}
	
	@Override
	@Transactional
	public void deleteSceneType(SceneType sceneType) {
		sceneTypeDao.delete(sceneType);
	}
}