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
	public Byte[] file; //����������
	
	private String imagePath;
	public Person(){
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * Id ʵ��ı�־
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
	 * Lob �������ı���������
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
	 * fetch LAZY �ӳټ������ڴ�����
	 * @return
	 */
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	public Byte[] getFile() {
		return file;
	}

	/**
	 * @Transient �����־û��ֶ�
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
