package com.keeper.app.KeeperApp.service;

import com.keeper.app.KeeperApp.entity.Note;
import com.keeper.app.KeeperApp.exception.NoteNotFoundException;
import com.keeper.app.KeeperApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {

        return noteRepository.save(note);
    }

    public void delete(long id) {

        noteRepository.deleteById(id);
    }

    public Note update(long id, Note updateFrom) {
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NoteNotFoundException("No note found with given id "));
        Note updatdeNote = note.update(updateFrom);
        return noteRepository.save(updatdeNote);
    }
}
