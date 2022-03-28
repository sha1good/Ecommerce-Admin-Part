package com.adminportal.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date orderDate;
	
	private Date shippingDate;
	
	private String shippinMethod;
	
	private String orderStatus;
	
	private BigDecimal OrderTotal;
	
	public BigDecimal getOrderTotal() {
		return OrderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		OrderTotal = orderTotal;
	}

	@OneToMany(mappedBy="order",cascade= CascadeType.ALL)
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	private BillingAddress billingAddress;
	
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	@OneToOne(cascade=CascadeType.ALL)
	private Payment payment;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getShippinMethod() {
		return shippinMethod;
	}

	public void setShippinMethod(String shippinMethod) {
		this.shippinMethod = shippinMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//Many Order can belong to a user
	@ManyToOne
	private User user;
}
