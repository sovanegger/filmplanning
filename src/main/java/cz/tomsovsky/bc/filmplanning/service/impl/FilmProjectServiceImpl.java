package cz.tomsovsky.bc.filmplanning.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ckeditor.CKEditorConfig;

import cz.tomsovsky.bc.filmplanning.dto.CrewMember;
import cz.tomsovsky.bc.filmplanning.dto.FilmProject;
import cz.tomsovsky.bc.filmplanning.dto.User;
import cz.tomsovsky.bc.filmplanning.repository.CrewMemberDao;
import cz.tomsovsky.bc.filmplanning.repository.FilmProjectDao;
import cz.tomsovsky.bc.filmplanning.service.FilmProjectService;

/**
 * Servisní třída entity <code>FilmProject</code>
 * 
 * @author Martin Tomšovský
 */
@Service(value="filmProjectService")
public class FilmProjectServiceImpl implements FilmProjectService {
	@Autowired
	private FilmProjectDao filmProjectDao;
	@Autowired
	private CrewMemberDao crewMemberDao;

	@Override
	@Transactional
	//@PreAuthorize(value="hasPermission(#filmProject, 'ADMINISTRATION')")
	public void saveFilmProject(FilmProject filmProject) {
		filmProject = prepareFilmProject(filmProject);
		filmProjectDao.save(filmProject);
	}

	@Override
	@Transactional
	@PreAuthorize(value="hasPermission(#filmProject, 'ADMINISTRATION')")
	public void updateFilmProject(FilmProject filmProject) {
		filmProjectDao.update(filmProject);
	}

	@Override
	@Transactional
	@PostAuthorize("hasPermission(returnObject, 'ADMINISTRATION')")
	public FilmProject getFilmProjectById(long id) {
		return filmProjectDao.getById(id);
	}

	@Override
	@Transactional
	public void deleteFilmProject(long id) {
		filmProjectDao.delete(getFilmProjectById(id));
	}

	@Override
	@Transactional
	@PreAuthorize("hasPermission(#filmProject, 'ADMINISTRATION')")
	public void deleteFilmProject(FilmProject filmProject) {
		filmProjectDao.delete(filmProject);		
	}
	
	@Override
	@Transactional
	public void updateScreenplay(long id, String screenplay) {
		filmProjectDao.updateScreenplay(id, screenplay);
	}
	
	@Override
	public CKEditorConfig configScreenplayEditor() {
		CKEditorConfig settings = new CKEditorConfig();
		settings.addConfigValue("height", "500px");
		settings.addConfigValue("extraPlugins", "screenplayformat");
		return settings;
	}
	
	@Override
	@Transactional
	public Collection<CrewMember> getFilmProjectsCrewMembers(long filmProjectId) {
		return getFilmProjectsCrewMembers(filmProjectDao.getById(filmProjectId));
	}

	// TODO nejde ten LAZY fetch vyresit nejak elegantneji?
	@Override
	public Collection<CrewMember> getFilmProjectsCrewMembers(FilmProject filmProject) {
		Collection<CrewMember> crewMembers = new ArrayList<CrewMember>();
		for (CrewMember crewMember : filmProject.getCrewMembers()) {
			crewMembers.add(crewMember);
		}
		return crewMembers;
	}
	
	private FilmProject prepareFilmProject(FilmProject filmProject) {
		Collection<CrewMember> crewMembers = new ArrayList<CrewMember>();
		crewMembers.add(prepareOwningCrewMember(filmProject));
		filmProject.setCrewMembers(crewMembers);
		return filmProject;
	}
	
	private CrewMember prepareOwningCrewMember(FilmProject filmProject) {
		CrewMember crewMember = new CrewMember();
		crewMember.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		crewMember.setFilmProject(filmProject);
		return crewMember;
	}
	
	public CrewMemberDao getCrewMemberDao() {
		return crewMemberDao;
	}
	public void setCrewMemberDao(CrewMemberDao crewMemberDao) {
		this.crewMemberDao = crewMemberDao;
	}
	
	public FilmProjectDao getFilmProjectDao() {
		return filmProjectDao;
	}
	public void setFilmProjectDao(FilmProjectDao filmProjectDao) {
		this.filmProjectDao = filmProjectDao;
	}
}
