package cz.tomsovsky.bc.filmplanning.service;

import cz.tomsovsky.bc.filmplanning.dto.CrewMember;

/**
 * Servisní rozhraní pro entitu <code>CrewMember</code>
 * 
 * @author Martin Tomšovský
 */
public interface CrewMemberService {
	public void saveCrewMember(CrewMember crewMember);
	public void updateCrewMember(CrewMember crewMember);
	public CrewMember getCrewMemberById(long id);
	public void deleteCrewMember(long id);
	public void deleteCrewMember(CrewMember crewMember);
}
