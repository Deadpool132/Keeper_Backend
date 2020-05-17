package com.keeper.app.KeeperApp.exception;

public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(String s) {
        super(s);
    }
}
