package com.keeper.app.KeeperApp.api.response;

import java.sql.Time;

public class NoteResponse {

    private long id;
    private String title;
    private String content;
    private Time createdAt;
    private Time updatedAt;

    public NoteResponse() {
    }

    public NoteResponse(long id, String title, String content, Time createdAt, Time updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Time getCreatedAt() { return createdAt;}

    public Time getUpdatedAt() { return updatedAt; }
}
