package com.keeper.app.KeeperApp.api.request;

import com.keeper.app.KeeperApp.entity.Note;

import javax.validation.constraints.NotNull;

public class NoteRequest {

    @NotNull
    private String title;
    @NotNull
    private String content;

    public NoteRequest() {
    }

    public NoteRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note toNote() {
        return new Note.Builder().withTitle(title).withContent(content).build();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
