package cz.tomsovsky.bc.filmplanning.security;

import cz.tomsovsky.bc.filmplanning.dto.FilmProject;

public class FilmProjectContext {
	private static FilmProject currentFilmProject;
	
	public static FilmProject getCurrentFilmProject() {
		return currentFilmProject;
	}
	
	public static void setCurrentFilmProject(FilmProject filmProject) {
		if (filmProject == null) {
			filmProject = null;
			return;
		}
		if (currentFilmProject == null || filmProject.getId() != currentFilmProject.getId())
			currentFilmProject = filmProject;
	}
}
