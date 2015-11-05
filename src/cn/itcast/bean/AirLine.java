package cn.itcast.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AirLine {
	private AirLinePK id;
	private String name;
	
	@EmbeddedId
	public AirLinePK getId() {
		return id;
	}
	public void setId(AirLinePK id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
