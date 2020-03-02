package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.model.Note;

@Repository 
public interface NoteRepository extends JpaRepository<Note, Long> { 


} 