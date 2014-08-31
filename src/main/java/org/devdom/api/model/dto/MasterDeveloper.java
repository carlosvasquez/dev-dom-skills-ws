package org.devdom.api.model.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Entity
@XmlRootElement
public class MasterDeveloper implements Serializable {
    
    @Id
    private final Long id = 1L;
    
    @OneToMany
    private List<Skills> skills;
    
    @OneToMany
    private List<DeveloperInformation> developers;
    
    @OneToMany
    private List<University> university;

    @OneToOne
    private Pagination pagination;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the skills
     */
    public List<Skills> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    /**
     * @return the developers
     */
    public List<DeveloperInformation> getDevelopers() {
        return developers;
    }

    /**
     * @param developers the developers to set
     */
    public void setDevelopers(List<DeveloperInformation> developers) {
        this.developers = developers;
    }

    /**
     * @return the pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * @return the university
     */
    public List<University> getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(List<University> university) {
        this.university = university;
    }
    
    
}
