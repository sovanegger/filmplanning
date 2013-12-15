package cz.tomsovsky.bc.filmplanning.service;

import java.util.Collection;

import com.ckeditor.CKEditorConfig;

import cz.tomsovsky.bc.filmplanning.dto.CrewMember;
import cz.tomsovsky.bc.filmplanning.dto.FilmProject;

/**
 * Servisní rozhraní pro entitu <code>FilmProject</code>
 * 
 * @author Martin Tomšovský
 */
public interface FilmProjectService {
	public void saveFilmProject(FilmProject filmProject);
	public void updateFilmProject(FilmProject filmProject);
	public FilmProject getFilmProjectById(long id);
	public void deleteFilmProject(long id);
	public void deleteFilmProject(FilmProject filmProject);
	public CKEditorConfig configScreenplayEditor();
	public void updateScreenplay(long id, String screenplay);
	public Collection<CrewMember> getFilmProjectsCrewMembers(long filmProjectId);
	public Collection<CrewMember> getFilmProjectsCrewMembers(FilmProject filmProject);
}
