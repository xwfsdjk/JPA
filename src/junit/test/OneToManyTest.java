package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.bean.Order;
import cn.itcast.bean.OrderItem;

public class OneToManyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Order order = new Order();
		order.setAmount(34f);
		order.setOrderId("111");
		OrderItem item = new OrderItem();
		item.setProductName("bailin");
		item.setSellPrice(30f);
		
		OrderItem item1 = new OrderItem();
		item1.setProductName("bailin1");
		item1.setSellPrice(30f);
		
		order.addOrderItem(item);
		order.addOrderItem(item1);
		em.persist(order);
		em.getTransaction().commit();
		factory.close();
	}

}
