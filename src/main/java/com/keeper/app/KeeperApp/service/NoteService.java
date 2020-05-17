package com.keeper.app.KeeperApp.service;

import com.keeper.app.KeeperApp.entity.Note;
import com.keeper.app.KeeperApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Optional<Note> getById(long id) {
        return noteRepository.findById(id);
    }

    public List<Note> getAll() {

        return noteRepository.findAll();
    }

    public Note add(Note note) {

        return noteRepository.save(note);
    }

    public void delete(long id) {

        noteRepository.deleteById(id);
    }
}
