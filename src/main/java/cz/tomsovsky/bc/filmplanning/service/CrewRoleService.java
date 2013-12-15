package cz.tomsovsky.bc.filmplanning.service;

import java.util.List;

import cz.tomsovsky.bc.filmplanning.dto.CrewRole;

/**
 * Servisní rozhraní pro entitu <code>CrewRole</code>
 * 
 * @author Martin Tomšovský
 */
public interface CrewRoleService {
	public List<CrewRole> getAllCrewRoles();
	public void saveCrewRole(CrewRole crewRole);
	public void updateCrewRole(CrewRole crewRole);
	public CrewRole getCrewRoleById(long id);
	public void deleteCrewRole(long id);
	public void deleteCrewRole(CrewRole crewRole);
}
