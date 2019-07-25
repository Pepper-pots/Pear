package com.rev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
//@DynamicUpdate(true)
@Entity
@Table(name="pear_user")
public class User {
	
@Id
@Column(name="userId")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long userId;

@Column(name="userName",length=50)
private String userName;

@Column(name="password",length=100)
private String password;

@Column(name="firstName",length=50)
private String firstName;

@Column(name="lastName",length=50)
private String lastName;

@Column(name="email",length=50)
private String email;


@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinTable(name="user_playlist",
			joinColumns=@JoinColumn(name="userId"),
			inverseJoinColumns=@JoinColumn(name="pid"))
		private List<Playlist>  playlists= new ArrayList<>();


public User() {
	
}


public User(String userName, String password, String firstName, String lastName, String email,
		List<Playlist> playlists) {

	this.userName = userName;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.playlists = playlists;
}


public long getUserId() {
	return userId;
}


public void setUserId(long userId) {
	this.userId = userId;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
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


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public List<Playlist> getPlaylists() {
	return playlists;
}


public void setPlaylists(List<Playlist> playlists) {
	this.playlists = playlists;
}


@Override
public String toString() {
	return "Playlist2 [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
			+ firstName + ", lastName=" + lastName + ", email=" + email + ", playlists=" + playlists + "]";
}


}