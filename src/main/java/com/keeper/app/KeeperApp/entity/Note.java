package com.keeper.app.KeeperApp.entity;

import com.keeper.app.KeeperApp.api.response.NoteResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Objects;

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

    private Note(Builder builder) {
        id = builder.id;
        title = builder.title;
        content = builder.content;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
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

    public Note update(Note updateFrom) {
        if (Objects.nonNull(updateFrom.title))
            this.title = updateFrom.title;
        if (Objects.nonNull(updateFrom.content))
            this.content = updateFrom.content;
        return this;
    }

    public static final class Builder {

        private long id;
        private String title;
        private String content;
        private Time createdAt;
        private Time updatedAt;

        public Builder() {}

        public Builder withId(long val) {
            id = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withContent(String val) {
            content = val;
            return this;
        }

        public Builder withCreatedAt(Time val) {
            createdAt = val;
            return this;
        }

        public Builder withUpdatedAt(Time val) {
            updatedAt = val;
            return this;
        }

        public Note build() {
            return new Note(this);
        }
    }
}
