package cz.tomsovsky.bc.filmplanning.repository.impl;

import org.springframework.stereotype.Repository;

import cz.tomsovsky.bc.filmplanning.dto.Scene;
import cz.tomsovsky.bc.filmplanning.repository.SceneDao;

/**
 * DAO třída pro entitu <code>Scene</code>
 * 
 * @author Martin Tomšovský
 */
@Repository(value="sceneDao")
public class SceneDaoHibernate extends DaoHibernate implements SceneDao {
	@Override
	public void save(Scene scene) {
		currentSession().save(scene);
	}

	@Override
	public void update(Scene scene) {
		currentSession().update(scene);
	}

	@Override
	public Scene getById(long id) {
		return (Scene) currentSession().get(Scene.class, id);
	}

	@Override
	public void delete(Scene scene) {
		currentSession().delete(scene);
	}
}