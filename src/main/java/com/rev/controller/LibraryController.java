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

import com.rev.entity.Library;

import com.rev.service.LibraryService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	LibraryService ls;
	
	@GetMapping("/library_entries")
public List<Library> getLibrary() {
		
		List<Library> al=ls.listEntireLibrary();
		System.out.println("in  libcontroller all list()");
		System.out.println(al);
	return al;
}
	
	@RequestMapping(value="/library_entries/{id}", method=RequestMethod.GET) 
	public Library findLibraryEntryById(@PathVariable long id) {
		Library library=ls.getLibraryEntryById(id);
//		if(book==null) {
//		System.out.println(" Not found");	
//		}
		return library;
		
	}
	@RequestMapping(value="/library_entries/{title}", method=RequestMethod.GET) 
	public Library findLibraryEntryByName(@PathVariable String title) {
		Library library=ls.getLibraryEntryByTitle(title);
//		if(book==null) {
//		System.out.println(" Not found");	
//		}
		return library;
		
	}

	@PostMapping("/library_entries")
	public Library createLibraryEntry(@RequestBody Library library)
	{
		
		ls.createLibraryEntry(library);
	return library;
	
	 
}
	
	
}
