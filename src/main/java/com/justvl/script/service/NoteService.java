package com.justvl.script.service;

import com.justvl.script.dto.NoteForm;
import com.justvl.script.entity.Note;
import com.justvl.script.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note addNote(String name, @Nullable String author, String description) {
        Note note = new Note(name, description);
        if (author != null) note.setAuthor(author);

        return noteRepository.save(note);
    }

    public Note addNote(String name, String description) {
        return addNote(name, null, description);
    }

    public Note saveNote(NoteForm noteForm) {
        return addNote(
                noteForm.getName(), noteForm.getDescription()
        );
    }

    public Note saveNote(NoteForm noteForm, String author) {
        return addNote(
                noteForm.getName(), author, noteForm.getDescription()
        );
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
}
