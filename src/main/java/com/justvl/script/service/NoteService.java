package com.justvl.script.service;

import com.justvl.script.dto.NoteForm;
import com.justvl.script.entity.Note;
import com.justvl.script.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note addNote(String name, String description) {
        Note note = new Note(name, description);
        return noteRepository.save(note);
    }

    public Note saveNote(NoteForm noteForm) {
        return addNote(
                noteForm.getName(), noteForm.getDescription()
        );
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
