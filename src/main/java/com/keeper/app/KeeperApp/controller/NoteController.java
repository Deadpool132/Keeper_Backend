package com.keeper.app.KeeperApp.controller;

import com.keeper.app.KeeperApp.entity.Note;
import com.keeper.app.KeeperApp.api.request.NoteRequest;
import com.keeper.app.KeeperApp.api.response.NoteResponse;
import com.keeper.app.KeeperApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id){
        Optional<Note> noteResponse = noteService.getById(id);
        return new ResponseEntity<>(noteResponse, OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {

        List<NoteResponse> notesResponse = noteService.getAll().stream().map(Note::toNoteResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(notesResponse, OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody NoteRequest noteRequest) {
        Note note = noteService.add(noteRequest.toNote());
        return new ResponseEntity<>(note.toNoteResponse(), CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {

        noteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
