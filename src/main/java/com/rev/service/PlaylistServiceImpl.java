package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rev.dao.PlaylistDAO;

import com.rev.entity.Playlist;

@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistDAO pd;

	@Override
	@Transactional

	public Playlist getPlaylistById(long pid) {
		return pd.fetchPlaylistById(pid);
	}

	@Override
	@Transactional
	public void deletePlaylistById(long pid) {
		 pd.deletePlaylistById(pid);
		
	}

	@Override
	@Transactional
	public List<Playlist> listAllPlaylists() {
		// TODO Auto-generated method stub
		return pd.getAllPlaylist();
	}

	@Override
	@Transactional
	public void createPlaylist(Playlist playlist) {
		pd.addPlaylist(playlist);
		
	}

	@Override
	@Transactional
	public void updatePlaylist(Playlist playlist) {
		pd.updatePlaylist(playlist); 
		
	}
	

}
