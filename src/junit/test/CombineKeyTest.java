package junit.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class CombineKeyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
//		EntityManager manager = factory.createEntityManager();
//		manager.getTransaction().begin();
//		
//		manager.close();
		factory.close();
	}
}
