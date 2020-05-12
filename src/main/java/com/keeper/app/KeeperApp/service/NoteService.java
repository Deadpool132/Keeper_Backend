package com.keeper.app.KeeperApp.service;

import com.keeper.app.KeeperApp.dto.NoteDto;
import com.keeper.app.KeeperApp.entity.NoteEntity;

import java.util.List;

public interface NoteService {

    public List<NoteDto> getAllNotes();

    public NoteDto createNote(NoteDto noteDto);

    public void deleteNode(int id);

}
