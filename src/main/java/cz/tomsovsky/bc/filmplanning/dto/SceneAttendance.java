package cz.tomsovsky.bc.filmplanning.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_sceneattendances")
public class SceneAttendance implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="scene_id", nullable=false)
	private Scene scene;
	
	@ManyToOne
	@JoinColumn(name="crewmember_id", nullable=false)
	private CrewMember crewMember;
	
	@ManyToOne
	@JoinColumn(name="character_id")
	private Character character;
	
	@Override
	public long getId() {
		return id;
	}
	
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public CrewMember getCrewMember() {
		return crewMember;
	}
	public void setCrewMember(CrewMember crewMember) {
		this.crewMember = crewMember;
	}
}
