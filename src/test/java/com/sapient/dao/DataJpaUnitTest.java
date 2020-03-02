package com.sapient.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.model.Note;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DataJpaUnitTest {
 
	@Autowired
    private NoteRepository repository;


    @Test
    public void should_find_all_customersTest() {

        List<Note> notes = repository.findAll();
        System.out.println(notes.size());
        assertThat(notes).hasSizeGreaterThanOrEqualTo(2);
    }

}