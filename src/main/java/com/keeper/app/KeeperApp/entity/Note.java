package com.keeper.app.KeeperApp.entity;

import com.keeper.app.KeeperApp.api.response.NoteResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    @CreationTimestamp
    private Time createdAt;
    @UpdateTimestamp
    private Time updatedAt;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public long getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public NoteResponse toNoteResponse() {
        return new NoteResponse(this.id, this.title, this.content, this.createdAt, this.updatedAt);
    }
}
