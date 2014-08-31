package org.devdom.api.model.dto;

import javax.persistence.Column;

/**
 *
 * @author Carlos Vasquez Polanco
 */
public class GroupInformation {
    
    @Column(name = "group_id")
    private long groupId;
    
    @Column(name = "group_name")
    private String groupName;
    
    @Column(name = "post_amount")
    private int postAmount;
    
    @Column(name = "comments_amount")
    private int commentsAmount;
    
    @Column(name = "min_interactions")
    private short minInteractions;
    
    @Column(name = "active_members_in_year")
    private short activeMembersInYear;
    
    @Column(name = "post_per_day")
    private byte postPerDay;
    
    @Column(name = "comments_per_day")
    private short commentsPerDay;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(int postAmount) {
        this.postAmount = postAmount;
    }

    public int getCommentsAmount() {
        return commentsAmount;
    }

    public void setCommentsAmount(int commentsAmount) {
        this.commentsAmount = commentsAmount;
    }

    public short getMinInteractions() {
        return minInteractions;
    }

    public void setMinInteractions(short minInteractions) {
        this.minInteractions = minInteractions;
    }

    public short getActiveMembersInYear() {
        return activeMembersInYear;
    }

    public void setActiveMembersInYear(short activeMembersInYear) {
        this.activeMembersInYear = activeMembersInYear;
    }

    public byte getPostPerDay() {
        return postPerDay;
    }

    public void setPostPerDay(byte postPerDay) {
        this.postPerDay = postPerDay;
    }

    public short getCommentsPerDay() {
        return commentsPerDay;
    }

    public void setCommentsPerDay(short commentsPerDay) {
        this.commentsPerDay = commentsPerDay;
    }

}

