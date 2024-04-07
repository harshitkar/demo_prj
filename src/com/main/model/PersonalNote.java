package com.main.model;

public class PersonalNote {

    public PersonalNote() {}
    // Fields
    private int noteID;
    private String title;

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setLastEditDateTime(String lastEditDateTime) {
        this.lastEditDateTime = lastEditDateTime;
    }

    private String creationDateTime;
    private String lastEditDateTime;
    private String content;

    public String getTitle() {
        return title;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public String getLastEditDateTime() {
        return lastEditDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
