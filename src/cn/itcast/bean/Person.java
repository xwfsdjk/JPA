package cn.itcast.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="Person")
public class Person {
	private Integer id;
	private String name;
	private Date birthday; // 1991-3-15
	private Gender gender;
	private String info;
	public Byte[] file; //二进制数据
	
	private String imagePath;
	public Person(){
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * Id 实体的标志
	 * IDENTITY (MYSQL)
	 * SEQUENCE (ORACALE)
	 * @return
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=10,nullable=true,name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Enumerated(EnumType.STRING)
	@Column(length=5)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Lob 声明大文本类型数据
	 * @return
	 */
	@Lob
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	/**
	 * fetch LAZY 延迟加载用于大数据
	 * @return
	 */
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	public Byte[] getFile() {
		return file;
	}

	/**
	 * @Transient 不被持久化字段
	 * @return
	 */
	@Transient
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
}
