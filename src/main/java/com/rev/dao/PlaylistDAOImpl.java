package com.rev.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;


import com.rev.entity.Playlist;




@Repository("playlistDAO")
public class PlaylistDAOImpl implements PlaylistDAO {

	@Autowired
	SessionFactory sessionFact;

	@Override
	public void deletePlaylistById(long pid) {
		Session session= sessionFact.getCurrentSession();
		Playlist playlist=session.byId(Playlist.class).load(pid);
			session.delete(playlist);
	}

	@Override
	public Playlist fetchPlaylistById(long pid) {
		Playlist playlist= sessionFact.getCurrentSession().get(Playlist.class, pid);
		return playlist;
	}

	@Override
	public List<Playlist> getAllPlaylist() {
		List<Playlist> playlists =new ArrayList<>();
		Query query= sessionFact.getCurrentSession().createQuery("from Playlist P");
		
		playlists=(ArrayList<Playlist>)query.getResultList();
		return playlists;
	}

	@Override
	public void addPlaylist(Playlist playlist) {
		
		sessionFact.getCurrentSession().saveOrUpdate(playlist);

		
	}

	@Override
	public void updatePlaylist(Playlist playlist) {
		sessionFact.getCurrentSession().update(playlist);
	}
	
	

}
