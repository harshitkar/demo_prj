package model;

import com.main.DAO.DataBaseHelper;

import javax.xml.crypto.Data;

public class user_Group {
    public user_Group(String groupId, String groupName, String dateJoined) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.dateJoined = dateJoined;
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        this.creator = dataBaseHelper.getCreator(groupId);
        unseenCount = dataBaseHelper.getUnseenCount(groupId);
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

}
