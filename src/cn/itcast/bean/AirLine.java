package cn.itcast.bean;

import javax.persistence.Entity;

@Entity
public class AirLine {
	private AirLinePK id;
	private String name;
	public AirLinePK getId() {
		return id;
	}
	public void setId(AirLinePK id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
