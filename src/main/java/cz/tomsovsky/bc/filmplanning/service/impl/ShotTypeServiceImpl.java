package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.tomsovsky.bc.filmplanning.dto.ShotType;
import cz.tomsovsky.bc.filmplanning.repository.ShotTypeDao;
import cz.tomsovsky.bc.filmplanning.service.ShotTypeService;

/**
 * Servisní třída entity <code>ShotType</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="shotTypeService")
public class ShotTypeServiceImpl implements ShotTypeService {
	@Autowired
	private ShotTypeDao shotTypeDao;
	
	public ShotTypeDao getShotTypeDao() {
		return shotTypeDao;
	}
	public void setShotTypeDao(ShotTypeDao shotTypeDao) {
		this.shotTypeDao = shotTypeDao;
	}
	
	@Override
	@Transactional
	public List<ShotType> getAllShotTypes() {
		return shotTypeDao.list();
	}
	
	@Override
	@Transactional
	public void saveShotType(ShotType shotType) {
		shotTypeDao.save(shotType);
	}
	
	@Override
	@Transactional
	public void updateShotType(ShotType shotType) {
		shotTypeDao.update(shotType);
	}
	
	@Override
	@Transactional
	public ShotType getShotTypeById(long id) {
		return shotTypeDao.getById(id);
	}
	
	@Override
	@Transactional
	public void deleteShotType(long id) {
		ShotType shotType = shotTypeDao.getById(id);
		shotTypeDao.delete(shotType);
	}
	
	@Override
	@Transactional
	public void deleteShotType(ShotType shotType) {
		shotTypeDao.delete(shotType);
	}
}
