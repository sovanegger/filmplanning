package cz.tomsovsky.bc.filmplanning.service;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.ShotType;

/**
 * Servisní rozhraní pro entitu <code>ShotType</code>
 * 
 * @author Martin Tomšovský
 */
public interface ShotTypeService {
	public List<ShotType> getAllShotTypes();
	public void saveShotType(ShotType shotType);
	public void updateShotType(ShotType shotType);
	public ShotType getShotTypeById(long id);
	public void deleteShotType(long id);
	public void deleteShotType(ShotType shotType);
}
