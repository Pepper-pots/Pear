package com.rev.dao;

import java.util.List;

import com.rev.entity.Playlist;

public interface PlaylistDAO {

//some of these methods
	//need to be modified based on user id
	 public void deletePlaylistById(long pid); 
	public Playlist fetchPlaylistById(long pid);
	List<Playlist> getAllPlaylist();
	void addPlaylist(Playlist playlist);
	void updatePlaylist(Playlist playlist);
}
