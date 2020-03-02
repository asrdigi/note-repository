package com.sapient.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.exception.ResourceNotFoundException;
import com.sapient.model.Note;
import com.sapient.service.INoteService;


@RestController 
@RequestMapping("/api") 
public class NoteController { 
	
	@Autowired 
	INoteService noteService;
	
	//Get All Notes 
	@GetMapping("/notes") 
	public List<Note> getAllNotes() {
		return noteService.getAllNotes(); 
	} 
	
	// Create a new Note @PostMapping("/notes") 
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note,
							BindingResult bindingResult,
								HttpServletRequest request) { 
		if(bindingResult.hasErrors()) {
			List<FieldError> fieldErrors= 
							bindingResult.getFieldErrors();			
			throw new ResourceNotFoundException(request.getRequestURL().toString(),
					bindingResult.getClass().getName(),fieldErrors.toString());
		}
		return noteService.createNote(note); 
	} 
	
	// Get a Single Note 
	@GetMapping("/notes/{id}") 
	public Note getNoteById(@PathVariable(value = "id") Long noteId) { 
		return noteService.getNoteById(noteId);
	} 

	// Update a Note 
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) { 
		return noteService.updateNote(noteId, noteDetails); 
	} 

	// Delete a Note 
	@DeleteMapping("/notes/{id}") 
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) { 
		return noteService.deleteNote(noteId); 
	} 
 } 