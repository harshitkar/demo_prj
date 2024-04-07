package com.main.model;

import com.main.DAO.UserGroupDAO;

public class userGroup {
    public userGroup(String groupId, String groupName, String dateJoined) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.dateJoined = dateJoined;
        UserGroupDAO dataBaseHelper = new UserGroupDAO();
        this.creator = dataBaseHelper.getCreator(groupId);
        lastPostDate = dataBaseHelper.getLastPostDate(groupId);
    }
    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public String getCreator() {
        return creator;
    }

    public int getUnseenCount() {
        return unseenCount;
    }

    public String getLastPostDate() {
        return lastPostDate;
    }

    String groupId;
    String groupName;
    String dateJoined;
    String creator;
    int unseenCount;
    String lastPostDate;
    int groupMemberId;
}
