package cz.tomsovsky.bc.filmplanning.repository;

import cz.tomsovsky.bc.filmplanning.dto.FilmProject;

/**
 * DAO rozhraní pro entitu <code>FilmProject</code>. 
 * 
 * @author Martin Tomšovský
 */
public interface FilmProjectDao extends DomainDao<FilmProject> {
	public void updateScreenplay(long id, String screenplay);
}
