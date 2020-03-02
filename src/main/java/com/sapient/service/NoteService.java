package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.dao.NoteRepository;
import com.sapient.exception.ResourceNotFoundException;
import com.sapient.model.Note;


@Service
public class NoteService implements INoteService{
	
	@Autowired
	NoteRepository noteRepository;
	
	
	public List<Note> getAllNotes() {
		return noteRepository.findAll(); 
	} 
	
	
	public Note createNote(Note note) { 
		return noteRepository.save(note); 
	} 
	

	public Note getNoteById(Long noteId) { 
		return noteRepository
				.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId)); 
	} 

	
	public Note updateNote(Long noteId,Note noteDetails) { 
		Note note = noteRepository
				.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId)); 
		note.setTitle(noteDetails.getTitle()); 
		note.setContent(noteDetails.getContent()); 
		Note updatedNote = noteRepository.save(note); 
		return updatedNote; 
	} 

	
	public ResponseEntity<?> deleteNote(Long noteId) { 
		Note note = noteRepository
				.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId)); 
		noteRepository.delete(note); 
		return ResponseEntity.ok().build(); 
	} 
}
