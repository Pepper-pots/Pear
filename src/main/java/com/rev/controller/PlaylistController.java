package com.rev.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.rev.entity.Playlist;
import com.rev.service.PlaylistService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlaylistController {

	@Autowired
	PlaylistService ps;
	
	@GetMapping("/playlists")
public List<Playlist> getPlaylists() {
		
		List<Playlist> playlists=ps.listAllPlaylists();
		System.out.println("in   playlistcontroller all list()");
		System.out.println(playlists);
	return playlists;
}
//	
	@RequestMapping(value="/playlists/{id}", method=RequestMethod.GET) 
	public Playlist findPlaylistById(@PathVariable long id) {
		Playlist playlist=ps.getPlaylistById(id);
		return playlist;		
	}
	
	@PostMapping("/playlists")
	public Playlist createPlaylist(@RequestBody Playlist playlist)
	{System.out.println("reached 1");
		ps.createPlaylist(playlist);
		System.out.println("reached");
	    return playlist; 
}
	@PutMapping("/playlists")	
	public Playlist updatePlaylist(@RequestBody Playlist playlist)
	{System.out.println("update called");
		System.out.println(playlist.getLibraryEntries());
		ps.updatePlaylist(playlist);;
	return playlist;
		
	 
}
//	 
//}
//	
	
}
