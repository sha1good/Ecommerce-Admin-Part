package com.adminportal.domain.ssecurity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.adminportal.domain.User;

@Entity
public class PasswordResetToken {

	private static final int EXPIRATION= 60*24;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private Date expiryDate;
	
	private String token;
	
	@OneToOne(targetEntity=User.class,fetch= FetchType.EAGER)
	@JoinColumn(nullable=false, name="user_id")
	private User user;
	
	public PasswordResetToken() {
		
	}
	
	public PasswordResetToken(String token,User user) {
		 super();
		 this.token=token;
		 this.user=user;
		 this.expiryDate= calculateExpiryDate(EXPIRATION);
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
	   final Calendar cal= Calendar.getInstance();		
		   cal.setTimeInMillis(new Date().getTime());
		   cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}
	
	
	public void updateToken(final String token) {
		this.token=token;
		this.expiryDate= calculateExpiryDate(EXPIRATION);;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}

	@Override
	public String toString() {
		return "PasswordResetToken [Id=" + Id + ", expiryDate=" + expiryDate + ", token=" + token + ", user=" + user
				+ "]";
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
