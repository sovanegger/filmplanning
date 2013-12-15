package cz.tomsovsky.bc.filmplanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.tomsovsky.bc.filmplanning.repository.SceneAttendanceDao;
import cz.tomsovsky.bc.filmplanning.service.SceneAttendanceService;

/**
 * Servisní třída entity <code>SceneAttendance</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="sceneAttendanceService")
public class SceneAttendanceServiceImpl implements SceneAttendanceService {
	@Autowired
	private SceneAttendanceDao sceneAttendanceDao;
	
	public SceneAttendanceDao getAttendanceDao() {
		return sceneAttendanceDao;
	}
	public void setAttendanceDao(SceneAttendanceDao sceneAttendanceDao) {
		this.sceneAttendanceDao = sceneAttendanceDao;
	}
}
