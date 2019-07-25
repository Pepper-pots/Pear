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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Playlist")
@DynamicUpdate
public class Playlist {
	
@Id
@Column(name="pid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;

@Column(name="name",length=50)
 private String name;

@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@Fetch(value = FetchMode.SUBSELECT)
@JoinTable(name="playlist_library",
			joinColumns=@JoinColumn(name="pid"),
			inverseJoinColumns=@JoinColumn(name="lid"))
		private List<Library>  libraryEntries= new ArrayList<>();

public Playlist() {



}

public Playlist( String name, List<Library> libraryEntries) {

	this.name = name;
	this.libraryEntries = libraryEntries;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Library> getLibraryEntries() {
	return libraryEntries;
}

public void setLibraryEntries(List<Library> libraryEntries) {
	this.libraryEntries = libraryEntries;
}



}