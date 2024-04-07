package com.main.model;

import java.time.LocalDateTime; // Import for date and time handling

public class Notes {
    // Fields
    private int noteID;
    private String title;
    private LocalDateTime creationDateTime;
    private LocalDateTime lastEditDateTime;
    private String content;

    // Getters and setters
    public int getnoteID() {
        return noteID;
    }

    public void setnoteID(int ID) {
        this.noteID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public LocalDateTime getLastEditDateTime() {
        return lastEditDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.lastEditDateTime = LocalDateTime.now(); // Update last edit time when content is modified
    }

}

