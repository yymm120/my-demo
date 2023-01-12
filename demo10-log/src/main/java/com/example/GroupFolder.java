package com.example;

import java.util.List;


public class GroupFolder {
    private String currentGroupName;
    private String currentGroupId;
    private List<Group> groups;

    public GroupFolder() {
    }

    public GroupFolder(String currentGroupName, String currentGroupId, List<Group> groups) {
        this.currentGroupName = currentGroupName;
        this.currentGroupId = currentGroupId;
        this.groups = groups;
    }

    public static class Group {

        private String groupName;
        private String groupId;
        private List<MyGiftListDescInfoData> lists;

        public Group(String groupName, String groupId, List<MyGiftListDescInfoData> lists) {
            this.groupName = groupName;
            this.groupId = groupId;
            this.lists = lists;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public List<MyGiftListDescInfoData> getLists() {
            return lists;
        }

        public void setLists(List<MyGiftListDescInfoData> lists) {
            this.lists = lists;
        }
    }


    public String getCurrentGroupName() {
        return currentGroupName;
    }

    public void setCurrentGroupName(String currentGroupName) {
        this.currentGroupName = currentGroupName;
    }

    public String getCurrentGroupId() {
        return currentGroupId;
    }

    public void setCurrentGroupId(String currentGroupId) {
        this.currentGroupId = currentGroupId;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}



