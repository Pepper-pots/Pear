package com.rev.service;

import java.util.List;

import com.rev.entity.Playlist;

public interface PlaylistService {
	
    public Playlist getPlaylistById(long pid);
	public void deletePlaylistById( long pid);
	List<Playlist> listAllPlaylists();
	void createPlaylist(Playlist playlist);
	void updatePlaylist(Playlist playlist);
}
