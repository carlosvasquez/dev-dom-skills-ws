package org.devdom.api.model.dto;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
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
@Table(name = "dev_dom_likes")
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery( name="Developer.findDevelopersBySkillId", 
                                procedureName="findDevelopersBySkillId",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="skill_id",
                                                                      name="skill_id",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.findDeveloperById", 
                                procedureName="findDeveloperById",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="id",
                                                                      name="developer_id",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.findAllDevelopers", 
                                procedureName="findAllDevelopers",
                                returnsResultSet=true,
                                resultClass=Developer.class
                                ),
    @NamedStoredProcedureQuery( name="Developer.findAllDevelopersByFilters", 
                                procedureName="findAllDevelopersByFilters",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="first_name",
                                                                      name="first_name",
                                                                      direction=Direction.IN,
                                                                      type=String.class),
                                            @StoredProcedureParameter(queryParameter="last_name",
                                                                      name="last_name",
                                                                      direction=Direction.IN,
                                                                      type=String.class),
                                            @StoredProcedureParameter(queryParameter="sort",
                                                                      name="sort",
                                                                      direction=Direction.IN,
                                                                      type=String.class),
                                            @StoredProcedureParameter(queryParameter="limit",
                                                                      name="limit",
                                                                      direction=Direction.IN,
                                                                      type=Integer.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.findDevelopersByUniversityId", 
                                procedureName="findDevelopersByUniversityId",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="university_id",
                                                                      name="university_id",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.search_developers_profile", 
                                procedureName="search_developers_profile",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="fullname",
                                                                      name="fullname",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                ),
    @NamedStoredProcedureQuery( name="Developer.search_top20", 
                                procedureName="search_top20",
                                returnsResultSet=true,
                                resultClass=Developer.class,
                                parameters={@StoredProcedureParameter(queryParameter="fullname",
                                                                      name="fullname",
                                                                      direction=Direction.IN,
                                                                      type=String.class)}
                                )
})
public class Developer extends FacebookProfile{
    
    public long getUid(){
        return uid;
    }

    public void setUid(long uid){
        super.uid = uid;        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        super.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        super.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        super.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        super.sex = Sex.valueOf(sex).name();
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        super.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        super.email = email;
    }

    public String getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(String currentLocationId) {
        super.currentLocationId = currentLocationId;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        super.currentLocation = currentLocation;
    }

}
