package org.devdom.api.model.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.Direction;
import org.eclipse.persistence.annotations.NamedStoredProcedureQueries;
import org.eclipse.persistence.annotations.NamedStoredProcedureQuery;
import org.eclipse.persistence.annotations.StoredProcedureParameter;

/**
 *
 * @author Carlos Vasquez Polanco
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="Group.search_group", 
                                procedureName="search_group",
                                returnsResultSet=true,
                                resultClass=GroupInformation.class,
                                parameters={@StoredProcedureParameter(queryParameter="find",
                                                                      name="find",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                )
})
public class GroupInformation implements Serializable {
    
    @Column(name = "group_id")
    @Id
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

