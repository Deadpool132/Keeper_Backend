package com.keeper.app.KeeperApp.service.impl;


import com.keeper.app.KeeperApp.dto.NoteDto;
import com.keeper.app.KeeperApp.entity.NoteEntity;
import com.keeper.app.KeeperApp.repository.NoteRepository;
import com.keeper.app.KeeperApp.service.NoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<NoteDto> getAllNotes() {
        List<NoteDto> returnValue = new ArrayList<>();

        List<NoteEntity> noteEntities = noteRepository.findAll();
        for(NoteEntity noteEntity : noteEntities){
            NoteDto noteDto = new NoteDto();
            BeanUtils.copyProperties(noteEntity,noteDto);
            returnValue.add(noteDto);
        }

        return returnValue;
    }

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        NoteDto returnValue = new NoteDto();

        NoteEntity noteEntity = new NoteEntity();
        BeanUtils.copyProperties(noteDto,noteEntity);

        NoteEntity savedNote = noteRepository.save(noteEntity);
        BeanUtils.copyProperties(savedNote, returnValue);

        return returnValue;
    }

    @Override
    public void deleteNode(int id) {

        noteRepository.deleteById(id);

    }
}
