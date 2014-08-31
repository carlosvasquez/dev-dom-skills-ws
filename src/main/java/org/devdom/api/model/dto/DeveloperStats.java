package org.devdom.api.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedStoredProcedureQuery( name="Developer.search_developers_profile", 
                                procedureName="search_developers_profile",
                                returnsResultSet=true,
                                resultClass=DeveloperStats.class,
                                parameters={@StoredProcedureParameter(queryParameter="fullname",
                                                                      name="fullname",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.search_top20", 
                                procedureName="search_top20",
                                returnsResultSet=true,
                                resultClass=DeveloperStats.class,
                                parameters={@StoredProcedureParameter(queryParameter="fullname",
                                                                      name="fullname",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                )
})
public class DeveloperStats extends DeveloperInformation{

    @Column(name = "current_rating")
    private double currentRating;
    
    @Column(name = "current_position")
    private short currentPosition;
    
    @Column(name = "group_id")
    private long groupId;
    
    @Column(name = "group_name")
    private String groupName;

    public double getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(double currentRating) {
        this.currentRating = currentRating;
    }

    public short getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(short currentPosition) {
        this.currentPosition = currentPosition;
    }

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

}
