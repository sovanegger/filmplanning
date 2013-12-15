package cz.tomsovsky.bc.filmplanning.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.Type;

@Entity
@Table(name="tb_shots")
public class Shot implements IDomain {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Digits(fraction = 0, integer = 3, message="{error.shot.orderinscene.digits}")
	private int orderInScene;
	// TODO private Duration duration;
	
	@Lob
	@Type(type="org.hibernate.type.TextType")
	private String description;
	// TODO private Picture picture;
	
	@ManyToOne
	@JoinColumn(name="type")
	private ShotType type;
	
	@ManyToOne
	@JoinColumn(name="scene_id", nullable=false)
	private Scene scene;
	
	@Override
	public long getId() {
		return id;
	}

	public int getOrderInScene() {
		return orderInScene;
	}
	public void setOrderInScene(int orderInScene) {
		this.orderInScene = orderInScene;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public ShotType getType() {
		return type;
	}
	public void setType(ShotType type) {
		this.type = type;
	}

	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
