package cz.tomsovsky.bc.filmplanning.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.SceneType;
import cz.tomsovsky.bc.filmplanning.repository.SceneTypeDao;

/**
 * DAO třída pro entitu <code>SceneType</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="sceneType")
public class SceneTypeDaoHibernate extends DaoHibernate implements SceneTypeDao {
	@Override
	public void save(SceneType sceneType) {
		currentSession().save(sceneType);
	}

	@Override
	public void update(SceneType sceneType) {
		currentSession().update(sceneType);
	}

	@Override
	public SceneType getById(long id) {
		return (SceneType) currentSession().get(SceneType.class, id);
	}

	// TODO jinak nez @SuppressWarnings
	@SuppressWarnings("unchecked")
	@Override
	public List<SceneType> list() {
		return (List<SceneType>) currentSession().createCriteria(SceneType.class).list();
	}

	@Override
	public void delete(SceneType sceneType) {
		currentSession().delete(sceneType);
	}
}
