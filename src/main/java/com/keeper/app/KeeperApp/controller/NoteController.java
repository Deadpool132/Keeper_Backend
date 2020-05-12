package com.keeper.app.KeeperApp.controller;

import com.keeper.app.KeeperApp.dto.NoteDto;
import com.keeper.app.KeeperApp.entity.NoteEntity;
import com.keeper.app.KeeperApp.model.request.NoteRequest;
import com.keeper.app.KeeperApp.model.response.NoteResponse;
import com.keeper.app.KeeperApp.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<NoteResponse> getNote(){
        List<NoteResponse> returnValue = new ArrayList<>();

        List<NoteDto> noteDtos = noteService.getAllNotes();
        for(NoteDto noteDto : noteDtos){
            NoteResponse noteResponse = new NoteResponse();
            BeanUtils.copyProperties(noteDto,noteResponse);
            returnValue.add(noteResponse);
        }

        return returnValue;
    }

    @PostMapping
    public NoteResponse addNote(@RequestBody NoteRequest noteRequest){
        NoteResponse returnValue = new NoteResponse();

        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(noteRequest,noteDto);

        NoteDto  createdNote = noteService.createNote(noteDto);
        BeanUtils.copyProperties(createdNote,returnValue);

        return returnValue;
    }

    @DeleteMapping
    public void deleteNote(@RequestParam int id){

        noteService.deleteNode(id);
    }
}
