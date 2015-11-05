package junit.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import cn.itcast.bean.Gender;
import cn.itcast.bean.Person;

public class PersonTest {

	
	@Test
	public void save() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Person person = new Person("wanfa");
		Date date = new Date(91,2,15);
		person.setBirthday(date);
		person.setGender(Gender.MAN);
		manager.persist(person);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	@Test
	public void getPerson() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		
//		Person person = manager.find(Person.class, 13); //直接去数据库查询 得到对象get
		Person person = manager.getReference(Person.class, 13); // load 只会生成一个代理类不会去数据库查询
		System.out.println(person.getName());
		manager.close();
//		System.out.println(person.getName());
		factory.close();
	}
	
	@Test
	public void update() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Person person = manager.find(Person.class, 13); //直接去数据库查询 得到对象get
//		Person person = manager.getReference(Person.class, 1); // load 只会生成一个代理类不会去数据库查询
		person.setName("bailin");
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void delete() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Person person = manager.find(Person.class, 13); //直接去数据库查询 得到对象get
//		Person person = manager.getReference(Person.class, 1); // load 只会生成一个代理类不会去数据库查询
		manager.remove(person);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	/**
	 * 位置参数 ？1  命名参数：name
	 */
	@Test
	public void query() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("select p from Person p where p.id = :pid");
		query.setParameter("pid", 27);
		Person person = (Person )query.getSingleResult();
		System.out.println(person);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void updateQuery() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("update Person p set p.name=:name where p.id=:id");
		
		query.setParameter("name", "bailinaa");
		query.setParameter("id", 27);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void deleteQuery() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("delete from Person p  where p.id=:id");
		query.setParameter("id", 28);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
}
