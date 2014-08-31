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
public class MasterSkillset implements Serializable {
    
    @Id
    private final Long id = 1L;
    
    @OneToMany
    private List<Category> category;
    
    @OneToMany
    private List<Skills> skills;
    
    @OneToMany
    private List<DeveloperInformation> developers;
    
    @OneToOne
    private Pagination pagination;

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
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

    public Long getId() {
        return id;
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
      
}
