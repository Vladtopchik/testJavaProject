package com.justvl.script.controller;

import com.justvl.script.dto.NoteForm;
import com.justvl.script.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final NoteService noteService;

    @GetMapping("/")
    public String viewIndex(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "index";
    }

    @PostMapping("/")
    public String handleIndex(@ModelAttribute NoteForm noteData) {
        noteService.saveNote(noteData);
        return "redirect:/";
    }
}
