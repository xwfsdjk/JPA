package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.bean.Student;
import cn.itcast.bean.Teacher;

public class ManyToManyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student("wanfa");
		Teacher teacher = new Teacher("tang");
		em.persist(student);
		em.persist(teacher);
		student.addTeacher(teacher);
		em.getTransaction().commit();
		factory.close();
	}
	
	@Test
	public void deleteTS() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 41);
		Teacher teacher = em.getReference(Teacher.class, 42);
		student.removeTeacher(teacher);
		em.getTransaction().commit();
		factory.close();
	}

	@Test
	public void deleteTeacher() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Teacher teacher = em.getReference(Teacher.class, 42);
		em.remove(teacher);
		em.getTransaction().commit();
		factory.close();
	}
	
	/**
	 * 学生是关系维护方 删除学生自动更新 关系表
	 */
	@Test
	public void deleteStudent() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.getReference(Student.class, 43);
		em.remove(student);
		em.getTransaction().commit();
		factory.close();
	}
	
}
