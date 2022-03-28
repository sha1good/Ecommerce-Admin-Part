package com.adminportal.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adminportal.domain.ssecurity.Authority;
import com.adminportal.domain.ssecurity.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User implements UserDetails {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id",nullable=false,updatable=false)
private Long id;	
private String username;

private String password;

private String firstName;
private String lastName;
private String phone;

@OneToOne(cascade=CascadeType.ALL,mappedBy="user")
private ShoppingCart shoppingCart;

@Column(name="email",nullable=false,updatable=false)
private String email;
private boolean enabled=true;

@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
@JsonIgnore
private Set<UserRole> useRole= new HashSet<>();

@OneToMany(cascade= CascadeType.ALL,mappedBy="user")
private List<UserShipping> userShippingList;

@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
private List<UserPayment> userPaymentList;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public Set<UserRole> getUseRole() {
	return useRole;
}
public void setUseRole(Set<UserRole> useRole) {
	this.useRole = useRole;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	   Set<GrantedAuthority> auth= new HashSet<>();
	   //this is a Stream used to add the authority for  the users' Roles
	   useRole.forEach(ur ->auth.add(new Authority(ur.getRole().getName())));
	   
	return auth;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	return enabled;
}
public List<UserShipping> getUserShippingList() {
	return userShippingList;
}
public void setUserShippingList(List<UserShipping> userShippingList) {
	this.userShippingList = userShippingList;
}
public List<UserPayment> getUserPaymentList() {
	return userPaymentList;
}
public void setUserPaymentList(List<UserPayment> userPaymentList) {
	this.userPaymentList = userPaymentList;
}
public ShoppingCart getShoppingCart() {
	return shoppingCart;
}
public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
}



}
