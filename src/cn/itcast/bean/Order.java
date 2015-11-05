package cn.itcast.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	private String orderId;
	private Float amount = 0f;
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	public Order() {
	}
	
	@Id @Column(length=12)
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@Column(nullable=false)
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},mappedBy="order",fetch=FetchType.LAZY)
	public Set<OrderItem> getItems() {
		return items;
	}
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);  // Î¬»¤¹ØÏµ
		items.add(orderItem);
	}
}
