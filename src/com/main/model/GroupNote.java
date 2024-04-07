package com.main.model;

public class GroupNote {
    public String getLast_edit_datetime() {
        return this.last_edit_datetime;
    }
    int groupNoteId;
    String title;
    String content;
    String creation_datetime;
    String last_edit_datetime;
    String created_by;
    String last_edited_by;

    public GroupNote(int groupNoteId, String title, String content, String creation_datetime, String last_edit_datetime, String created_by, String last_edited_by) {
        this.groupNoteId = groupNoteId;
        this.title = title;
        this.content = content;
        this.creation_datetime = creation_datetime;
        this.last_edit_datetime = last_edit_datetime;
        this.created_by = created_by;
        this.last_edited_by = last_edited_by;
    }

    public GroupNote() {

    }
    public String getCreated_by() {
        return created_by;
    }


    public int getGroupNoteId() {
        return groupNoteId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreation_datetime() {
        return creation_datetime;
    }

    public String getLast_edited_by() {
        return last_edited_by;
    }
}
